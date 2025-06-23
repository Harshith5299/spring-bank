package com.example.bank2.service;

import com.example.bank2.client.ClientService;
import com.example.bank2.dto.*;
import com.example.bank2.entity.AccountEntity;
import com.example.bank2.exception.*;
import com.example.bank2.mapper.Mapper;
import com.example.bank2.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Indicates that this class is a service component in the Spring context
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ClientService clientService;

    @Override
    public Dto createAccount(CreateDto createDto) throws DuplicateEmailException {
        Optional<AccountEntity> checkEmail = accountRepository.findByEmail(createDto.getEmail());
        if(checkEmail.isPresent()){
            throw new DuplicateEmailException("Email already exists, use a different one");
        }
        AccountEntity accountEntity = new AccountEntity(createDto.getFirstName(), createDto.getLastName(),
                createDto.getEmail(), createDto.getCashDeposit());
        accountEntity = accountRepository.save(accountEntity);
        return Mapper.mapToDto(accountEntity);
    }

    @Override
    public Dto updateAccount(UpdateDto updateDto) throws DuplicateEmailException, AccountNotFoundException, InactiveAccountException {
        Optional<AccountEntity> accountFinder = accountRepository.findById(updateDto.getAccountId());
        if(accountFinder.isEmpty()){throw new AccountNotFoundException("Account doesn't exist, try a different Id");}

        List<AccountEntity> duplicateEmailChecker = accountRepository.findByEmailExceptCurrent(updateDto.getAccountId(),
                updateDto.getEmail());
        if(!duplicateEmailChecker.isEmpty()){throw new DuplicateEmailException("This email already exists. Please " +
                "enter existing email if you do not want to change it, or enter another email that is not in use");}

        if(!accountFinder.get().isAccountStatus()){
            throw new InactiveAccountException("Cannot update Inactive Account");
        }

        // Update and save
        AccountEntity accountEntity = accountFinder.get();
        accountEntity.setFirstName(updateDto.getFirstName());
        accountEntity.setLastName(updateDto.getLastName());
        accountEntity.setEmail(updateDto.getEmail());
        accountEntity = accountRepository.save(accountEntity);
        return Mapper.mapToDto(accountEntity);
    }

    @Override
    public Dto retrieveAccount(RetrieveDto retrieveDto) throws AccountNotFoundException{
        // Check if the account exists using the accountId from retrieveDto in the repository using findById method from JpaRepository
        AccountEntity accountEntity = accountRepository.findById(retrieveDto.getAccountId()).orElseThrow(
                ()->new AccountNotFoundException("Account doesn't exist, try a different Id"));

        return Mapper.mapToDto(accountEntity);
    }

    @Override
    public Dto deleteAccount(DeleteDto deleteDto) throws AccountNotFoundException, InactiveAccountException{
        Optional<AccountEntity> accountFinder = accountRepository.findById(deleteDto.getAccountId());
        if(accountFinder.isEmpty()){throw new AccountNotFoundException("accountId doesn't exist, try a different Id");}
        if(!accountFinder.get().isAccountStatus()){throw new InactiveAccountException("This Account is already inactive. Try another account");}
        AccountEntity accountEntity = accountFinder.get();
        accountEntity.setAccountStatus(false);
        accountEntity= accountRepository.save(accountEntity);
        return Mapper.mapToDto(accountEntity);
    }

    @Override
    public Dto withdrawMoney(WithdrawDto withdrawDto) throws AccountNotFoundException, LowBalanceException , InactiveAccountException{
        Optional<AccountEntity> accountFinder = accountRepository.findById(withdrawDto.getAccountId());
        if(accountFinder.isEmpty()){throw new AccountNotFoundException("accountId doesn't exist, try a different Id");}
        if(!accountFinder.get().isAccountStatus()){throw new InactiveAccountException("Unable to withdraw as this " +
                "Account is no longer active. Try another account");}
        AccountEntity accountEntity = accountFinder.get();
        if (accountEntity.getBalance() < withdrawDto.getCashWithdrawalAmount()){
            throw new LowBalanceException("Balance is too low, Balance= "+accountEntity.getBalance()
                    + " Requested withdrawal amount= " + withdrawDto.getCashWithdrawalAmount());
        }
        accountEntity.setBalance(accountEntity.getBalance()- withdrawDto.getCashWithdrawalAmount());
        accountEntity= accountRepository.save(accountEntity);
        return Mapper.mapToDto(accountEntity);
    }

    @Override
    public Dto depositMoney(DepositDto depositDto) throws AccountNotFoundException , InactiveAccountException{
        Optional<AccountEntity> accountFinder = accountRepository.findById(depositDto.getAccountId());
        if(accountFinder.isEmpty()){throw new AccountNotFoundException("accountId doesn't exist, try a different Id");}
        if(!accountFinder.get().isAccountStatus()){throw new InactiveAccountException("Unable to deposit as this "
                +"Account is no longer active. Try another account");}
        AccountEntity accountEntity = accountFinder.get();
        accountEntity.setBalance(accountEntity.getBalance()+ depositDto.getCashDepositAmount());
        accountEntity= accountRepository.save(accountEntity);
        return Mapper.mapToDto(accountEntity);
    }

    @Override
    public String transferMoney(TransferDto transferDto) throws AccountNotFoundException,
            LowBalanceException, InactiveAccountException, BadRequestException {

        Optional<AccountEntity> senderAccountFinder = accountRepository.findById(transferDto.getSenderAccountId());
        if(senderAccountFinder.isEmpty()){throw new AccountNotFoundException("SenderAccountId doesn't exist, try a different Id");}

        if(!senderAccountFinder.get().isAccountStatus()){throw new InactiveAccountException("Unable to transfer as the sender "
                +"Account is inactive. Try another account");}

        Optional<AccountEntity> receiverAccountFinder = accountRepository.findById(transferDto.getReceiverAccountId());
        if(receiverAccountFinder.isEmpty()){throw new AccountNotFoundException("ReceiverAccountId doesn't exist, try a different Id");}

        if(!receiverAccountFinder.get().isAccountStatus()){throw new InactiveAccountException("Unable to transfer as the receiver "
                +"Account is inactive. Try another account");}

        AccountEntity senderAccountEntity = senderAccountFinder.get();
        AccountEntity receiverAccountEntity = receiverAccountFinder.get();

        if(senderAccountEntity.getBalance()<transferDto.getTransferAmount()){throw new LowBalanceException("Sender Balance is " +
                "too low, Balance= "+ senderAccountEntity.getBalance() +" Requested transfer amount= " + transferDto.getTransferAmount());}


        ResponseEntity<?> withdrawResponse = clientService.withdrawRequest(transferDto);
        ResponseEntity<?> depositResponse = clientService.depositRequest(transferDto);

        if(withdrawResponse.getStatusCode()== HttpStatus.BAD_REQUEST){
            throw new BadRequestException("Internal Server error: Sent bad withdraw request to client API. Check client's controller Url, " +
                    "headers, body and Request Entity. Received response:" + withdrawResponse.getBody() );
        }
        else if (depositResponse.getStatusCode() == HttpStatus.BAD_REQUEST) {
            throw new BadRequestException("Internal Server error: Sent bad deposit request to client API. Check client's controller Url, " +
                    "headers, body and Request Entity. Received response:" + depositResponse.getBody());
        }

        Object withdrawDto = withdrawResponse.getBody();
        Object depositDto = depositResponse.getBody();

        if(withdrawDto instanceof WithdrawDto && depositDto instanceof DepositDto){
            return "Transfer Successful, check the account Ids to confirm the transfer";
        }else {
            throw new BadRequestException("Internal Server error: Received incorrect response from client API, " +
                    "check withdrawResponse body:" + withdrawResponse.getBody() + " and checkDepositResponse body: "
                    + depositResponse.getBody());
        }

    }

}

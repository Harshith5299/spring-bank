package com.example.bank2.service;

import com.example.bank2.dto.*;
import com.example.bank2.exception.*;
import org.springframework.stereotype.Service;

@Service
public interface AccountService {

    public Dto createAccount(CreateDto createDto) throws DuplicateEmailException;

    public Dto updateAccount(UpdateDto updateDto) throws DuplicateEmailException, AccountNotFoundException, InactiveAccountException;

    public Dto retrieveAccount(RetrieveDto retrieveDto) throws AccountNotFoundException;

    public Dto deleteAccount(DeleteDto deleteDto) throws AccountNotFoundException, InactiveAccountException;

    public  Dto depositMoney(DepositDto depositDto) throws AccountNotFoundException,InactiveAccountException;

    public Dto withdrawMoney(WithdrawDto withdrawDto) throws AccountNotFoundException, LowBalanceException, InactiveAccountException;

    public String transferMoney(TransferDto transferDto) throws AccountNotFoundException,
    LowBalanceException, InactiveAccountException, BadRequestException;
}

package com.example.bank2.controller;

import com.example.bank2.dto.*;
import com.example.bank2.exception.*;
import com.example.bank2.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController // Indicates that this class is a REST controller, handling HTTP requests and returning JSON responses.
public class Controller {

    @Autowired // Injects the AccountService bean into this controller for dependency management.
    private AccountService accountService;

    @GetMapping(value="/bank2/helloWorld") // Maps HTTP GET requests to the helloWorld() method.
    public String helloWorld(){
        return "Hello World";
    }

    @PostMapping(value="/bank2/createAccount") // Maps HTTP POST requests to the createAccount() method.
    public ResponseEntity<?> createAccount(@Validated @RequestBody CreateDto createDto){//Using a Dto implementation for Validation purposes
        try {
            Dto createdAccount = accountService.createAccount(createDto);
            return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
        }catch (DuplicateEmailException duplicateEmailException){
            return new ResponseEntity<>(duplicateEmailException.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value="/bank2/retrieveAccount") // Maps HTTP GET requests to the retrieveAccount() method.
    public ResponseEntity<?> retrieveAccount(@Validated @RequestBody RetrieveDto retrieveDto){
        try {
            Dto retrieveAccount = accountService.retrieveAccount(retrieveDto);
            return new ResponseEntity<>(retrieveAccount, HttpStatus.OK);
        }catch (AccountNotFoundException accountNotFoundException){
            return new ResponseEntity<>(accountNotFoundException.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value="/bank2/updateAccount") // Maps HTTP PUT requests to the updateAccount() method.
    public ResponseEntity<?> updateAccount(@Validated @RequestBody UpdateDto updateDto){
        try {
            Dto retrieveAccount = accountService.updateAccount(updateDto);
            return new ResponseEntity<>(retrieveAccount, HttpStatus.OK);
        }catch (AccountNotFoundException | DuplicateEmailException | InactiveAccountException exception){
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value="/bank2/deleteAccount") // Maps HTTP DELETE requests to the deleteAccount() method.
    public ResponseEntity<?> deleteAccount(@Validated @RequestBody DeleteDto deleteDto){
        try {
            Dto deleteAccount = accountService.deleteAccount(deleteDto);
            return new ResponseEntity<>(deleteAccount, HttpStatus.OK);
        }catch (AccountNotFoundException | InactiveAccountException exception){
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value="/bank2/depositMoney") // Maps HTTP POST requests to the depositMoney() method.
    public ResponseEntity<?> depositMoney(@Validated @RequestBody DepositDto depositDto){

        try {
            Dto depositMoney = accountService.depositMoney(depositDto);
            return new ResponseEntity<>(depositMoney, HttpStatus.ACCEPTED);
        }catch (AccountNotFoundException | InactiveAccountException exception){
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value="/bank2/withdrawMoney") // Maps HTTP POST requests to the withdrawMoney() method.
    public ResponseEntity<?> withdrawMoney(@Validated @RequestBody WithdrawDto withdrawDto){
        try {
            Dto withdrawMoney = accountService.withdrawMoney(withdrawDto);
            return new ResponseEntity<>(withdrawMoney, HttpStatus.OK);
        }catch (AccountNotFoundException | InactiveAccountException | LowBalanceException exception){
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value="/bank2/transferMoney")
    public ResponseEntity<?> transferMoney(@Validated @RequestBody TransferDto transferDto){
        try {
            String transferMoney = accountService.transferMoney(transferDto);
            return new ResponseEntity<>(transferMoney, HttpStatus.OK);
        }catch (AccountNotFoundException | InactiveAccountException | LowBalanceException exception){
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (BadRequestException badRequestException){
            return new ResponseEntity<>(badRequestException.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @GetMapping(value = "/bank2/transactionHistory")
//    public ResponseEntity<?> transactionHistory(@Validated @RequestBody RetrieveDto retrieveDto){
//        try{
//
//        }catch (AccountNotFoundException accountNotFoundException){
//            return new ResponseEntity<>(accountNotFoundException.getMessage(), HttpStatus.BAD_REQUEST);
//        }
//
//    }

}

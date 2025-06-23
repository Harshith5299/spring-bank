package com.example.bank2.exception;

public class AccountNotFoundException extends Exception{

    public AccountNotFoundException(String message) {
        super(message);
    }
}

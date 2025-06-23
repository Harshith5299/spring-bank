package com.example.bank2.exception;

public class LowBalanceException extends Exception{

    public LowBalanceException(String message) {
        super(message);
    }
}

package com.example.bank2.exception;

public class TransferLimitException extends Exception{

    public TransferLimitException(String message) {
        super(message);
    }
}

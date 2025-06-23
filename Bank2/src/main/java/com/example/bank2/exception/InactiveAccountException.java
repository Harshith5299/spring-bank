package com.example.bank2.exception;

public class InactiveAccountException extends Exception{

    public InactiveAccountException(String message) {
        super(message);
    }
}
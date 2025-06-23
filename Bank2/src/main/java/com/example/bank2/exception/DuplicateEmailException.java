package com.example.bank2.exception;

public class DuplicateEmailException extends Exception{

    public DuplicateEmailException(String message) {
        super(message);
    }
}

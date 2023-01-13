package com.example.demo.exception;

public class UserNotFoundInDBException extends RuntimeException {
    public UserNotFoundInDBException(String message) {
        super(message);
    }
}

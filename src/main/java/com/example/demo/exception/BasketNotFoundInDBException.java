package com.example.demo.exception;

public class BasketNotFoundInDBException extends RuntimeException {
    public BasketNotFoundInDBException(String message) {
        super(message);
    }
}

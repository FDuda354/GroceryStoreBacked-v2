package com.example.demo.exception;

public class ProductNotFoundInDBException extends RuntimeException {
    public ProductNotFoundInDBException(String message) {
        super(message);
    }
}

package com.example.demo.exception;

public class ProductNotFoundInBasketException extends RuntimeException {
    public ProductNotFoundInBasketException(String message) {
        super(message);
    }
}

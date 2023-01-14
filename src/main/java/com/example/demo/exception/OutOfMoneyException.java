package com.example.demo.exception;

public class OutOfMoneyException extends RuntimeException {
    public OutOfMoneyException(String message) {
        super(message);
    }
}

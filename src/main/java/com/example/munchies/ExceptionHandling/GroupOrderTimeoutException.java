package com.example.munchies.ExceptionHandling;

public class GroupOrderTimeoutException extends Exception {
    public GroupOrderTimeoutException(String message) {
        super(message);
    }
}

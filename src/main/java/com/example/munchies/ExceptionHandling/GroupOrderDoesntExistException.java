package com.example.munchies.ExceptionHandling;

public class GroupOrderDoesntExistException extends Exception {
    public GroupOrderDoesntExistException(String message){super(message);}
}

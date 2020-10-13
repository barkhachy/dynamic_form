package com.example.demo.exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String id)
    {
        super(String.format("User with ID %s not found", id));
    }
}

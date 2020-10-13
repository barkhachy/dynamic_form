package com.example.demo.exceptions;

public class ResponseNotFoundException extends RuntimeException {
    public ResponseNotFoundException()
    {
        super("No response Found");
    }
}

package com.example.demo.exceptions;

/**
 * Exception when Form with provided id is not found
 */
public class FormNotFoundException extends RuntimeException{

    public FormNotFoundException(String id)
    {
        super(String.format("Form with ID %s not found", id));
    }

}

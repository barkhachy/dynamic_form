package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex, WebRequest request)
    {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "User Not found");

        return new ResponseEntity<>(body , HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<Object> handleNoDataFoundException(NoDataFoundException ex, WebRequest request)
    {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "Data Not found");

        return new ResponseEntity<>(body , HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(FormNotFoundException.class)
    public ResponseEntity<Object> handleFormNotFoundException(FormNotFoundException ex, WebRequest request)
    {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "Form Not found");

        return new ResponseEntity<>(body , HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ResponseNotFoundException.class)
    public ResponseEntity<Object> handleResponseNotFoundException(ResponseNotFoundException ex, WebRequest request)
    {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "Responses Not found");

        return new ResponseEntity<>(body , HttpStatus.NOT_FOUND);

    }
}

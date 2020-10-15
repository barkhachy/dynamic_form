package com.example.demo.Controller;

import com.example.demo.dto.ErrorResponseDto;
import com.example.demo.exceptions.FormNotFoundException;
import com.example.demo.exceptions.NoDataFoundException;
import com.example.demo.exceptions.ResponseNotFoundException;
import com.example.demo.exceptions.UserNotFoundException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.OverridesAttribute;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

    /**
     * Global Error handling controller
     */
    @Order(Ordered.HIGHEST_PRECEDENCE)
    @ControllerAdvice
    public class ControllerAdvisor extends ResponseEntityExceptionHandler {

        /**
         * To handle exception for invalid request body
         * @param ex
         * @param headers
         * @param status
         * @param request
         * @return
         */
        @Override
        protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
            List<String> details = new ArrayList<>();
            for (ObjectError error : ex.getBindingResult().getAllErrors()) {
                details.add(error.getDefaultMessage());
            }
            ErrorResponseDto error = new ErrorResponseDto(HttpStatus.BAD_REQUEST.toString(), details.toString());
            return new ResponseEntity<>(error, HttpStatus.OK);
        }

        /**
         * Exception when user is not found with given id in database
         * @param ex
         * @param request
         * @return
         */
        @ExceptionHandler(UserNotFoundException.class)
        public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex, WebRequest request)
        {
            ErrorResponseDto error = new ErrorResponseDto(HttpStatus.BAD_REQUEST.toString(), "User not found");
            return new ResponseEntity<>(error , HttpStatus.NOT_FOUND);
        }

        /**
         * Exception when data is not found
         * @param ex
         * @param request
         * @return
         */
        @ExceptionHandler(NoDataFoundException.class)
        public ResponseEntity<Object> handleNoDataFoundException(NoDataFoundException ex, WebRequest request)
        {
            ErrorResponseDto error = new ErrorResponseDto(HttpStatus.BAD_REQUEST.toString(), "Data not found");
            return new ResponseEntity<>(error , HttpStatus.NOT_FOUND);
        }


        /**
         * Exception when form is not found
         * @param ex
         * @param request
         * @return
         */
        @ExceptionHandler(FormNotFoundException.class)
        public ResponseEntity<Object> handleFormNotFoundException(FormNotFoundException ex, WebRequest request)
        {

            ErrorResponseDto error = new ErrorResponseDto(HttpStatus.BAD_REQUEST.toString(), "Form not found");
            return new ResponseEntity<>(error , HttpStatus.NOT_FOUND);
        }

        /**
         * When response is not found
         * @param ex
         * @param request
         * @return
         */
        @ExceptionHandler(ResponseNotFoundException.class)
        public ResponseEntity<Object> handleResponseNotFoundException(ResponseNotFoundException ex, WebRequest request)
        {

            ErrorResponseDto error = new ErrorResponseDto(HttpStatus.BAD_REQUEST.toString(), "Response not found");
            return new ResponseEntity<>(error , HttpStatus.NOT_FOUND);

        }


    }


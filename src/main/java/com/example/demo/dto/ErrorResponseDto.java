package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;

/**
 * Error response dto
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)

public class ErrorResponseDto {

    private final Date timestamp;
    private final String status;
    private final String message;

    public ErrorResponseDto(String status, String message)
    {
        this.timestamp = new Date();
        this.status = status;
        this.message = message;
    }


}

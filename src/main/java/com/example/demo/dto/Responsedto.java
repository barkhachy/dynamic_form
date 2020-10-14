package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Response dto
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Responsedto {

    private final Date timestamp;
    private final String status;
    private final String message;
    private Object data;

    public Responsedto(String status, String message, Object data)
    {
        this.status=status;
        this.message=message;
        this.data=data;
        this.timestamp=new Date();
    }

}

package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a response object
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Response {


    private String formid;
    private String userid;

    // List of answers of all questions for provided form_id
    private List<resp> arr;
}

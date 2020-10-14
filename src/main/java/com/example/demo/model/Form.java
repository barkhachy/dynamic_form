package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.*;
import java.util.Objects;

/**
 * Represents a form
 */
@Document
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Form {

    @Id
    private String formid;
    List <Questions> qstn_list = new ArrayList<>();
    private String uid;
}

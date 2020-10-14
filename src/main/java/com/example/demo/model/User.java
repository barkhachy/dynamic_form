package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

/**
 *  Represents a User
 */
@Document
@AllArgsConstructor
@Getter
@Setter
public class User
{
    @Id
    private String id;
    private String name;
    private String e_mail;

}
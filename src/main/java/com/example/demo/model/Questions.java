package com.example.demo.model;
import com.example.demo.utils.Qtype;
import lombok.AllArgsConstructor;
import lombok.Getter;
import java.io.Serializable;
import java.util.*;

/**
 * Represents a question
 */
@Getter
@AllArgsConstructor
public class Questions implements Serializable {

    private Qtype type;
    private String qstn;
    private ArrayList<String> options;
}

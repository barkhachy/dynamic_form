package com.example.demo.model;
import com.example.demo.utils.Qtype;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.*;

/**
 * Represents a question
 */
@Getter
@AllArgsConstructor
public class Questions implements Serializable {

    @NotNull(message = "Type of question should be given")
    private Qtype type;
    @NotNull(message = "Question Text should be given")
    private String qstn;
    private ArrayList<String> options;
}

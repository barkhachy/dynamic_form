package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.example.demo.utils.Qtype;
import java.io.Serializable;

/**
 * Represents a answer
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class resp implements Serializable {

    private Qtype type;
    private String ans;

}

package com.example.demo.dto.model;

import com.example.demo.model.Questions;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FormDto {
    private String formid;
    private String uid;
    private List<Questions> qstn_list;

}

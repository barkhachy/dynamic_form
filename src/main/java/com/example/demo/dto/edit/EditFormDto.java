package com.example.demo.dto.edit;

import com.example.demo.model.Questions;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class EditFormDto {

    private String uid;
    private List<Questions> qstn_list;
}

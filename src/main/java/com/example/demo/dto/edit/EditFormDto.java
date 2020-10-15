package com.example.demo.dto.edit;

import com.example.demo.model.Questions;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class EditFormDto {

    @NotNull(message = "Creator id should be supplied")
    private String uid;
    @Valid
    @NotNull(message = "Questions should be present in the form")
    private List<Questions> qstn_list;
}

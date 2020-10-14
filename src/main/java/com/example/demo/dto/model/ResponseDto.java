package com.example.demo.dto.model;

import com.example.demo.model.resp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ResponseDto {
    private String formid;
    private String userid;
    private List<resp> arr;
}

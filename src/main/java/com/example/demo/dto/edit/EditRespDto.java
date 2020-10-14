package com.example.demo.dto.edit;

import com.example.demo.model.resp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class EditRespDto {

    private String formid;
    private String uid;
    private List<resp> resp_list;
}

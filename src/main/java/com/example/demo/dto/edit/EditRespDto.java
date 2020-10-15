package com.example.demo.dto.edit;

import com.example.demo.model.resp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class EditRespDto {

    @NotNull
    private String formid;
    @NotNull
    private String uid;
    @Valid
    @NotNull(message = "All responses should be given")
    private List<resp> resp_list;
}

package com.example.demo.dto.edit;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotNull;
import javax.validation.Valid;

@Getter
@Setter
@AllArgsConstructor
public class EditUserDto {

    @NotNull(message = "User name should not be empty")
    private String name;
    @NotNull(message = "E_mail should not be empty")
    private String e_mail;
}

package com.example.demo.dto.mapper;

import com.example.demo.dto.edit.EditFormDto;
import com.example.demo.dto.model.FormDto;
import com.example.demo.model.Form;

/**
 * Form Mapper to transform Form to FormDto and vice versa
 */

public class FormMapper {

    public static FormDto FormToFormDto(Form form)
    {
        FormDto formDto = new FormDto(form.getFormid(), form.getUid(), form.getQstn_list());
        return formDto;
    }

    public static Form FormDtoToForm(EditFormDto formDto)
    {
        Form form = new Form(null, formDto.getQstn_list(), formDto.getUid());
        return form;
    }
}

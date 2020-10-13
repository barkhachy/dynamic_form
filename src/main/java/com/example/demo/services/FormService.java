package com.example.demo.services;

import com.example.demo.model.Form;

import java.util.List;

public interface FormService {

    public Form create(final Form form);
    public Form findByformid(final String form_id);
    Form findByuid(final String user_id);

    List<Form> findall();
    Form update(Form form);
    void delete(final String form_id);
}

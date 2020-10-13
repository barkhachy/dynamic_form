package com.example.demo.services;

import com.example.demo.model.Response;

import java.util.List;

public interface ResponseService {

    Response create(final Response response);
    Response update(Response response);
    List<Response> all(String formid);
}

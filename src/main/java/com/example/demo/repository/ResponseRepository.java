package com.example.demo.repository;

import com.example.demo.model.Response;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ResponseRepository extends MongoRepository<Response, String> {

}

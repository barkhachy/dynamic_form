package com.example.demo.repository;
import com.example.demo.model.Form;
import com.example.demo.model.Questions;
import org.springframework.data.mongodb.repository.MongoRepository;
public interface FormRepository extends MongoRepository<Form, String> {

}

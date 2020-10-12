package com.example.demo.repository;
import com.example.demo.model.Form;
import com.example.demo.model.Questions;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FormRepository extends MongoRepository<Form, String> {

    /**
     * A abstract method to get form on providing the form_id
     * @param id
     * @return Form object
     */
    public Form findByform_id(String id);

    /**
     * A abstract method to get form based on creator_id
     * @param id
     * @return A Form object
     */
    public Form findByu_id(String id);


}

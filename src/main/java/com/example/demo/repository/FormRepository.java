package com.example.demo.repository;
import com.example.demo.model.Form;
import com.example.demo.model.Questions;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FormRepository extends MongoRepository<Form, String> {

    public List<Form> findAll();
    /**
     * A abstract method to get form on providing the form_id
     * @param formid
     * @return Form object
     */
   public Form findByformid(String formid);

    /**
     * A abstract method to get form based on creator_id
     * @param uid
     * @return A Form object
     */
    public Form findByuid(String uid);


}
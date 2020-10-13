package com.example.demo.repository;

import com.example.demo.model.Response;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ResponseRepository extends MongoRepository<Response, String> {

    /**
     * A abstract method to get list all responses for particular form
     * @param form_id
     * @return List of response object
     */

     public List<Response> findByformid(String form_id);

    /**
     * A abstract method to get list of all responses from particular user_id
     * @param user_id
     * @return List of response object
     */
     public List<Response> findByuserid(String user_id);

}

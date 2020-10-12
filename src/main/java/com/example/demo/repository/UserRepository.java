package com.example.demo.repository;
import com.example.demo.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    /**
     * A abstract method to get details of user based on provided user_id
     * @param id
     * @return User object
     */
    public User findByid(String id);
}

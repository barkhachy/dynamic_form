/**package com.example.demo;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserDetails implements CommandLineRunner{
    private static final Logger logger = LoggerFactory.getLogger(UserDetails.class);
    @Autowired
    private UserRepository repository;

    @Override
    public void run(String... args) throws Exception{
        repository.deleteAll();

        repository.save(new User("barkha","barkha11@gmail.com"));
        repository.findAll().forEach((User)->{
            logger.info("{}",User);
        });
    }
}**/
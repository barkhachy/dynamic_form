/**package com.example.demo;

import com.example.demo.model.*;
import com.example.demo.repository.FormRepository;
import com.example.demo.repository.ResponseRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ResponseDetails implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(ResponseDetails.class);

    @Autowired
    private ResponseRepository repository;

    @Override
    public void run(String... args) throws Exception {
       // repository.deleteAll();

        // User u1 = new User("barkha", "barkha11@gmail.com");
        resp r1 = new resp(Qtype.DATE, "11-02-1999");
        resp r2 = new resp(Qtype.MCQ, "1 years");
        ArrayList<resp> arr = new ArrayList<>();
        arr.add(r1);
        arr.add(r2);
        Response r = repository.save(new Response("5f801160142a17760ccc6dc2", "5f7feeb8c1f52d2613e4fd93", arr));
        System.out.println(r);
        repository.findAll().forEach((Response) -> {
            logger.info("{}", Response);
        });

    }
}
//relation**/
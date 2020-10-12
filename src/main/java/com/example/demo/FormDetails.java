/**package com.example.demo;

import com.example.demo.model.Form;
import com.example.demo.model.Qtype;
import com.example.demo.model.User;
import com.example.demo.model.Questions;
import com.example.demo.repository.FormRepository;
import com.example.demo.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class FormDetails implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(FormDetails.class);

    @Autowired
    private FormRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.deleteAll();

       // User u1 = new User("barkha", "barkha11@gmail.com");
        Questions q1 = new Questions(Qtype.DATE, "Enter your DOB");
        ArrayList<String> optns = new ArrayList<>();
        optns.add("0 years");
        optns.add("1 years");
        optns.add("2 years");
        optns.add("3 years");
        Questions q2 = new Questions(Qtype.MCQ, "What is your experience", optns);
        ArrayList<Questions> arr = new ArrayList<>();
        arr.add(q1);
        arr.add(q2);
        Form f = repository.save(new Form("5f7feeb8c1f52d2613e4fd98",arr));
        System.out.println(f);
        repository.findAll().forEach((Form) -> {
            logger.info("{}", Form);
        });

    }
}**/
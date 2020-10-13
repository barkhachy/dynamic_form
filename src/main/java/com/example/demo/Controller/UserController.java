package com.example.demo.Controller;


import com.example.demo.model.User;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List<User> findAll()
    {
        List<User> users = userService.findAll();
        ArrayList<User> users_list = new ArrayList<User>();
        for(User u: users)
        {
            users_list.add(u);
        }
        return users;
    }
}

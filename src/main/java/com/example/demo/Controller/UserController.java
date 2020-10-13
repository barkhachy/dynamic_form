package com.example.demo.Controller;


import com.example.demo.exceptions.NoDataFoundException;
import com.example.demo.model.User;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value ="/user/{id}", method = RequestMethod.GET)
    public User get_user(@PathVariable(value="id") String id)
    {
        return userService.findByid(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value="/user/{id}", method = RequestMethod.PUT)
    public User update_user(@PathVariable(value="id") String id, @RequestBody User user)
    {
        User ans;
        if(userService.findByid(id)!=null)
        {
            ans = userService.update(user);
        }
        else
        {
            throw new NoDataFoundException();
        }
        return ans;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value="/user" , method = RequestMethod.POST)
    public User add_user(@RequestBody User user)
    {
        return userService.create(user);
    }

}

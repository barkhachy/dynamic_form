package com.example.demo.service;

import com.example.demo.dto.edit.EditFormDto;
import com.example.demo.dto.edit.EditUserDto;
import com.example.demo.dto.model.FormDto;
import com.example.demo.dto.model.UserDto;
import com.example.demo.exceptions.UserNotFoundException;
import com.example.demo.model.Form;
import com.example.demo.model.Questions;
import com.example.demo.model.User;
import com.example.demo.services.FormService;
import com.example.demo.utils.Qtype;
import org.junit.Assert;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.*;

/**
 * To perform test on User Service
 */
@SpringBootTest
@DirtiesContext
public class UserServiceIntegrationTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private FormService formService;

    @Test
    public void testCreateGetUpdateDeleteUser()
    {
        // *** Creating the user
        UserDto user = userService.createUser(getUser());

        // *** GET ***
        Assert.assertEquals(userService.getDetails(user.getId()).getName(),"barkha");

        // *** UPDATE ***
        userService.updateUser(new EditUserDto("Barkha K",""), user.getId());
        Assert.assertEquals(userService.getDetails(user.getId()).getName(),"Barkha K");

        // *** DELETE ***
        userService.delete(user.getId());
        boolean flag = false;
        try {
            Assert.assertEquals(userService.getDetails(user.getId()), null);
        }
        catch(UserNotFoundException ex)
        {
            flag=true;
        }
        // *** If flag value changes to true then UserService is correctly working
        Assert.assertEquals(flag,true);

    }

    /**
     * To create a user data
     * @return
     */
    private EditUserDto getUser()
    {
        EditUserDto user = new EditUserDto("barkha","barkha11199");
        return user;
    }


}

package com.example.demo.services;

import com.example.demo.exceptions.NoDataFoundException;
import com.example.demo.exceptions.UserNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Implementaion of User Service interface
 */
@Service
public class UserServiceImpl implements UserService{

    private static final Logger LOGGER  = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public User create(User user)
    {
        if(LOGGER.isDebugEnabled())
        {
            LOGGER.info("Creating a User");
        }
        return userRepository.save(user);
    }

    @Override
    public User findByid(String id)
    {
        if(LOGGER.isDebugEnabled())
        {
            LOGGER.info("Finding a user with given id");
        }
        User user = userRepository.findByid(id);
        if(user==null) {
            throw new UserNotFoundException(id);
        }
        return user;
    }

    @Override
    public List<User> findAll()
    {
        if(LOGGER.isDebugEnabled())
        {
            LOGGER.info("Finding all users");
        }
        List<User> ans = userRepository.findAll();
        if(ans.isEmpty())
        {
            throw new NoDataFoundException();
        }
        return ans;
    }

    @Override
    public User update(User user)
    {
        if(LOGGER.isDebugEnabled())
        {
            LOGGER.info("Updating a user");
        }
        return userRepository.save(user);
    }

    @Override
    public void delete(String id)
    {
        if(LOGGER.isDebugEnabled())
        {
            LOGGER.info("Deleting the user");
        }
        userRepository.deleteById(id);
    }



}

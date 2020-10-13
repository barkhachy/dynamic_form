package com.example.demo.services;


import com.example.demo.model.User;

import java.util.List;

public interface UserService {

    User create(final User user);
    User findByid(final String id);
    List<User> findAll();
    User update(User user);
    void delete(final String id);

}

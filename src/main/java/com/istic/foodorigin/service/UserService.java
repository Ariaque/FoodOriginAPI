package com.istic.foodorigin.service;

import com.istic.foodorigin.models.User;
import com.istic.foodorigin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepositoy;

    public Iterable<User> getAllUsers() {
        Iterable<User> users = userRepositoy.findAll();
        return users;
    }

    public User saveUser (User user) {
        return userRepositoy.save(user);
    }
}

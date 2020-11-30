package com.istic.foodorigin.service;

import com.istic.foodorigin.models.User;
import com.istic.foodorigin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Iterable<User> getAllUsers() {
        Iterable<User> users = userRepository.findAll();
        return users;
    }

    public User findUserByEmail(String email) {
        User user = null;
        boolean found = false;
        Iterable<User> users = userRepository.findAll();
        Iterator<User> it = users.iterator();
        while (!found && it.hasNext()) {
            user = it.next();
            if(user.getUsername().equals(email)) {
                found = true;
            }
        }
        return user;
    }


    public User saveUser (User user) {
        return userRepository.save(user);
    }
}

package com.istic.foodorigin.controller;

import com.istic.foodorigin.models.User;
import com.istic.foodorigin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/all", produces = "application/json")
    public Set<User> getAllLabel() {
        Iterable<User> itLab = userService.getAllUsers();
        return StreamSupport.stream(itLab.spliterator(), false).collect(Collectors.toSet());
    }

}

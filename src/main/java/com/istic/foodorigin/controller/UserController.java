package com.istic.foodorigin.controller;

import com.istic.foodorigin.models.User;
import com.istic.foodorigin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/all", produces = "application/json")
    public Set<User> getAllUsers() {
        Iterable<User> itLab = userService.getAllUsers();
        return StreamSupport.stream(itLab.spliterator(), false).collect(Collectors.toSet());
    }

    @PostMapping(path = "/save", consumes = "application/json")
    public String saveUser(@RequestBody User user) {
        userService.saveUser(user);
        return "Utilisateur ajouté";
    }

}

package com.istic.foodorigin.controller;

import com.istic.foodorigin.models.User;
import com.istic.foodorigin.payload.response.MessageResponse;
import com.istic.foodorigin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Point of contact allowing client applications
 * to retrieve information about user's data's in database in the form {@link User}.
 */
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

    @GetMapping(path = "/users", produces = "application/json")
    public Set<User> getAllRoleUser() {
        Iterable<User> itLab = userService.getAllRoleUser();
        return StreamSupport.stream(itLab.spliterator(), false).collect(Collectors.toSet());
    }

    @PostMapping(path = "/save", consumes = "application/json", produces = "application/json")
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @PostMapping(path = "/delete", consumes = "application/json")
    public ResponseEntity<?> deleteUser(@RequestBody User user) {
        boolean ret = userService.deleteUser(user);
        if (ret) {
            return ResponseEntity.ok(new MessageResponse("User deleted !"));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body(new MessageResponse("User not deleted !"));
        }
    }

    @GetMapping(path = "/{name}", produces = "application/json")
    public User getUserByName(@PathVariable String name) {
        return userService.getUserByName(name);
    }

    @GetMapping(path = "/transfo/{siret}", produces = "application/json")
    public User getUserBySiretTransfo(@PathVariable String siret) {
        return userService.getUserBySiretTransfo(siret);
    }

    @GetMapping(path = "isActive/{siret}", produces = "application/json")
    public Boolean getUserStateBySiret(@PathVariable String siret) {
        Boolean result = false;
        User user = userService.getUserBySiretTransfo(siret);
        if (user != null) {
            result = user.getIsEnabled();
        }
        return result;
    }
}

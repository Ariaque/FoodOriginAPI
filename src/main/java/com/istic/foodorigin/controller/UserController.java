package com.istic.foodorigin.controller;

import com.istic.foodorigin.models.User;
import com.istic.foodorigin.payload.request.LoginRequest;
import com.istic.foodorigin.payload.response.JwtResponse;
import com.istic.foodorigin.payload.response.MessageResponse;
import com.istic.foodorigin.security.services.UserDetailsImpl;
import com.istic.foodorigin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import java.util.UUID;

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

    @PostMapping(path = "/save", consumes = "application/json", produces = "application/json")
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
//        return "Utilisateur ajouté";
    }

}

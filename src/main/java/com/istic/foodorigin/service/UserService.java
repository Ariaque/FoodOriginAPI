package com.istic.foodorigin.service;

import com.istic.foodorigin.model.User;
import com.istic.foodorigin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User loadUserByMail (String email) throws Exception{
        final Optional<User> optionalUser = userRepository.findUserByEmail(email);

        if (optionalUser.isPresent()) {
            return optionalUser.get();
        }
        throw new Exception(MessageFormat.format("User not find", email));
    }
}

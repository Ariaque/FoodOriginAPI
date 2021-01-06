package com.istic.foodorigin.service;

import com.istic.foodorigin.models.User;
import com.istic.foodorigin.repository.PasswordResetTokenRepository;
import com.istic.foodorigin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Iterator;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordResetTokenRepository passwordResetTokenRepository;

    @Autowired
    PasswordEncoder encoder;

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

    public User getUserByName (String username) {
        User user = null;
        Optional<User> ret = userRepository.findByUsername(username);
        if (ret.isPresent()) {
            user = ret.get();
        }
        return user;
    }

    public Optional<User> getUserByPasswordResetToken(final String token) {
        return Optional.ofNullable(passwordResetTokenRepository.findByToken(token).getUser());
    }

    public void changeUserPassword(final User user, final String password) {
        user.setPassword(encoder.encode(password));
        userRepository.save(user);
    }
}

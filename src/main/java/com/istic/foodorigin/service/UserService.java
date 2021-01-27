package com.istic.foodorigin.service;

import com.istic.foodorigin.models.ERole;
import com.istic.foodorigin.models.PasswordResetToken;
import com.istic.foodorigin.models.Transformateur;
import com.istic.foodorigin.models.User;
import com.istic.foodorigin.repository.PasswordResetTokenRepository;
import com.istic.foodorigin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

/**
 * Class which calls {@link UserRepository} and processes information returned.
 */
@Service
public class UserService {

    @Autowired
    PasswordEncoder encoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordResetTokenRepository passwordResetTokenRepository;

    public Iterable<User> getAllUsers() {
        Iterable<User> users = userRepository.findAll();
        return users;
    }

    public Iterable<User> getAllRoleUser() {
        Iterable<User> users = userRepository.findByRole(ERole.ROLE_USER);
        return users;
    }

    public User saveUser(User user) {
        User ret = null;
        if (user != null) {
            ret = userRepository.save(user);
        }
        return ret;
    }

    public User getUserByName(String username) {
        User user = null;
        if (username != null) {
            Optional<User> ret = userRepository.findByUsername(username);
            if (ret.isPresent()) {
                user = ret.get();
            }
        }
        return user;
    }

    public Transformateur getTransformateurByUserName(String userName) {
        Transformateur ret = null;
        if(userName != null) {
            Optional<User> user = userRepository.findByUsername(userName);
            ret = user.get().getTransformateur();
        }
        return ret;
    }

    public HashMap<String, String> getUserInfosByUserName(String userName) {
        HashMap<String, String> infosMap = null;
        if(userName != null) {
            Optional<User> user = userRepository.findByUsername(userName);
            infosMap = new HashMap<>();
            infosMap.put("id", user.get().getId().toString());
            infosMap.put("role", user.get().getRole().getName().name());
            if(user.get().getRole().getName().equals(ERole.ROLE_USER)) {
                infosMap.put("phoneNumber", user.get().getNumeroTelephone());
                infosMap.put("typeTransformateur", user.get().getTypeTransformateur().getLibelle());
            }
        }
        return infosMap;
    }

    public User getUserBySiretTransfo(String siret) {
        User user = null;
        if (siret != null) {
            Optional<User> ret = userRepository.findUserBySiret(siret);
            if (ret.isPresent()) {
                user = ret.get();
            }
        }
        return user;
    }

    public boolean deleteUser(User user) {
        boolean delete = false;
        if (user != null) {
            if (userRepository.existsByUsername(user.getUsername())) {
                List<PasswordResetToken> tokens = passwordResetTokenRepository.findByFkUser(user.getId());
                passwordResetTokenRepository.deleteAll(tokens);
                userRepository.delete(user);
                delete = true;
            }
        }
        return delete;
    }

    public Optional<User> getUserByPasswordResetToken(final String token) {
        return Optional.ofNullable(passwordResetTokenRepository.findByToken(token).getUser());
    }

    public User changeUserPassword(final User user, final String password) {
        User ret = null;
        if (password != null && userRepository.existsByUsername(user.getUsername())) {
            user.setPassword(encoder.encode(password));
            ret = userRepository.save(user);
        }
        return ret;
    }
}

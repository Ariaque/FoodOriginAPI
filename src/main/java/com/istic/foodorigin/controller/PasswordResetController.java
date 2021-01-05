package com.istic.foodorigin.controller;

import com.istic.foodorigin.exception.UserNotFoundException;
import com.istic.foodorigin.models.PasswordResetToken;
import com.istic.foodorigin.models.User;
import com.istic.foodorigin.payload.request.SavePasswordRequest;
import com.istic.foodorigin.payload.request.SendEmailRequest;
import com.istic.foodorigin.payload.response.MessageResponse;
import com.istic.foodorigin.repository.PasswordResetTokenRepository;
import com.istic.foodorigin.repository.UserRepository;
import com.istic.foodorigin.security.services.PasswordResetService;
import com.istic.foodorigin.security.services.ResetEmailService;
import com.istic.foodorigin.security.services.UserDetailsImpl;
import com.istic.foodorigin.security.services.UserDetailsServiceImpl;
import com.istic.foodorigin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.parameters.P;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/reset")
public class PasswordResetController {

    @Autowired
    UserService userService;

    @Autowired
    PasswordResetService passwordResetService;

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    ResetEmailService resetEmailService;

    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    UserRepository userRepository;

    @Autowired
    private PasswordResetTokenRepository passwordResetTokenRepository;

    private String token;


    @RequestMapping(value = "/resetPassword/sendEmail",
            method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public ResponseEntity<?> sendEmail(HttpServletRequest request, @RequestBody SendEmailRequest sendEmailRequest) throws UserNotFoundException {
        User user = userService.findUserByEmail(sendEmailRequest.getEmail());
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }
        String token = UUID.randomUUID().toString();
        passwordResetService.createPasswordResetTokenForUser(user, token);
        javaMailSender.send(resetEmailService.constructResetTokenEmail("http://localhost:4200/api/reset/resetPassword/changePassword",
                request.getLocale(), token, user));
        return ResponseEntity.ok(new MessageResponse("Email sent to user!"));
    }

    @RequestMapping(value = "/resetPassword/changePassword", method = RequestMethod.GET)
    public ResponseEntity<?> resetPassword(@RequestParam("id") long id, @RequestParam("token") String token) {

        this.token = passwordResetService.validatePasswordResetToken(id, token);

        return ResponseEntity.ok(new MessageResponse("New password offer has been sent!"));

    }

    @RequestMapping(value = "/resetPassword/savePassword", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public ResponseEntity<?> savePassword(@Valid @RequestBody SavePasswordRequest savePasswordRequest) {
        if(!token.isEmpty()) {
            System.out.println(token);
            PasswordResetToken passwordResetToken = passwordResetTokenRepository.findByToken(token);
            Optional<User> user = userService.getUserByPasswordResetToken(savePasswordRequest.getToken());
            user.ifPresent(value -> userService.changeUserPassword(value, savePasswordRequest.getNewPassword()));
            passwordResetTokenRepository.delete(passwordResetToken);
        }

        /*String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println(userName);
        User user = userService.findUserByEmail(userName);
        System.out.println(user.getUsername());
        user.setPassword(savePasswordRequest.getNewPassword());
        userRepository.save(user);*/

        return ResponseEntity.ok(new MessageResponse("Password has been changed!"));
    }
}

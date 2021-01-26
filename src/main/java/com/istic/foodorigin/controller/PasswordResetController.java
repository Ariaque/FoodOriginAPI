package com.istic.foodorigin.controller;

import com.google.gson.Gson;
import com.istic.foodorigin.exception.UserNotFoundException;
import com.istic.foodorigin.models.PasswordResetToken;
import com.istic.foodorigin.models.User;
import com.istic.foodorigin.payload.request.ChangePasswordRequest;
import com.istic.foodorigin.payload.request.SavePasswordRequest;
import com.istic.foodorigin.payload.request.SendSimpleEmailRequest;
import com.istic.foodorigin.payload.response.MessageResponse;
import com.istic.foodorigin.repository.PasswordResetTokenRepository;
import com.istic.foodorigin.repository.UserRepository;
import com.istic.foodorigin.security.services.PasswordResetService;
import com.istic.foodorigin.security.services.ResetEmailService;
import com.istic.foodorigin.security.services.UserDetailsServiceImpl;
import com.istic.foodorigin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

/**
 * Point of contact allowing client applications
 * to make requests concerning password reset.
 */
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


    /**
     * Sends an email to the user to allow him to reset his password if forgotten.
     * @param request {@link HttpServletRequest}
     * @param sendSimpleEmailRequest {@link SendSimpleEmailRequest}
     * @return {@link ResponseEntity}
     * @throws UserNotFoundException Thrown when the user has not been found.
     */
    @RequestMapping(value = "/resetPassword/sendEmail",
            method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public ResponseEntity<?> sendEmail(HttpServletRequest request, @RequestBody SendSimpleEmailRequest sendSimpleEmailRequest) throws UserNotFoundException {
        User user = userService.getUserByName(sendSimpleEmailRequest.getEmail());
        if (user == null) {
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("User with this email does not exist");
        }
        String token = UUID.randomUUID().toString();
        passwordResetService.savePasswordResetTokenForUser(user, token);
        javaMailSender.send(resetEmailService.constructResetTokenEmail("http://localhost:4200/resetPassword",
                request.getLocale(), token, user));
        return ResponseEntity.ok(new MessageResponse("Email sent to user!"));
    }

    /**
     * Used to reset the user password (if the token given in parameter is correct) API side.
     * @param id The user id.
     * @param token The reset token.
     * @return {@link ResponseEntity}
     */
    @RequestMapping(value = "/resetPassword/validateToken", method = RequestMethod.GET)
    public ResponseEntity<String> resetPassword(@RequestParam("id") long id, @RequestParam("token") String token) {
        Gson gson = new Gson();
        ResponseEntity<String> ret = ResponseEntity.ok(gson.toJson(false));
        this.token = passwordResetService.validatePasswordResetToken(id, token);
        if (!this.token.isEmpty()) {
            ret = ResponseEntity.ok(gson.toJson(true));
        }
        return ret;

    }

    /**
     * Saves the changed password.
     * @param savePasswordRequest {@link SavePasswordRequest}
     * @return {@link ResponseEntity}
     */
    @RequestMapping(value = "/resetPassword/savePassword", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public ResponseEntity<?> savePassword(@Valid @RequestBody SavePasswordRequest savePasswordRequest) {
        if (!savePasswordRequest.getToken().isEmpty()) {
            PasswordResetToken passwordResetToken = passwordResetTokenRepository.findByToken(savePasswordRequest.getToken());
            Optional<User> user = userService.getUserByPasswordResetToken(savePasswordRequest.getToken());
            user.ifPresent(value -> userService.changeUserPassword(value, savePasswordRequest.getNewPassword()));
            passwordResetTokenRepository.delete(passwordResetToken);
            return ResponseEntity.ok(new MessageResponse("Password has been reset!"));
        }
        else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Password has not been reset !");
        }
    }

    /**
     * Change the user's password (not in the case it has been forgotten, but in the case a logged in user wants to change its password).
     * @param changePasswordRequest {@link ChangePasswordRequest}
     * @return {@link ResponseEntity}
     */
    @RequestMapping(value = "/resetPassword/changePassword", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public ResponseEntity<?> changePassword(@Valid @RequestBody ChangePasswordRequest changePasswordRequest) {
        User user = userService.getUserByName(changePasswordRequest.getUserName());
        if (user != null && encoder.matches(changePasswordRequest.getOldPassword(), user.getPassword())) {
            userService.changeUserPassword(user, changePasswordRequest.getNewPassword());
            return ResponseEntity.ok(new MessageResponse("Password has been changed!"));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("Bad old password");
        }
    }
}

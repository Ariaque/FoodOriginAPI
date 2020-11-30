package com.istic.foodorigin.security.services;

import com.istic.foodorigin.models.PasswordResetToken;
import com.istic.foodorigin.models.User;
import com.istic.foodorigin.repository.PasswordResetTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Calendar;

@Service
public class PasswordResetService {

    @Autowired
    private PasswordResetTokenRepository passwordResetTokenRepository;


    public void createPasswordResetTokenForUser(User user, String token) {
        PasswordResetToken myToken = new PasswordResetToken(token, user);
        passwordResetTokenRepository.save(myToken);
    }

    public void validatePasswordResetToken(long id, String token) {
        Calendar cal = Calendar.getInstance();
        PasswordResetToken passToken = passwordResetTokenRepository.findByToken(token);
        if ((passToken == null) || (passToken.getUser()
                .getId() != id)) {
        }
        else if ((passToken.getExpiryDate()
                .getTime() - cal.getTime()
                .getTime()) <= 0) {
            passwordResetTokenRepository.delete(passToken);
        }
        else {
            User user = passToken.getUser();
            Authentication auth = new UsernamePasswordAuthenticationToken(
                    user, null, Arrays.asList(
                    new SimpleGrantedAuthority("CHANGE__PASSWORD__PRIVILEGE")));
            SecurityContextHolder.getContext().setAuthentication(auth);
            passwordResetTokenRepository.delete(passToken);
        }
    }
}

package com.istic.foodorigin.security.services;

import com.istic.foodorigin.models.PasswordResetToken;
import com.istic.foodorigin.models.User;
import com.istic.foodorigin.repository.PasswordResetTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class PasswordResetService {

    @Autowired
    private PasswordResetTokenRepository passwordResetTokenRepository;


    public void createPasswordResetTokenForUser(User user, String token) {
        PasswordResetToken myToken = new PasswordResetToken(token, user);
        passwordResetTokenRepository.save(myToken);
    }

    public String validatePasswordResetToken(long id, String token) {
        Calendar cal = Calendar.getInstance();
        PasswordResetToken passToken = passwordResetTokenRepository.findByToken(token);
        String ret = "";
        if ((passToken == null) || (passToken.getUser()
                .getId() != id)) {
        } else if ((passToken.getExpiryDate()
                .getTime() - cal.getTime()
                .getTime()) <= 0) {
            passwordResetTokenRepository.delete(passToken);
        } else {
            ret = passToken.getToken();
        }
        return ret;
    }
}

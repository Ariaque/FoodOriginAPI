package com.istic.foodorigin.security.services;

import com.istic.foodorigin.models.PasswordResetToken;
import com.istic.foodorigin.models.User;
import com.istic.foodorigin.repository.PasswordResetTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;

/**
 * Manages the reset tokens, used to reset the user password when forgotten.
 */
@Service
public class PasswordResetService {

    @Autowired
    private PasswordResetTokenRepository passwordResetTokenRepository;


    /**
     * Saves a reset token for the user.
     *
     * @param user  User.
     * @param token Token.
     */
    public void savePasswordResetTokenForUser(User user, String token) {
        PasswordResetToken myToken = new PasswordResetToken(token, user);
        passwordResetTokenRepository.save(myToken);
    }

    /**
     * Checks if the saved reset token for this user corresponds to the token given inside the reset url.
     * If the reset token is expired, deletes it in the database
     *
     * @param id    User id.
     * @param token Reset token.
     * @return Reset token if the token is correct, an empty string in other cases.
     */
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

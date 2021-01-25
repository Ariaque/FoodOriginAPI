package com.istic.foodorigin.security.services;

import com.istic.foodorigin.models.User;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class ResetEmailService {

    public SimpleMailMessage constructResetTokenEmail(
            String contextPath, Locale locale, String token, User user) {
        String url = contextPath + "?id=" +
                user.getId() + "&token=" + token;
        String message = "Veuillez réinitialiser votre mot de passe en cliquant sur le lien ci-dessous. Ce lien est valable 24 heures.";
        return constructEmail("Reset Password", message + " \r\n" + url, user);
    }

    private SimpleMailMessage constructEmail(String subject, String body,
                                             User user) {
        SimpleMailMessage email = new SimpleMailMessage();
        email.setSubject(subject);
        email.setText(body);
        email.setTo(user.getUsername());
        email.setFrom("noreply@foodOrigin.com");
        return email;
    }

}

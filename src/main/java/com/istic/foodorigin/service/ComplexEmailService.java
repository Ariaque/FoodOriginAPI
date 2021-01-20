package com.istic.foodorigin.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;


@Service
public class ComplexEmailService {

    @Value("${foodorigin.admin.mailAdress}")
    private String adminEmail;

    public SimpleMailMessage constructContactEmail(String mailAdress, String subject, String phoneNumber, String description) {
        String message = "Adresse email : " + mailAdress + "\r\n" + "Numéro de téléphone : "+ phoneNumber + "\r\n" + "Message : " + description;
        return constructEmail(mailAdress, subject, message);
    }

    public SimpleMailMessage constructEmail(String mailAdress, String subject, String message) {
        SimpleMailMessage email = new SimpleMailMessage();
        email.setFrom(mailAdress);
        email.setSubject(subject);
        email.setText(message);
        email.setTo(adminEmail);
        return email;
    }
}

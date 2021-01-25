package com.istic.foodorigin.testService;

import com.istic.foodorigin.service.ComplexEmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ComplexEmailServiceTests {

    @Autowired
    private ComplexEmailService complexEmailService;

    @Test
    public void testConstructEmail () {
        String emailAdress = "test@gmail.com";
        String subject = "Test objet";
        String message = "Test message";
        String adminMail = "emile.georget@outlook.fr";

        SimpleMailMessage mail = complexEmailService.constructEmail(emailAdress, subject, message);
        assertThat (mail.getFrom()).isEqualTo(emailAdress);
        assertThat (mail.getSubject()).isEqualTo(subject);
        assertThat(mail.getText()).isEqualTo(message);
        assertThat(mail.getTo()[0]).isEqualTo(adminMail);
    }

    @Test
    public void testConstructContactEmail () {
        String emailAdress = "test@free.com";
        String adminMail = "emile.georget@outlook.fr";
        String subject = "Objet test";
        String message = "Message de contact";
        String numTel = "0258963214";
        String messageDef = "Adresse email : " + emailAdress + "\r\n" + "Numéro de téléphone : "+ numTel + "\r\n" + "Message : " + message;

        SimpleMailMessage mail = complexEmailService.constructContactEmail(emailAdress, subject, numTel, message);
        assertThat (mail.getFrom()).isEqualTo(emailAdress);
        assertThat (mail.getSubject()).isEqualTo(subject);
        assertThat(mail.getText()).isEqualTo(messageDef);
        assertThat(mail.getTo()[0]).isEqualTo(adminMail);
    }
}

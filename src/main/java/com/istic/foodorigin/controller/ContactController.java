package com.istic.foodorigin.controller;

import com.istic.foodorigin.payload.request.SendContactEmailRequest;
import com.istic.foodorigin.payload.request.SendSimpleEmailRequest;
import com.istic.foodorigin.payload.response.MessageResponse;
import com.istic.foodorigin.service.ContactEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    ContactEmailService contactEmailService;

    @RequestMapping(value = "/sendEmail", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public ResponseEntity<?> sendContactEmail(HttpServletRequest request, @RequestBody SendContactEmailRequest sendContactEmailRequest) {
        javaMailSender.send(contactEmailService.constructResetTokenEmail(sendContactEmailRequest.getEmailAdress(), sendContactEmailRequest.getSubjet(), sendContactEmailRequest.getPhoneNumber(), sendContactEmailRequest.getMessage()));
        return ResponseEntity.ok(new MessageResponse("Contact email sent to user!"));
    }

}

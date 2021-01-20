package com.istic.foodorigin.controller;

import com.istic.foodorigin.payload.request.SendComplexEmailRequest;
import com.istic.foodorigin.payload.response.MessageResponse;
import com.istic.foodorigin.service.ComplexEmailService;
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
    ComplexEmailService complexEmailService;

    @RequestMapping(value = "/sendEmail", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public ResponseEntity<?> sendContactEmail(HttpServletRequest request, @RequestBody SendComplexEmailRequest sendComplexEmailRequest) {
        javaMailSender.send(complexEmailService.constructContactEmail(sendComplexEmailRequest.getEmailAdress(), sendComplexEmailRequest.getSubjet(), sendComplexEmailRequest.getPhoneNumber(), sendComplexEmailRequest.getMessage()));
        return ResponseEntity.ok(new MessageResponse("Contact email sent to user!"));
    }

    @RequestMapping(value = "/notify", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public ResponseEntity<?> sendNotificationEmail(HttpServletRequest request, @RequestBody SendComplexEmailRequest sendComplexEmailRequest) {
        javaMailSender.send(complexEmailService.constructContactEmail(sendComplexEmailRequest.getEmailAdress(), sendComplexEmailRequest.getSubjet(), sendComplexEmailRequest.getPhoneNumber(), sendComplexEmailRequest.getMessage()));
        return ResponseEntity.ok(new MessageResponse("Notification email sent to admin!"));
    }

}

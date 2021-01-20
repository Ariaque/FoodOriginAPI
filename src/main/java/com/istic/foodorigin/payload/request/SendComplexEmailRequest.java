package com.istic.foodorigin.payload.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class SendComplexEmailRequest {

    @NotBlank
    @Email
    String emailAdress;

    @NotBlank
    String subjet;

    @NotBlank
    String phoneNumber;

    @NotBlank
    String message;

    public String getEmailAdress() {
        return emailAdress;
    }

    public void setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress;
    }

    public String getSubjet() {
        return subjet;
    }

    public void setSubjet(String subjet) {
        this.subjet = subjet;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

package com.istic.foodorigin.payload.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class SendSimpleEmailRequest {

    @NotBlank
    @Email
    String email;

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

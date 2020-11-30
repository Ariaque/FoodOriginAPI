package com.istic.foodorigin.payload.request;

import javax.validation.constraints.NotBlank;

public class SavePasswordRequest {

    @NotBlank
    private String newPassword;

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}

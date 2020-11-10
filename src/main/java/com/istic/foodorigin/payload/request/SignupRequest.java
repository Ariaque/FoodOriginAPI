package com.istic.foodorigin.payload.request;

import javax.validation.constraints.*;
import java.util.Set;

public class SignupRequest {
    @NotBlank
    @Email
    @Size(min = 3, max = 250)
    private String username;

    private Set<String> role;

    @NotBlank
    @Size(min = 4, max = 250)
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRole() {
        return this.role;
    }

    public void setRole(Set<String> role) {
        this.role = role;
    }
}

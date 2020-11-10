package com.istic.foodorigin.payload.request;

import com.istic.foodorigin.models.Transformateur;

import javax.persistence.Column;
import javax.validation.constraints.*;
import java.util.Set;

public class SignupRequest {
    @NotBlank
    @Email
    @Size(min = 3, max = 250)
    private String username;

    private Set<String> roles;

    @NotBlank
    @Size(min = 4, max = 250)
    private String password;

    @NotBlank
    @Size(max = 250)
    @Column(name = "type_transformateur")
    private String typeTransformateur;


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
        return this.roles;
    }

    public void setRole(Set<String> role) {
        this.roles = role;
    }

    public String getTypeTransformateur() {
        return typeTransformateur;
    }

    public void setTypeTransformateur(String typeTransformateur) {
        this.typeTransformateur = typeTransformateur;
    }
}

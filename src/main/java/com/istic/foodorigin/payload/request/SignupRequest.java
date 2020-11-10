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

    private Set<String> role;

    private Transformateur transformateur;

    @NotBlank
    @Size(min = 4, max = 250)
    private String password;

    @Column(columnDefinition="tinyint(1) default 0", name="is_activated")
    @NotBlank
    private Boolean isActivated;

    @NotBlank
    @Size(min = 14, max = 14)
    private Long siret;

    @NotBlank
    @Size(max = 250)
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
        return this.role;
    }

    public void setRole(Set<String> role) {
        this.role = role;
    }

    private Transformateur getTransformateur() {
        return transformateur;
    }

    private void setTransformateur(Transformateur transformateur) {
        this.transformateur = transformateur;
    }

    public Boolean isActivated() {
        return isActivated;
    }

    public void setUserActivation(boolean isActivated) {
        this.isActivated = isActivated;
    }

    public Long getSiret() {
        return siret;
    }

    public void setSiret(Long siret) {
        this.siret = siret;
    }

    public String getTypeTransformateur() {
        return typeTransformateur;
    }

    public void setTypeTransformateur(String typeTransformateur) {
        this.typeTransformateur = typeTransformateur;
    }
}

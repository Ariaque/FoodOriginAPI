package com.istic.foodorigin.models;

import org.hibernate.validator.constraints.Range;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "foodOrigin_user",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
        })
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    @Range(max = 20)
    private Long id;

    @Email
    @NotBlank
    @Size(max = 250)
    private String username;

    @NotBlank
    @Size(max = 250)
    private String password;

    @ManyToOne
    @JoinColumn (name = "fk_role")
    private Role role;

    @OneToOne
    @JoinColumn(name = "fk_transformateur")
    private Transformateur transformateur;

    @Column(columnDefinition="tinyint(1) default 0", name="is_activated")
    @NotNull
    private Boolean isActivated;

    @NotBlank
    @Size(max = 250)
    @Column(name = "fk_typeT")
    private String typeTransformateur;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Transformateur getTransformateur() {
        return transformateur;
    }

    public void setTransformateur(Transformateur transformateur) {
        this.transformateur = transformateur;
    }

    public Boolean isActivated() {
        return isActivated;
    }

    public void setUserActivation(boolean isActivated) {
        this.isActivated = isActivated;
    }

    public String getTypeTransformateur() {
        return typeTransformateur;
    }

    public void setTypeTransformateur(String typeTransformateur) {
        this.typeTransformateur = typeTransformateur;
    }
}

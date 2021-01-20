package com.istic.foodorigin.models;

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
    private Long id;

    @Email
    @NotBlank
    @Size(max = 250)
    private String username;

    @NotBlank
    @Size(max = 250)
    private String password;

    @NotBlank
    @Column (name = "numero_telephone")
    @Size (max = 10)
    private String numeroTelephone;

    @ManyToOne
    @JoinColumn (name = "fk_role")
    private Role role;

    @OneToOne
    @JoinColumn(name = "fk_transformateur")
    private Transformateur transformateur;

    @Column(columnDefinition="tinyint(1) default 0", name="is_activated")
    @NotNull
    private Boolean isEnabled;

    @OneToOne
    @JoinColumn(name = "fk_typeT")
    private TypeTransformateur typeTransformateur;

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

    public Boolean getIsEnabled() {
        return isEnabled;
    }

    public void setUserActivation(boolean isActivated) {
        this.isEnabled = isActivated;
    }

    public TypeTransformateur getTypeTransformateur() {
        return typeTransformateur;
    }

    public void setTypeTransformateur(TypeTransformateur typeTransformateur) {
        this.typeTransformateur = typeTransformateur;
    }

    public String getNumeroTelephone() {
        return numeroTelephone;
    }

    public void setNumeroTelephone(String numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
    }
}

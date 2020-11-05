package com.istic.foodorigin.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
  /*  private UserRole userRole = UserRole.USER;
    private boolean enabled = false;*/

    public User () {}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

 /*   public UserRole getUserRole() {
        return userRole;
    }

    public boolean isEnabled() {
        return enabled;
    }*/

    public void setPassword (String password) {
        this.password = password;
    }
}

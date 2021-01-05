package com.istic.foodorigin.models;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name="foodOrigin_reset_token")
public class PasswordResetToken {


    private static final int EXPIRATION = 60 * 24;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "reset_token_id")
    private Long id;

    private String token;

    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "fk_user")
    private User user;

    @Column(name = "expiry_date")
    private Date expiryDate;

    public PasswordResetToken() {

    }

    public PasswordResetToken(String token, User user) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        this.token = token;
        this.user = user;
        expiryDate = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(expiryDate);
        c.add(Calendar.DATE, 1);
        expiryDate = c.getTime();
        formatter.format(expiryDate);
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getExpiryDate() {
        return this.expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

}

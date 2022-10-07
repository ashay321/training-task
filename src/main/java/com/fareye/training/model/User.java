package com.fareye.training.model;

import com.fareye.training.services.Password;

import java.time.LocalDateTime;
import java.util.Random;

public class User {

    private String firstName;
    private String lastName;
    private String email;
    private Boolean verified;
    private LocalDateTime createdAt;
    private String password;
    private Integer userId;

    private String role;
    private Boolean active;

    public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.verified = Boolean.FALSE;
        this.createdAt = LocalDateTime.now();

        Password userPassword = new Password(password);
        this.password = userPassword.getMySecurePassword();

        Random r = new Random();
        this.userId = r.nextInt();

        this.role = "Software Engineer";
        this.active = Boolean.TRUE;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}

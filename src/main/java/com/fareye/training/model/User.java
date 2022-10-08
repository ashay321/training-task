package com.fareye.training.model;

import com.fareye.training.services.Password;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Random;

@Getter @Setter
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

}

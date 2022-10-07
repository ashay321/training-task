package com.fareye.training.services;

import com.fareye.training.utils.PasswordUtils;

public class Password {
    private String password;
    private String mySecurePassword;

    public Password(String password) {
        String myPassword = "myPassword123";

        // Generate Salt. The generated value can be stored in DB.
        String salt = PasswordUtils.getSalt(30);

        // Protect user's password. The generated value can be stored in DB.
        String mySecurePassword = PasswordUtils.generateSecurePassword(myPassword, salt);

        this.mySecurePassword = mySecurePassword;

        System.out.println(mySecurePassword);
        System.out.println(salt);
    }

    public String getMySecurePassword() {
        return mySecurePassword;
    }
}

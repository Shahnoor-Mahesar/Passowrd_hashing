package com.security.hashing;
//Password.java(Encoder and decoder for password hashing)
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Password {

    private static PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    public static String hashPassword(String pass) {
        return passwordEncoder.encode(pass);
    }



    public static boolean verifyPassword(String pass, String hashedPass) {
        return passwordEncoder.matches(pass, hashedPass);
    }

}

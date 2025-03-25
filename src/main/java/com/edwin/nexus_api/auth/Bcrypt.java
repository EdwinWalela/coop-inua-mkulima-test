package com.edwin.nexus_api.auth;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Bcrypt {
    public static String hash(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }
}

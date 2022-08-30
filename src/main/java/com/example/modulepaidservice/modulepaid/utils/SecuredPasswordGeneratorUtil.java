package com.example.modulepaidservice.modulepaid.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Slf4j
public class SecuredPasswordGeneratorUtil {

    public static String generatePassword(String rawPassword){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(rawPassword);
        log.info("[SecuredPasswordGeneratorUtil] Password Encode: {}",encodedPassword);
        return encodedPassword;
    }

}

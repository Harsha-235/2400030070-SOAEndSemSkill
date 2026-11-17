package com.example.demo.util;

import java.util.Date;
import java.util.Map;

import javax.crypto.SecretKey;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    private final SecretKey secretKey =
        Keys.hmacShaKeyFor(
            "mysecretkeymysecretkeymysecretkey123456".getBytes()
        );

    public String generateToken(Map<String, Object> claims) {

        return Jwts.builder()
                .claims(claims)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 3600000))
                .signWith(secretKey)
                .compact();
    }
}
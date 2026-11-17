package com.example.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.util.JwtUtil;

@RestController
@RequestMapping("/jwt")
public class JwtController {

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/generate")
    public String generateToken(@RequestBody Map<String, Object> user) {

        return jwtUtil.generateToken(user);
    }
}
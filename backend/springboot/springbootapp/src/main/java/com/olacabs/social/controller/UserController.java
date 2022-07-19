package com.olacabs.social.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @PostMapping("/login")
    public boolean loginRequest(String username, String hashedPassword) {
        return true;
    }
}

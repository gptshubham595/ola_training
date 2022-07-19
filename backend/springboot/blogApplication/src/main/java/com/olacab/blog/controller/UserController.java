package com.olacab.blog.controller;

import com.olacab.blog.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @PostMapping(value = "/signup",consumes = "application/json",produces = "application/json")
    public void signup(@RequestBody User user) {
        
    }
}

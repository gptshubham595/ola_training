package com.olacab.blog.controller;

import com.olacab.blog.model.SignupResponse;
import com.olacab.blog.model.User;
import com.olacab.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping(value = "/signup",consumes = "application/json",produces = "application/json")
    public SignupResponse signup(@RequestBody User user) {
//        userService.register(user);
        SignupResponse signupResponse = userService.register(user);
        return signupResponse;
        /*Response
             flag:true/false
             msg:"successfully registered"
         */
    }

}

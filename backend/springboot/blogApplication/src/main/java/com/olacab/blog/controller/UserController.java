package com.olacab.blog.controller;

import com.olacab.blog.model.LoginRequest;
import com.olacab.blog.model.LoginResponse;
import com.olacab.blog.model.SignupResponse;
import com.olacab.blog.model.User;
import com.olacab.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.security.auth.login.LoginException;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping(value = "/login", consumes = "application/json", produces = "application/json")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) throws LoginException {
        try {
            LoginResponse loginResponse = userService.authenticate(request);
            if (loginResponse.isLoginStatus()) {
                return new ResponseEntity<LoginResponse>(loginResponse, HttpStatus.OK);
            } else {
                return new ResponseEntity<LoginResponse>(loginResponse, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            LoginResponse loginResponse = null;
            return new ResponseEntity<LoginResponse>(loginResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/signup", consumes = "application/json", produces = "application/json")
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

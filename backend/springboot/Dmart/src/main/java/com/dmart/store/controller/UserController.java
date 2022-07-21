package com.dmart.store.controller;

import com.dmart.store.model.LoginRequest;
import com.dmart.store.model.LoginResponse;
import com.dmart.store.model.SignupResponse;
import com.dmart.store.model.User;
import com.dmart.store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping(value = "/signup", consumes = "application/json", produces = "application/json")
    public ResponseEntity<SignupResponse> getSignupResponse(@RequestBody User user) {
        SignupResponse signupResponse = new SignupResponse();
        if (user.getRole() == null || user.getRole().equals("client")) {
            signupResponse.setSignupStatus(true);
            signupResponse.setMessage("Successfully registered!");
            signupResponse = userService.register(user, "client");
            return new ResponseEntity<SignupResponse>(signupResponse, HttpStatus.OK);
        }

        signupResponse.setSignupStatus(false);
        signupResponse.setMessage("SOMRRY BRO!");

        return new ResponseEntity<SignupResponse>(signupResponse, HttpStatus.BAD_REQUEST);
    }

    @PostMapping(value = "/login", consumes = "application/json", produces = "application/json")
    public ResponseEntity<LoginResponse> getLoginResponse(@RequestBody LoginRequest loginRequest) {
        try {
            LoginResponse loginResponse = userService.login(loginRequest);
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
}

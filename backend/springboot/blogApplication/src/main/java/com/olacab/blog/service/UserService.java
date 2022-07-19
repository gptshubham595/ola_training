package com.olacab.blog.service;

import com.olacab.blog.model.SignupResponse;
import com.olacab.blog.model.User;
import com.olacab.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public SignupResponse register(User user) {
        User newUser = userRepository.save(user);
        SignupResponse signupResponse = new SignupResponse();
        if (newUser == null) {
            signupResponse.setSignupStatus(false);
            signupResponse.setMessage("Signup Failed");
        } else {
            signupResponse.setSignupStatus(true);
            signupResponse.setMessage("Signup Success");
        }
//        userRepository.save(user);
        return signupResponse;

    }
}

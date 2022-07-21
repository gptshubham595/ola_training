package com.olacab.blog.service;

import com.olacab.blog.model.LoginRequest;
import com.olacab.blog.model.LoginResponse;
import com.olacab.blog.model.SignupResponse;
import com.olacab.blog.model.User;
import com.olacab.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Value("${pepper}")
    String pepper;
    @Autowired
    UserRepository userRepository;

    public SignupResponse register(User user) {
        User currUser = userRepository.findByEmail(user.getEmail());
        SignupResponse signupResponse = new SignupResponse();

        if (currUser != null) {
            signupResponse.setSignupStatus(false);
            signupResponse.setMessage("Signup Failed");
            return signupResponse;
        } else {
            String salt = BCrypt.gensalt();
            String hashedPassword = BCrypt.hashpw(user.getPassword() + pepper, salt);
            user.setPassword(hashedPassword);
            user.setSalt(salt);
            User newUser = userRepository.save(user);
            if (newUser == null) {
                signupResponse.setSignupStatus(false);
                signupResponse.setMessage("Signup Failed");
            } else {
                signupResponse.setSignupStatus(true);
                signupResponse.setMessage("Signup Success");
            }
        }
        return signupResponse;
    }

    public LoginResponse authenticate(LoginRequest loginRequest) {
        User user = userRepository.findByEmail(loginRequest.getEmail());
        LoginResponse loginResponse = new LoginResponse();

//        String hashedPasswordOrig=BCrypt.hashpw(user.getPassword()+pepper, user.getSalt());
        String hashedPasswordNew = BCrypt.hashpw(loginRequest.getPassword() + pepper, user.getSalt());

        if (user == null) {
            loginResponse.setLoginStatus(false);
            loginResponse.setMessage("Login failed! Invalid credentials ..");
        } else if (user != null && hashedPasswordNew.equals(user.getPassword())) {
            loginResponse.setLoginStatus(true);
            loginResponse.setMessage("Login successful");
        } else {
            loginResponse.setLoginStatus(false);
            loginResponse.setMessage("Login failed! Invalid credentials ..");
        }
        return loginResponse;
    }
}

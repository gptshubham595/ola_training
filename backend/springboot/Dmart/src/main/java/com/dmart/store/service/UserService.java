package com.dmart.store.service;

import com.dmart.store.model.LoginRequest;
import com.dmart.store.model.LoginResponse;
import com.dmart.store.model.SignupResponse;
import com.dmart.store.model.User;
import com.dmart.store.repository.UserRepository;
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

    public SignupResponse register(User user, String type) {
        boolean currUser = userRepository.existsByEmail(user.getEmail());
        boolean currUser2 = userRepository.existsByUsername(user.getUsername());
        SignupResponse signupResponse = new SignupResponse();

        if (currUser || currUser2) {
            signupResponse.setSignupStatus(false);
            signupResponse.setMessage("Signup Failed");
            return signupResponse;
        }

        String salt = BCrypt.gensalt();
        String hashedPassword = BCrypt.hashpw(user.getPassword() + pepper, salt);
        user.setPassword(hashedPassword);
        user.setSalt(salt);
        user.setRole("client");
        userRepository.save(user);

        signupResponse.setSignupStatus(true);
        signupResponse.setMessage("Signup Successfully!");
        return signupResponse;

    }

    public LoginResponse login(LoginRequest loginRequest) {
        LoginResponse loginResponse = new LoginResponse();
        User user = userRepository.findByEmail(loginRequest.getEmail());
        if (user == null) {
            loginResponse.setLoginStatus(false);
            loginResponse.setMessage("Login failed! Invalid credentials ..");
            return loginResponse;
        }
        if (loginRequest.getRole().equals("admin") && user.getRole().equals("admin")) {
            loginResponse.setLoginStatus(true);
            loginResponse.setMessage("Admin: Logged in Successfully!");
        } else if (loginRequest.getRole().equals("store_manager") && user.getRole().equals("store_manager")) {
            loginResponse.setLoginStatus(true);
            loginResponse.setMessage("Store Manager: Login failed! Invalid credentials ..");
        } else {
            loginResponse.setLoginStatus(true);
            loginResponse.setMessage("Client: Login failed! Invalid credentials ..");
        }
        return loginResponse;
    }

}

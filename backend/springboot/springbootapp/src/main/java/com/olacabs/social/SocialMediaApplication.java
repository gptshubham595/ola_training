package com.olacabs.social;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
public class SocialMediaApplication {
    public static void main(String[] args) {
        SpringApplication.run(SocialMediaApplication.class, args);
        // Application -> Controller (Routing) -> Service (Logic) -> Repository(CRUD) -> Database

    }
}

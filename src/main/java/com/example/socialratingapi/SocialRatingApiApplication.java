package com.example.socialratingapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SocialRatingApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SocialRatingApiApplication.class, args);
    }

}

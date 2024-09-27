package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.userscrud.service.PostService; // Make sure to import your service class

@SpringBootApplication
public class UserscrudApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(UserscrudApplication.class, args); 
        
        PostService postService = context.getBean(PostService.class);
        

    }
}

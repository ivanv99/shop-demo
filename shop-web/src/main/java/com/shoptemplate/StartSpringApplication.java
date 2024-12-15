package com.shoptemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class StartSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(StartSpringApplication.class, args);
    }
}

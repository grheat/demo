package com.henry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        //Blade.of().start(Application.class, args);
        SpringApplication.run(Application.class, args);
    }
}

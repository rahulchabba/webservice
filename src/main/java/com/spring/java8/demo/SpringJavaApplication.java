package com.spring.java8.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringJavaApplication {

    public static void main(String[] args) {
        System.out.println("First running java Spring");
        SpringApplication.run(SpringJavaApplication.class, args);
    }

}

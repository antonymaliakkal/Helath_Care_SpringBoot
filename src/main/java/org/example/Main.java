package com.healthcare.appointment_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients // Enable Feign client
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(com.healthcare.appointment_service.Main.class, args);
    }

}
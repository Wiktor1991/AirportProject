package com.example.flightbookerapp;

import com.example.flightbookerapp.users.IUserRepository;
import com.example.flightbookerapp.users.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FlightBookerAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlightBookerAppApplication.class, args);

    }

}

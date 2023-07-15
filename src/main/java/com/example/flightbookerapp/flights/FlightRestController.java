package com.example.flightbookerapp.flights;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class FlightRestController {
    private final FlightRepository flightRepository;

    Flight flight = new Flight("Lisbona","Bratyslawwa", LocalDateTime.of(2018,01,11,16,45,23),LocalDateTime.now());
    @GetMapping("/add")
    public void addFlight(){
        flightRepository.addFlight(flight);
        System.out.println(LocalDateTime.now());

    }
}

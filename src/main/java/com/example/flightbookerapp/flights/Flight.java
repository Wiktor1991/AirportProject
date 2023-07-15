package com.example.flightbookerapp.flights;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "flights")
@ToString
public class Flight {

    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String departureAirport;
    String arrivalAirport;
    LocalDateTime departureTime;
    LocalDateTime arrivalTime;

    public Flight(String departureAirport, String arrivalAirport, LocalDateTime departureTime, LocalDateTime arrivalTime) {
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public Flight() {
    }

}

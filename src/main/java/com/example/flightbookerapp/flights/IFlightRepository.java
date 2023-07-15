package com.example.flightbookerapp.flights;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IFlightRepository extends JpaRepository<Flight,Integer> {

}

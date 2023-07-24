package com.example.flightbookerapp.flights;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class FlightRepository {

    private final IFlightRepository iFlightRepository;

    public void addFlight(Flight flight){
        iFlightRepository.save(flight);
    }
    public List<Flight> getAllFlights(){
       return iFlightRepository.findAll();
    }

    public void delete(Flight flight) {
        iFlightRepository.delete(flight);
    }

    public void deleteById(Integer id) {
        iFlightRepository.deleteById(id);
    }
}

package com.example.flightbookerapp.flights;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequiredArgsConstructor

@Slf4j
public class FlightViewController {

    private final FlightRepository flightRepository;
    private Boolean isSaved;
    private Boolean isRemoved;
    @GetMapping("/create")
    public String addFlight(Model model){
        model.addAttribute("isSaved",isSaved);
        model.addAttribute("flight",new Flight());
        model.addAttribute("datatime",new FlightDateTime());
        model.addAttribute("arrivaldatatime", new FlightDateTime());
        return "addflight";
    }
    @PostMapping("/addFlight")
    public String add(@ModelAttribute ("datatime") FlightDateTime dateTime,
                      @ModelAttribute("flight") Flight flight,@ModelAttribute ("arrivaldatatime") FlightDateTime arrivaldatatime ){
        isSaved = false;
        LocalDateTime departureTime = LocalDateTime.of(dateTime.getYear(),dateTime.getMonth(),dateTime.getDay(),dateTime.getHour(),dateTime.getMinute(),00);
        LocalDateTime arrivalTime = LocalDateTime.of(arrivaldatatime.getYear(),arrivaldatatime.getMonth(),arrivaldatatime.getDay(),arrivaldatatime.getHour(),arrivaldatatime.getMinute(),00);

        Flight toSave = new Flight(flight.departureAirport,flight.arrivalAirport,departureTime,arrivalTime);
        flightRepository.addFlight(toSave);
        isSaved= true;
        return "redirect:/create";
    }
    @GetMapping("/all")
    public String all(Model model){
        List<Flight> flights = flightRepository.getAllFlights();
        model.addAttribute("flights",flights);
        model.addAttribute("isRemoved", isRemoved);
        return "flights";
    }
    @PostMapping("/delete")
    public String delete(@ModelAttribute("id")Integer id){
        if (id != null) {
            flightRepository.deleteById(id);
            isRemoved = true;
        }
            
        return "redirect:/all";
    }
    @PostMapping("/modify")
    public String modify(@ModelAttribute("id")Integer id){
        return "redirect:/all";
    }
}

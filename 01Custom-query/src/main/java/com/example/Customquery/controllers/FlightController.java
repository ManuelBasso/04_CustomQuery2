package com.example.Customquery.controllers;

import com.example.Customquery.entities.Flight;
import com.example.Customquery.entities.FlightStatus;
import com.example.Customquery.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    FlightRepository flightRepository;

    @GetMapping("/provisoning")
    public List<Flight> provisoningFlight(){
        List<Flight> listFlight = new ArrayList<>();
        for (int i=0; i < 50; i++){
            Flight flight = new Flight();

            flight.setDescription(String.valueOf(UUID.randomUUID()));
            flight.setFromAirport(String.valueOf(UUID.randomUUID()));
            flight.setToAirport(String.valueOf(UUID.randomUUID()));
            flight.setStatus(FlightStatus.ON_TIME);
            listFlight.add(flight);
        }
        return flightRepository.saveAll(listFlight);
    }

    @GetMapping("/getAll")
    public List<Flight> getAll(){
        return flightRepository.findAll();
    }
}

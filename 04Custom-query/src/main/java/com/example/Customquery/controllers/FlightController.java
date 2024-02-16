package com.example.Customquery.controllers;

import com.example.Customquery.entities.Flight;
import com.example.Customquery.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import java.util.*;
;

@RestController
@RequestMapping("/flights")
public class FlightController {
    @Autowired
    FlightService flightService;


    @PostMapping("/provisoning")
    public List<Flight> provisoningFlight(@RequestParam(defaultValue = "100") int flightNumber) {
        return flightService.provisonigFlights(flightNumber);
    }

    @GetMapping("/getAll")
    public List<Flight> getAll() {
        return flightService.getAll();
    }

    @GetMapping("/getAllPaginating")
    public Page<Flight> getAllPaginating(@RequestParam int page, @RequestParam int size) {
        return flightService.getAllPaginating(page, size);
    }

    @GetMapping("/getOnTime")
    public List<Flight> getOnTimeFlights() {
        return flightService.getOnTimeFlights();
    }

    @GetMapping("/getFlightsTwoStatus")
    public List<Flight> getFlightsByTwoStatus(@RequestParam String status1, @RequestParam (required = true) String status2) {
        return flightService.getFlightsbyTwoStatus(status1, status2);
    }
}


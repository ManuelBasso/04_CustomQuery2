package com.example.Customquery.services;

import com.example.Customquery.entities.Flight;
import com.example.Customquery.entities.FlightStatus;
import com.example.Customquery.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;

    public String randomString() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }

    public List<Flight> provisonigFlights(int n) {
        List<Flight> listFlight = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Flight flight = new Flight();

            flight.setDescription(randomString());
            flight.setFromAirport(randomString());
            flight.setToAirport(randomString());
            //https://www.baeldung.com/java-enum-random-value
            flight.setStatus(FlightStatus.randomStatus());
            listFlight.add(flight);
        }
        return flightRepository.saveAll(listFlight);
    }


    public List<Flight> getAll() {
        return flightRepository.findAll();
    }

    public Page<Flight> getAllPaginating(int page, int size) {
        return flightRepository.findAll(
                PageRequest.of(page, size, Sort.by("fromAirport").ascending()));
    }

    public List<Flight> getOnTimeFlights() {
        List<Flight> flightsOnTime = flightRepository.findAllByStatus(FlightStatus.ON_TIME);
        return flightsOnTime;
    }

    public List<Flight> getFlightsbyTwoStatus(String status1, String status2) {
        FlightStatus s1 = FlightStatus.valueOf(status1);
        FlightStatus s2 = FlightStatus.valueOf(status2);
        return flightRepository.findFlightbyTwoStatus(s1,s2);
    }
}

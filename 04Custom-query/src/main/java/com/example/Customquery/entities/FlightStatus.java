package com.example.Customquery.entities;


import com.example.Customquery.repositories.FlightRepository;

import java.util.Random;

public enum FlightStatus {
    ON_TIME,
    DELAYED,
    CANCELED;


    private static final Random PRNG = new Random();

    public static FlightStatus randomStatus() {
        FlightStatus[] flightStatus = values();
        return flightStatus[PRNG.nextInt(flightStatus.length)];
    }

}
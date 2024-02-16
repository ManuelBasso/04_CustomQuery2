package com.example.Customquery.repositories;

import com.example.Customquery.entities.Flight;
import com.example.Customquery.entities.FlightStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

   List<Flight> findAllByStatus(FlightStatus status);

   @Query(value = "SELECT * FROM FLIGHT WHERE STATUS = ?1 OR STATUS = ?2", nativeQuery = true)
   List<Flight> findFlightbyTwoStatus(FlightStatus s1, FlightStatus s2);
}

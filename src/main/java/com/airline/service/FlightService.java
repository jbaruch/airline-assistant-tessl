package com.airline.service;

import com.airline.model.Flight;
import jakarta.enterprise.context.ApplicationScoped;
import java.time.LocalDateTime;
import java.util.List;

@ApplicationScoped
public class FlightService {

    public List<Flight> searchFlights(String origin, String destination, LocalDateTime date) {
        // Mock data - in a real application, this would query a database
        return List.of(
            new Flight(
                "AA100",
                origin,
                destination,
                date.withHour(8).withMinute(0),
                date.withHour(12).withMinute(30),
                "On Time",
                299.99
            ),
            new Flight(
                "AA202",
                origin,
                destination,
                date.withHour(14).withMinute(0),
                date.withHour(18).withMinute(30),
                "On Time",
                349.99
            )
        );
    }

    public Flight getFlightStatus(String flightNumber) {
        // Mock data
        return new Flight(
            flightNumber,
            "JFK",
            "LAX",
            LocalDateTime.now().plusHours(2),
            LocalDateTime.now().plusHours(8),
            "On Time",
            299.99
        );
    }
}

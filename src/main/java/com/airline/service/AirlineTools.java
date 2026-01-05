package com.airline.service;

import com.airline.model.Flight;
import dev.langchain4j.agent.tool.Tool;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@ApplicationScoped
public class AirlineTools {

    @Inject
    FlightService flightService;

    @Tool("Search for available flights between two cities on a specific date")
    public List<Flight> searchFlights(String origin, String destination, String date) {
        LocalDateTime searchDate = LocalDate.parse(date, DateTimeFormatter.ISO_DATE).atStartOfDay();
        return flightService.searchFlights(origin, destination, searchDate);
    }

    @Tool("Get the current status of a flight by flight number")
    public Flight getFlightStatus(String flightNumber) {
        return flightService.getFlightStatus(flightNumber);
    }

    @Tool("Get baggage allowance information")
    public String getBaggageInfo(String ticketClass) {
        return switch (ticketClass.toLowerCase()) {
            case "economy" -> "Economy class: 1 checked bag (23kg), 1 carry-on (10kg)";
            case "premium economy" -> "Premium Economy: 2 checked bags (23kg each), 1 carry-on (10kg)";
            case "business" -> "Business class: 3 checked bags (32kg each), 2 carry-ons (10kg each)";
            case "first" -> "First class: 4 checked bags (32kg each), 2 carry-ons (15kg each)";
            default -> "Standard allowance: 1 checked bag (23kg), 1 carry-on (10kg)";
        };
    }
}

package com.airline.model;

import java.time.LocalDateTime;

public record Flight(
    String flightNumber,
    String origin,
    String destination,
    LocalDateTime departureTime,
    LocalDateTime arrivalTime,
    String status,
    Double price
) {}

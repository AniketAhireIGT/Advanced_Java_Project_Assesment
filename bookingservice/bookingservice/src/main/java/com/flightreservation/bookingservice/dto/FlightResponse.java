package com.flightreservation.bookingservice.dto;

import lombok.Data;

@Data
public class FlightResponse {
    private Long id;
    private String airline;
    private String departureCity;
    private String arrivalCity;
    private double price;
}
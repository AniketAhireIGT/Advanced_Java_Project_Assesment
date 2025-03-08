package com.flightreservation.flightservice.exceptionHandling;

public class FlightNotFoundException extends RuntimeException {
    public FlightNotFoundException(String message) {
        super(message);
    }
}
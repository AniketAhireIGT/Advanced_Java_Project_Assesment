package com.flightreservation.bookingservice.exceptionHandling;

public class BookingNotFoundException extends RuntimeException {
    public BookingNotFoundException(String message) {
        super(message);
    }
}
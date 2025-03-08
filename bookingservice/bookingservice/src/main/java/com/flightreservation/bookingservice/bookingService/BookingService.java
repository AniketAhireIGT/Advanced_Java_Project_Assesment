package com.flightreservation.bookingservice.bookingService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightreservation.bookingservice.bookingRepo.BookingRepository;
import com.flightreservation.bookingservice.bookingentity.BookingEntity;
import com.flightreservation.bookingservice.dto.FlightResponse;
import com.flightreservation.bookingservice.dto.UserResponse;
import com.flightreservation.bookingservice.feignClients.FlightClient;
import com.flightreservation.bookingservice.feignClients.UserClient;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserClient userClient;  // Inject Feign Client for User Service

    @Autowired
    private FlightClient flightClient;  // Inject Feign Client for Flight Service

    public List<BookingEntity> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Optional<BookingEntity> getBookingById(Long id) {
        return bookingRepository.findById(id);
    }

    public List<BookingEntity> getUserBookings(Long userId) {
        return bookingRepository.findByUserId(userId);
    }

    public BookingEntity createBooking(BookingEntity booking) {
        booking.setBookingDate(LocalDateTime.now());
        return bookingRepository.save(booking);
    }

    public void getBookingDetails(Long bookingId) {
        BookingEntity booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        // Fetch User details using Feign Client
        UserResponse user = userClient.getUserById(booking.getUserId());

        // Fetch Flight details using Feign Client
        FlightResponse flight = flightClient.getFlightById(booking.getFlightId());

        System.out.println("Booking ID: " + bookingId);
        System.out.println("User Name: " + user.getName());
        System.out.println("User Email: " + user.getEmail());
        System.out.println("Flight Airline: " + flight.getAirline());
        System.out.println("Flight Route: " + flight.getDepartureCity() + " → " + flight.getArrivalCity());
    }
}

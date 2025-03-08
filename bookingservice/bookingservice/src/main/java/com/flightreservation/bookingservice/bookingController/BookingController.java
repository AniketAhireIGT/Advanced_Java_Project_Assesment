package com.flightreservation.bookingservice.bookingController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightreservation.bookingservice.bookingService.BookingService;
import com.flightreservation.bookingservice.bookingentity.BookingEntity;
import com.flightreservation.bookingservice.exceptionHandling.BookingNotFoundException;

@RestController
@RequestMapping("/bookings")
public class BookingController {
	@Autowired
    private BookingService bookingService;

    @GetMapping("/getAllBookings")
    public List<BookingEntity> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/getBookingById/{id}")
    public BookingEntity getBookingById(@PathVariable Long id) {
        return bookingService.getBookingById(id)
                .orElseThrow(() -> new BookingNotFoundException("Booking not found with id: " + id));
    }

    @GetMapping("/user/{userId}")
    public List<BookingEntity> getUserBookings(@PathVariable Long userId) {
        List<BookingEntity> bookings = bookingService.getUserBookings(userId);
        if (bookings.isEmpty()) {
            throw new BookingNotFoundException("No bookings found for user with id: " + userId);
        }
        return bookings;
    }

    @PostMapping("/createBooking")
    public BookingEntity createBooking(@RequestBody BookingEntity booking) {
        return bookingService.createBooking(booking);
    }
}

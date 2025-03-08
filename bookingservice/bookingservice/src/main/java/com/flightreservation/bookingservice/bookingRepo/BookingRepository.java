package com.flightreservation.bookingservice.bookingRepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightreservation.bookingservice.bookingentity.BookingEntity;

public interface BookingRepository extends JpaRepository<BookingEntity, Long> {
    List<BookingEntity> findByUserId(Long userId);
}
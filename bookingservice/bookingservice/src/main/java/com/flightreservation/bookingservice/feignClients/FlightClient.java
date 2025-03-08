package com.flightreservation.bookingservice.feignClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.flightreservation.bookingservice.dto.FlightResponse;

@FeignClient(name = "FLIGHT-SERVICE", url = "http://localhost:8082/flights")  // Change port if needed
public interface FlightClient {

    @GetMapping("/getFlightById/{id}")
    FlightResponse getFlightById(@PathVariable Long id);
}
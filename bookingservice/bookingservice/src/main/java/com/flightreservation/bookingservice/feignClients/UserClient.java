package com.flightreservation.bookingservice.feignClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.flightreservation.bookingservice.dto.UserResponse;

@FeignClient(name = "USER-SERVICE", url = "http://localhost:8081/users")  // Change port if needed
public interface UserClient {

    @GetMapping("/getUser/{id}")
    UserResponse getUserById(@PathVariable Long id);
}
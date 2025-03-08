package com.flightreservation.flightservice.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flightreservation.flightservice.Entity.FlightEntity;
import com.flightreservation.flightservice.FlightService.FlightService;
import com.flightreservation.flightservice.exceptionHandling.FlightNotFoundException;

@RestController
@RequestMapping("/flights")
public class FlightController
{
	 @Autowired
	    private FlightService flightService;

	    @GetMapping("/getAllFlights")
	    public List<FlightEntity> getAllFlights() {
	        return flightService.getAllFlights();
	    }

	    @GetMapping("/getFlightById/{id}")
	    public FlightEntity getFlightById(@PathVariable Long id) {
	        return flightService.getFlightById(id)
	                .orElseThrow(() -> new FlightNotFoundException("Flight not found with id: " + id));
	    }

	    @GetMapping("/searchFlights")
	    public List<FlightEntity> searchFlights(@RequestParam String departureCity, @RequestParam String arrivalCity) {
	        return flightService.searchFlights(departureCity, arrivalCity);
	    }

	    @PostMapping("/createFlight")
	    public FlightEntity createFlight(@RequestBody FlightEntity flight) {
	        return flightService.saveFlight(flight);
	    }
}

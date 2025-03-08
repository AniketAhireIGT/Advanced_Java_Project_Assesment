package com.flightreservation.flightservice.FlightService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.flightreservation.flightservice.Entity.FlightEntity;
import com.flightreservation.flightservice.FlightRepository.FlightRepository;

@Service
public class FlightService 
{
	@Autowired
    private FlightRepository flightRepository;

    public List<FlightEntity> getAllFlights() {
        return flightRepository.findAll();
    }

    public Optional<FlightEntity> getFlightById(Long id) {
        return flightRepository.findById(id);
    }

    public List<FlightEntity> searchFlights(String departureCity, String arrivalCity) {
        return flightRepository.findByDepartureCityAndArrivalCity(departureCity, arrivalCity);
    }

    public FlightEntity saveFlight(FlightEntity flight) {
        return flightRepository.save(flight);
    }
}

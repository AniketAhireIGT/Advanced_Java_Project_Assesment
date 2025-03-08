package com.flightreservation.flightservice.FlightRepository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.flightreservation.flightservice.Entity.FlightEntity;

public interface FlightRepository extends JpaRepository<FlightEntity, Long>
{
    List<FlightEntity> findByDepartureCityAndArrivalCity(String departureCity, String arrivalCity);
}
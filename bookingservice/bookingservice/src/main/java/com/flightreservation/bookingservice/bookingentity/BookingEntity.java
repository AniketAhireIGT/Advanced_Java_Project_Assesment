package com.flightreservation.bookingservice.bookingentity;
import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table(name = "booking")
public class BookingEntity 
{
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	 	 @NotBlank(message = "userId is mandatory")
	     @Email(message = "userId should be valid")
	    private Long userId;
	    private Long flightId;
	    private LocalDateTime bookingDate;
	    private double amount;
}

package com.flightreservation.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@EnableDiscoveryClient
@SpringBootApplication
public class UserserviceApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(UserserviceApplication.class, args);
		System.out.println("User Service is Runnnig........");
	}

}

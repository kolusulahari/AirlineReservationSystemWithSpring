package com.capgemini.airlinereservationsystem.config;

import org.springframework.context.annotation.Configuration;

import com.javafullstackfeb.airlinereservationsystem.dao.FlightDAO;
import com.javafullstackfeb.airlinereservationsystem.dao.FlightDAOJpaImpl;
import com.javafullstackfeb.airlinereservationsystem.dao.UserDAO;
import com.javafullstackfeb.airlinereservationsystem.dao.UserDAOImpl;

@Configuration
public class AirlineConfigTest {
	
	//@Bean("FlightDAO")
	public FlightDAO getFlightDAO() {
		
		return new FlightDAOJpaImpl();
		
	}
	
	public UserDAO registerUser() {
		return new UserDAOImpl();
	}

}

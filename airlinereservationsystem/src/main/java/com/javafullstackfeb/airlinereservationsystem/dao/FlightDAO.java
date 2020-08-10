package com.javafullstackfeb.airlinereservationsystem.dao;

import java.util.List;

import com.javafullstackfeb.airlinereservationsystem.beans.AirportBeans;
import com.javafullstackfeb.airlinereservationsystem.beans.FlightInformation;

public interface FlightDAO {

	public FlightInformation getFlight(String flightNumber);

	public boolean addFlight(FlightInformation flightInformation);

	public boolean updateFlight(FlightInformation flightInformation);

	public boolean deleteFlight(String flightNumber);

	public List<FlightInformation> search(String departureCity, String arrivalCity, String departureDate);
	
	public List<FlightInformation> getAllFlights();
	
	public List<AirportBeans> getAllAirport();
		
	}

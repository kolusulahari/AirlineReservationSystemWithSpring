package com.javafullstackfeb.airlinereservationsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javafullstackfeb.airlinereservationsystem.beans.FlightInformation;
import com.javafullstackfeb.airlinereservationsystem.response.FlightResponse;
import com.javafullstackfeb.airlinereservationsystem.service.FlightService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
public class FlightController {
	@Autowired
	private FlightService service;

	@GetMapping("/getFlight")
	public FlightResponse getFlight(String flightNumber) {

		FlightInformation flightInformation = service.getFlight(flightNumber);
		FlightResponse response = new FlightResponse();
		if (flightInformation != null) {
			response.setStatusCode(210);
			response.setMessage("Success! Flight information retrived successfully.");
			response.setDescription("Flight information found successfully for the flightNo. : " + flightNumber);
			response.setFlightInformation(flightInformation);
		} else {

			response.setStatusCode(401);
			response.setMessage("Oops! Unable to retrived flight information.");
			response.setDescription(" Flight information not found for the Flight Number : " + flightNumber);

		}
		return response;

	}// end of getflight()

	@DeleteMapping("/deleteFlight")

	public FlightResponse deleteFlight(String flightNumber) {
		boolean isDeleted = service.deleteFlight(flightNumber);

		FlightResponse response = new FlightResponse();
		if (isDeleted) {
			response.setStatusCode(201);
			response.setMessage("Congratulation! Flight information deleted successfully.");
			response.setDescription("Congratulation! Flight information deleted successfully.");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription(" Unable to delete flight. Check whether you have entered correct flight number ");

		}
		return response;
	}

	@PutMapping(path = "/updateFlight")
	public boolean updateFlight(@RequestBody FlightInformation flightInformation) {
		return service.updateFlight(flightInformation);
	}

	@PostMapping("/addFlight")
	public FlightResponse addFlight(@RequestBody FlightInformation flightInformation) {
		boolean isAdded = service.addFlight(flightInformation);

		FlightResponse response = new FlightResponse();
		if (isAdded) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Flight added sucessfully.");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Unable to add flight. Flight Number Already Exists. ");

		}
		return response;

	}

	@PostMapping("/searchFlight")
	public FlightResponse searchFlight(@RequestBody FlightInformation flightInformation) {
		System.out.println("started");
		String departureCity = flightInformation.getDepartureCity();
		String arrivalCity = flightInformation.getArrivalCity();
		String departureDate = flightInformation.getDepartureDate();
		System.out.println("searching");
		List<FlightInformation> searchFlight = service.search(departureCity, arrivalCity, departureDate);
		System.out.println("Inside the list");
		FlightResponse response = new FlightResponse();
		if (searchFlight != null && !searchFlight.isEmpty()) {
			System.out.println("success");
			response.setStatusCode(210);
			response.setMessage("success");
			response.setDescription("List of flights ");
			response.setSearchFlight(searchFlight);
		} else {
			System.out.println("failed");
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("No Flights Available With These Details....!!! ");
		}
		System.out.println(response);
		return response;

	}

	@GetMapping("/getAll")
	public FlightResponse getAllFlights() {

		List<FlightInformation> flightList = service.getAllFlights();

		FlightResponse response = new FlightResponse();
		if (flightList != null && !flightList.isEmpty()) {
			response.setStatusCode(210);
			response.setMessage("success");
			response.setDescription("All Flights Found ");
			response.setSearchFlight(flightList);
		} else {

			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription(" Unable to find any flights.");

		}
		return response;

	}

}// end of class

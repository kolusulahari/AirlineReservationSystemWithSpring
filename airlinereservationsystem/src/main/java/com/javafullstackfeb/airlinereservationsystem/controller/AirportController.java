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

import com.javafullstackfeb.airlinereservationsystem.beans.AirportBeans;
import com.javafullstackfeb.airlinereservationsystem.response.AirportResponse;
import com.javafullstackfeb.airlinereservationsystem.service.AirportService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
public class AirportController {

	@Autowired
	private AirportService service;

	@PostMapping("/addAirport")
	public AirportResponse addAirport(@RequestBody AirportBeans airportBeans) {
		boolean isAdded = service.addAirport(airportBeans);
		AirportResponse response = new AirportResponse();
		if (isAdded) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("airport is added...");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("airport is not added...");
		}
		return response;
	}

	@GetMapping("/getAllAirports")
	public AirportResponse getAllAirports() {

		List<AirportBeans> airportList = service.getAllAirport();

		AirportResponse response = new AirportResponse();
		if (airportList != null && !airportList.isEmpty()) {
			response.setStatusCode(210);
			response.setMessage("success");
			response.setDescription("All airports Found ");
			response.setSearchAirport(airportList);

		} else {

			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription(" Unable to find any airports.");

		}
		return response;

	}

	@DeleteMapping("/deleteAirport")

	public AirportResponse deleteAirport(String abbreviation) {
		boolean isDeleted = service.deleteAirport(abbreviation);

		AirportResponse response = new AirportResponse();
		if (isDeleted) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Airport information deleted successfully.");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription(" Unable to delete Airport. Check whether you have entered correct details ");

		}
		return response;
	}

	@PutMapping(path = "/updateAirport")
	public boolean updateAirport(@RequestBody AirportBeans airport) {
		return service.updateAirport(airport);
	}
}// end of class

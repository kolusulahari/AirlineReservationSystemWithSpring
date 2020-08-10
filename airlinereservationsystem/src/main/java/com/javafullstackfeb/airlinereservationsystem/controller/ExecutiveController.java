package com.javafullstackfeb.airlinereservationsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javafullstackfeb.airlinereservationsystem.beans.AirlineExecutiveBeans;
import com.javafullstackfeb.airlinereservationsystem.beans.FlightInformation;
import com.javafullstackfeb.airlinereservationsystem.response.ExecutiveResponse;
import com.javafullstackfeb.airlinereservationsystem.service.AirlineExecutiveService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
public class ExecutiveController {
	@Autowired
	private AirlineExecutiveService executiveService;

	@PostMapping("/getOccupancy")
	public ExecutiveResponse getFlight(@RequestBody FlightInformation flightInformation) {
		String flightNumber = flightInformation.getFlightNumber();
		AirlineExecutiveBeans executive = executiveService.viewFlightOccupancy(flightNumber);
		ExecutiveResponse response = new ExecutiveResponse();
		if (executive != null) {
			response.setStatus(210);
			response.setMessage("Flight Occupancy retrieved sucessfully.");
			response.setDescription("All the occupancy of flightNo : " + flightNumber + " are reterived successfully.");
			response.setExecutive(executive);
		} else {

			response.setStatus(401);
			response.setMessage("No data available for the flightNo. : " + flightNumber);
			response.setDescription("No data available for the flightNo. : " + flightNumber);

		}
		return response;

	}// end of getflight()
}

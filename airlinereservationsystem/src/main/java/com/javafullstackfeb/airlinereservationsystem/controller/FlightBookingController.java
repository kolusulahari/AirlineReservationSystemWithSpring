package com.javafullstackfeb.airlinereservationsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javafullstackfeb.airlinereservationsystem.beans.FlightBooking;
import com.javafullstackfeb.airlinereservationsystem.response.BookingResponse;
import com.javafullstackfeb.airlinereservationsystem.response.FlightResponse;
import com.javafullstackfeb.airlinereservationsystem.service.FlightService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
public class FlightBookingController {

	@Autowired
	private FlightService service;

	@PostMapping("/bookFlight")
	public FlightResponse bookFlight(@RequestBody FlightBooking flightBooking) {

		FlightBooking bookinginfo = service.bookFlight(flightBooking);
		String bookingId = bookinginfo.getBookingId();
		double totalFare = bookinginfo.getTotalFare();

		FlightResponse response = new FlightResponse();
		if (bookinginfo != null) {
			response.setStatusCode(201);
			response.setMessage("Congratulations!Sir/Mam Flight booked successfully.");
			response.setDescription("Congratulations! Flight booked successfully. Your BookingId is " + bookingId);
			response.setBookingid(bookingId);
			response.setTotalFare(totalFare);
			System.out.println("insert success"+response);
		} else {
			System.out.println("insert failed");
			response.setStatusCode(401);
			response.setMessage("Oops! Flight booking failed.");
			response.setDescription(" Oops! Flight booked failed due to unavailability of seats.");
		}
		return response;
	}

	@GetMapping(path = "/getAllBooking/{userId}")
	public BookingResponse getAllBookingInfo( @PathVariable("userId") String userId) {
		
		//userId= "chandu123";
		System.out.println("inide getAllBooking : "+userId);
		List<FlightBooking> allBookingInfo = service.getAllBooking(userId);
		BookingResponse response = new BookingResponse();
		if (allBookingInfo != null) {
			response.setStatusCode(210);
			response.setMessage("All the flight booking information retrieved successfully.");
			response.setDescription("All the flight booking information retrieved successfully for userId : " + userId);
			response.setGetAllBookingInfo(allBookingInfo);
		} else {

			response.setStatusCode(401);
			response.setMessage("No booking found!");
			response.setDescription(" No booking found " + userId);

		}
		System.out.println("response :"+response);
		return response;

	}// end of getAllBookingInfo()

	@DeleteMapping("/deleteBooking")
	public BookingResponse deleteBooking(String bookingId) {
		System.out.println("xcfxsvc"+bookingId);
		boolean isDeleted = service.deleteBooking(bookingId);
		BookingResponse response = new BookingResponse();
		if (isDeleted) {
			response.setStatusCode(201);
			response.setMessage("Congratulation! Flight booking cancelled successfully. We will refund your payment within 3 working days. ");
			response.setDescription("Congratulation! Flight booking cancelled successfully. We will refund your payment within 3 working days ");
		} else {
			response.setStatusCode(401);
			response.setMessage("Oops! Flight booking can not be cancelled.");
			response.setDescription("Oops! Flight booking can not be cancelled.");

		}
		return response;
	}
}

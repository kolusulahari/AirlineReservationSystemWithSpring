package com.javafullstackfeb.airlinereservationsystem.response;

import java.util.List;

import com.javafullstackfeb.airlinereservationsystem.beans.FlightBooking;

public class BookingResponse {
	private int statusCode;
	private String message;
	private String description;
	private FlightBooking flightBooking;
	private List<FlightBooking> searchFlight;
	private List<FlightBooking> getAllBookingInfo;

	public List<FlightBooking> getGetAllBookingInfo() {
		return getAllBookingInfo;
	}

	public void setGetAllBookingInfo(List<FlightBooking> getAllBookingInfo) {
		this.getAllBookingInfo = getAllBookingInfo;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public FlightBooking getFlightBooking() {
		return flightBooking;
	}

	public void setFlightBooking(FlightBooking flightBooking) {
		this.flightBooking = flightBooking;
	}

	public List<FlightBooking> getSearchFlight() {
		return searchFlight;
	}

	public void setSearchFlight(List<FlightBooking> searchFlight) {
		this.searchFlight = searchFlight;
	}

	@Override
	public String toString() {
		return "BookingResponse [statusCode=" + statusCode + ", message=" + message + ", description=" + description
				+ ", flightBooking=" + flightBooking + ", searchFlight=" + searchFlight + ", getAllBookingInfo="
				+ getAllBookingInfo + "]";
	}

	
}

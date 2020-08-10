package com.javafullstackfeb.airlinereservationsystem.response;

import java.util.List;

import com.javafullstackfeb.airlinereservationsystem.beans.FlightInformation;

public class FlightResponse {
	private int statusCode;
	private String message;
	private String description;
	private String bookingid;
	private double totalFare;
	private FlightInformation flightInformation;
	private List<FlightInformation> searchFlight;

	
	public double getTotalFare() {
		return totalFare;
	}

	public void setTotalFare(double totalFare) {
		this.totalFare = totalFare;
	}

	public String getBookingid() {
		return bookingid;
	}

	public void setBookingid(String bookingid) {
		this.bookingid = bookingid;
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

	public FlightInformation getFlightInformation() {
		return flightInformation;
	}

	public void setFlightInformation(FlightInformation flightInformation) {
		this.flightInformation = flightInformation;
	}

	public List<FlightInformation> getSearchFlight() {
		return searchFlight;
	}

	public void setSearchFlight(List<FlightInformation> searchFlight) {
		this.searchFlight = searchFlight;
	}

	@Override
	public String toString() {
		return "FlightResponse [statusCode=" + statusCode + ", message=" + message + ", description=" + description
				+ ", bookingid=" + bookingid + ", totalFare=" + totalFare + ", flightInformation=" + flightInformation
				+ ", searchFlight=" + searchFlight + "]";
	}
	
	

}

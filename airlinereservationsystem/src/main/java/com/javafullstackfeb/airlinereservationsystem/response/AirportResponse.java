package com.javafullstackfeb.airlinereservationsystem.response;

import java.util.List;

import com.javafullstackfeb.airlinereservationsystem.beans.AirportBeans;
import com.javafullstackfeb.airlinereservationsystem.beans.FlightInformation;

public class AirportResponse {
	
	private int statusCode;
	private String message;
	private String description;
	private List<AirportBeans> searchAirport;
	public List<AirportBeans> getSearchAirport() {
		return searchAirport;
	}
	public void setSearchAirport(List<AirportBeans> searchAirport) {
		this.searchAirport = searchAirport;
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

}

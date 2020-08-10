package com.javafullstackfeb.airlinereservationsystem.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "flight_Info")
public class FlightInformation {

	@Id
	@Column(name = "flightno")
	//@Pattern(regexp = "{A-Z0-9}*")
	private String flightNumber; // Each flight has a unique flight number.

	@Column(name = "departure_city")
	//@Pattern(regexp = "{A-Za-z}*")
	private String departureCity;

	@Column(name = "arrival_city")
	//@Pattern(regexp = "{A-Za-z}*")
	private String arrivalCity;

	@Column(name = "airline")
	//@Pattern(regexp = "{A-Za-z}*")
	private String airline;

	@Column(name = "dep_date")
	private String departureDate;

	@Column(name = "arr_date")
	private String arrivalDate;

	@Column(name = "dep_time")
	private String departureTime;

	@Column(name = "arr_time")
	private String arrivalTime;

	@Column(name = "first_seats")
	@Positive
	private int firstClassSeats;

	@Column(name = "first_fare")
	@Positive
	private double firstClassSeatFare;

	@Column(name = "buss_seats")
	@Positive
	private int bussinessClassSeats;

	@Column(name = " buss_Seats_Fare")
	@Positive
	private double bussinessClassFare;

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getDepartureCity() {
		return departureCity;
	}

	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}

	public String getArrivalCity() {
		return arrivalCity;
	}

	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public String getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public int getFirstClassSeats() {
		return firstClassSeats;
	}

	public void setFirstClassSeats(int firstClassSeats) {
		this.firstClassSeats = firstClassSeats;
	}

	public double getFirstClassSeatFare() {
		return firstClassSeatFare;
	}

	public void setFirstClassSeatFare(double firstClassSeatFare) {
		this.firstClassSeatFare = firstClassSeatFare;
	}

	public int getBussinessClassSeats() {
		return bussinessClassSeats;
	}

	public void setBussinessClassSeats(int bussinessClassSeats) {
		this.bussinessClassSeats = bussinessClassSeats;
	}

	public double getBussinessClassFare() {
		return bussinessClassFare;
	}

	public void setBussinessClassFare(double bussinessClassFare) {
		this.bussinessClassFare = bussinessClassFare;
	}

//getters and setters

}

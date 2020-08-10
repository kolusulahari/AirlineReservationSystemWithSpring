package com.javafullstackfeb.airlinereservationsystem.beans;

import javax.persistence.*;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "airlineExecutive")
public class AirlineExecutiveBeans {

	@Id
	@Column
	private String flightNumber;

	@Column
	@Positive
	private long totalSeats;

	@Column
	@Positive
	private long totalBussinessClassSeats;

	@Column
	@Positive
	private long totalFirstClassSeats;

	@Column
	@Positive
	private int availableBussinessClassSeats;

	@Column
	@Positive
	private long bookedBussinessClassSeats;

	@Column
	@Positive
	private int availableFirstClassSeats;

	@Column
	@Positive
	private long bookedFirstClassSeats;

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public long getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(long totalSeats) {
		this.totalSeats = totalSeats;
	}

	public long getTotalBussinessClassSeats() {
		return totalBussinessClassSeats;
	}

	public void setTotalBussinessClassSeats(long totalBussinessClassSeats) {
		this.totalBussinessClassSeats = totalBussinessClassSeats;
	}

	public long getTotalFirstClassSeats() {
		return totalFirstClassSeats;
	}

	public void setTotalFirstClassSeats(long totalFirstClassSeats) {
		this.totalFirstClassSeats = totalFirstClassSeats;
	}

	public int getAvailableBussinessClassSeats() {
		return availableBussinessClassSeats;
	}

	public void setAvailableBussinessClassSeats(int availableBussinessClassSeats) {
		this.availableBussinessClassSeats = availableBussinessClassSeats;
	}

	public long getBookedBussinessClassSeats() {
		return bookedBussinessClassSeats;
	}

	public void setBookedBussinessClassSeats(long bookedBussinessClassSeats) {
		this.bookedBussinessClassSeats = bookedBussinessClassSeats;
	}

	public int getAvailableFirstClassSeats() {
		return availableFirstClassSeats;
	}

	public void setAvailableFirstClassSeats(int availableFirstClassSeats) {
		this.availableFirstClassSeats = availableFirstClassSeats;
	}

	public long getBookedFirstClassSeats() {
		return bookedFirstClassSeats;
	}

	public void setBookedFirstClassSeats(long bookedFirstClassSeats) {
		this.bookedFirstClassSeats = bookedFirstClassSeats;
	}

}

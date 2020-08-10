package com.javafullstackfeb.airlinereservationsystem.beans;

import javax.persistence.*;
import javax.validation.constraints.Positive;


@Entity
@Table(name = "airport")
public class AirportBeans {
	@Id
	@Column(name = "abbr", unique = true)
	
	private String abbreviation;

	@Column
	
	private String airportName;

	@Column
	
	private String state;

	@Column
	
	private String city;

	@Column
	@Positive
	
	private int zipCode;

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getAirportName() {
		return airportName;
	}

	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

}

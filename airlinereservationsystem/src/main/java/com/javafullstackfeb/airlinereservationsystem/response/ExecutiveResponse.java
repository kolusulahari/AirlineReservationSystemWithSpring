package com.javafullstackfeb.airlinereservationsystem.response;

import com.javafullstackfeb.airlinereservationsystem.beans.AirlineExecutiveBeans;

public class ExecutiveResponse {
	private int status;
	private String message;
	private String description;
	private AirlineExecutiveBeans executive;

	public AirlineExecutiveBeans getExecutive() {
		return executive;
	}

	public void setExecutive(AirlineExecutiveBeans executive) {
		this.executive = executive;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}

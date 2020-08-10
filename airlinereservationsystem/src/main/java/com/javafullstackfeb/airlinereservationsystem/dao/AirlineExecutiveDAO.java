package com.javafullstackfeb.airlinereservationsystem.dao;

import com.javafullstackfeb.airlinereservationsystem.beans.AirlineExecutiveBeans;

public interface AirlineExecutiveDAO {

	public AirlineExecutiveBeans viewFlightOccupancy(String flightNumber);

}

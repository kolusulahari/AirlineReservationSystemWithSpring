package com.javafullstackfeb.airlinereservationsystem.dao;


import com.javafullstackfeb.airlinereservationsystem.beans.AirportBeans;

public interface AirportDAO {

	public boolean addAirport(AirportBeans airport);

	public boolean updateAirport(AirportBeans airport);

	public boolean deleteAirport(String abbreviation);

}

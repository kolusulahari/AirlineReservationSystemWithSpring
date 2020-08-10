package com.javafullstackfeb.airlinereservationsystem.dao;

import java.util.List;

import com.javafullstackfeb.airlinereservationsystem.beans.FlightBooking;

public interface BookingDAO {

	public FlightBooking bookFlight(FlightBooking flightBooking);

	public List<FlightBooking> getAllBooking(String userId);
	
	public boolean deleteBooking(String bookingId);
}

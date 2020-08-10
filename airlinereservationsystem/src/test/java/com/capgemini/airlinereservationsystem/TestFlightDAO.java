package com.capgemini.airlinereservationsystem;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.javafullstackfeb.airlinereservationsystem.beans.FlightInformation;
import com.javafullstackfeb.airlinereservationsystem.dao.FlightDAO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestFlightDAO {

	@Autowired
	private FlightDAO flightDAO;

	@Test
	public void addFlightTest() {

		FlightInformation flightInformation = new FlightInformation();
		flightInformation.setFlightNumber("123ab");
		flightInformation.setAirline("Indigo");
		flightInformation.setDepartureTime("11:30 AM");
		flightInformation.setArrivalTime("12:00 AM");
		flightInformation.setArrivalCity("Lucknow");
		flightInformation.setDepartureCity("Delhi");
		flightInformation.setBussinessClassFare(2000);
		flightInformation.setFirstClassSeats(2);
		flightInformation.setBussinessClassSeats(3);
		flightInformation.setFirstClassSeatFare(1500);
		flightInformation.setArrivalDate("12-05-2019");
		flightInformation.setDepartureDate("13-05-2019");

		assertEquals(true, flightDAO.addFlight(flightInformation));

	}

}

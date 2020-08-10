package com.javafullstackfeb.airlinereservationsystem.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.javafullstackfeb.airlinereservationsystem.beans.AirportBeans;
import com.javafullstackfeb.airlinereservationsystem.beans.FlightInformation;

@Repository
public class FlightDAOJpaImpl implements FlightDAO {

	@PersistenceUnit
	private EntityManagerFactory emf;
	List<AirportBeans> airportList = new ArrayList<AirportBeans>();

	@Override
	public FlightInformation getFlight(String flightNumber) {
		EntityManager manager = emf.createEntityManager();
		FlightInformation flightInformation = manager.find(FlightInformation.class, flightNumber);
		manager.close();
		return flightInformation;
	}

	@Override
	public boolean addFlight(FlightInformation flightInformation) {

		getAllAirport();
		EntityManager manager = emf.createEntityManager();
		EntityTransaction tx = manager.getTransaction();

		String departureCity = flightInformation.getDepartureCity();
		String arrivalCity = flightInformation.getArrivalCity();

		boolean isAdded = false;
		try {
			tx.begin();
			if (airportList != null) {
				for (AirportBeans airportBeans : airportList) {
					if (departureCity.equalsIgnoreCase(airportBeans.getCity())) {
						for (AirportBeans airportBeans1 : airportList) {
							if (arrivalCity.equalsIgnoreCase(airportBeans1.getCity())) {
								manager.persist(flightInformation);
								isAdded = true;
							} else {
								continue;
							}
						}
					} else {
						continue;
					}
				}
			} else {
				return false;
			}
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		manager.close();
		return isAdded;
	}

	@Override
	public boolean updateFlight(FlightInformation flightInformation) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction tx = manager.getTransaction();

		boolean isUpdated = false;
		try {
			tx.begin();
			FlightInformation flightInfo = manager.find(FlightInformation.class, flightInformation.getFlightNumber());

			if (flightInfo != null) {
				if (flightInformation.getDepartureDate() != null && flightInformation.getDepartureTime() != null) {
					System.out.println(flightInformation.getAirline());
					flightInfo.setDepartureDate(flightInformation.getDepartureDate());
					flightInfo.setDepartureTime(flightInformation.getDepartureTime());
					flightInfo.setAirline(flightInformation.getAirline());
					flightInfo.setArrivalCity(flightInformation.getArrivalCity());
					flightInfo.setDepartureCity(flightInformation.getDepartureCity());
					flightInfo.setBussinessClassFare(flightInformation.getBussinessClassFare());
					flightInfo.setBussinessClassSeats(flightInformation.getBussinessClassSeats());
					flightInfo.setFirstClassSeatFare(flightInformation.getFirstClassSeatFare());
					flightInfo.setFirstClassSeats(flightInformation.getFirstClassSeats());
					flightInfo.setArrivalDate(flightInformation.getArrivalDate());
					flightInfo.setArrivalTime(flightInformation.getArrivalTime());
					
					manager.persist(flightInfo);
					isUpdated = true;
					tx.commit();
					
				}
			} else {

				isUpdated = false;
			}
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		manager.close();
		return isUpdated;
	}

	@Override
	public boolean deleteFlight(String flightNumber) {
		EntityManager entityManager = emf.createEntityManager();
		FlightInformation flightInformation = entityManager.find(FlightInformation.class, flightNumber);
		boolean isDeleted = false;

		try {
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			entityManager.remove(flightInformation);
			tx.commit();
			isDeleted = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		entityManager.close();
		return isDeleted;
	}

	// Search Flight details...
	@Override
	public List<FlightInformation> search(String departureCity, String arrivalCity, String departureDate) {
		EntityManager manager = emf.createEntityManager();
		String jpql = "from FlightInformation where departureCity = :departure and arrivalCity = :arrival and departureDate= :date";
		Query query = manager.createQuery(jpql);
		query.setParameter("departure", departureCity);
		query.setParameter("arrival", arrivalCity);
		query.setParameter("date", departureDate);
		List<FlightInformation> flightList = null;
		try {
			flightList = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flightList;
	}

	@Override
	public List<FlightInformation> getAllFlights() {
		EntityManager manager = emf.createEntityManager();
		String jpql = "from FlightInformation";
		Query query = manager.createQuery(jpql);

		List<FlightInformation> flightList = null;
		try {
			flightList = query.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
 		}

		return flightList;
	} 

	@Override
	public List<AirportBeans> getAllAirport() {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction tx = manager.getTransaction();
		Query query = manager.createQuery("FROM AirportBeans");
		airportList = query.getResultList();

		return airportList;
	}

}

package springdemo.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Set;

import springdemo.entity.Arrival;
import springdemo.entity.Client;
import springdemo.entity.Departure;
import springdemo.entity.Flight;
import springdemo.entity.Reservation;

public interface FlightService {
	
	// User panel methods
	public List <Departure> getDeparturePlaces();
	
	public List <Arrival> getArrivalPlaces();
	
	public List <Flight> getFlight(String destinationPlace, String arrivalPlace, String date,
									String flightClass ,int numberOfPassangers 
									) throws ParseException;
	
	public void saveClient(Client theClient);
	
	public void saveReservation(String flightNumber, String flightClass, String numberOfPassangers, Client theClient);

	
	// Admin panel methods
	public List<Client> getClients();

	public List<Reservation> getReservations();
	
	public String deleteFlight(int id) throws ParseException;
	
	public void saveFlight(Flight flight);
	
	public String deleteDeparture(int id);
	
	public void saveDeparture(Departure departure);
	
	public String deleteArrival(int id);
	
	public void saveArrival(Arrival arrival);
	
	public Departure getDeparture(String departurePlace);
	
	public Arrival getArrival(String arrivalPlace);
	
}

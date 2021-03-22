package springdemo.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springdemo.dao.FlightServiceDAO;
import springdemo.entity.Arrival;
import springdemo.entity.Client;
import springdemo.entity.Departure;
import springdemo.entity.Flight;
import springdemo.entity.Reservation;

@Service
public class FlightServiceImpl implements FlightService {

	
	@Autowired
	private FlightServiceDAO flightServiceDAO;
	
	
	@Override
	@Transactional
	public  List <Departure>  getDeparturePlaces() {
		return flightServiceDAO.getDeparturePlaces();
	}

	@Override
	@Transactional
	public List<Arrival> getArrivalPlaces() {
		return flightServiceDAO.getArrivalPlaces();
	}

	@Override
	@Transactional
	public List <Flight> getFlight(String destinationPlace, String arrivalPlace, String date, String flightClass,
			int numberOfPassangers) throws ParseException {
		return flightServiceDAO.getFlight(destinationPlace, arrivalPlace, date, flightClass, numberOfPassangers);
	}

	@Override
	@Transactional
	public void saveClient(Client theClient) {
		
		flightServiceDAO.saveClient(theClient);
	}

	@Override
	@Transactional
	public void saveReservation(String flightNumber, String flightClass, String numberOfPassangers, Client theClient) {
		
		flightServiceDAO.saveReservation(flightNumber, flightClass, numberOfPassangers, theClient);
		
	}

	@Override
	@Transactional
	public List<Client> getClients() {
		return this.flightServiceDAO.getClients();
	}

	@Override
	@Transactional
	public List<Reservation> getReservations() {
		return this.flightServiceDAO.getReservations();
	}

	@Override
	@Transactional
	public String deleteArrival(int id) {
		
		return this.flightServiceDAO.deleteArrival(id);
	}

	@Override
	@Transactional
	public void saveArrival(Arrival arrival) {

		this.flightServiceDAO.saveArrival(arrival);
		
	}

	@Override
	@Transactional
	public String deleteDeparture(int id) {
		return this.flightServiceDAO.deleteDeparture(id);
	}

	@Override
	@Transactional
	public void saveDeparture(Departure departure) {
		this.flightServiceDAO.saveDeparture(departure);
	}

	@Override
	@Transactional
	public String deleteFlight(int id) throws ParseException {
		return this.flightServiceDAO.deleteFlight(id);
	}

	@Override
	@Transactional
	public void saveFlight(Flight flight) {
		this.flightServiceDAO.saveFlight(flight);
	}

	@Override
	@Transactional
	public Departure getDeparture(String departurePlace) {
		return this.flightServiceDAO.getDeparture(departurePlace);
	}

	@Override
	@Transactional
	public Arrival getArrival(String arrivalPlace) {
		return this.flightServiceDAO.getArrival(arrivalPlace);
	}
	
	
	
	
	
}

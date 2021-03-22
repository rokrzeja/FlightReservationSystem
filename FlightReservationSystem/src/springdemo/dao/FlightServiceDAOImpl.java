package springdemo.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import springdemo.entity.Arrival;
import springdemo.entity.Client;
import springdemo.entity.Departure;
import springdemo.entity.Flight;
import springdemo.entity.Reservation;

@Repository
public class FlightServiceDAOImpl implements FlightServiceDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	//user panel methods
	@Override
	public List <Departure> getDeparturePlaces() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = currentSession.createQuery("from Departure",Departure.class);
		
		List <Departure> departures = theQuery.getResultList();
		
		return departures;
	}

	
	@Override
	public List <Arrival> getArrivalPlaces() {

		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = currentSession.createQuery("from Arrival order by arrivalPlace",
				Arrival.class);
		
		List <Arrival> arrivals = theQuery.getResultList();
		
		return arrivals;
	}

	// return list of flights that meet the requirements of user
	@Override
	public List<Flight> getFlight(String destinationPlace, String arrivalPlace, String date,
									String flightClass, int numberOfPassangers
									) throws ParseException {

		Session currentSession = sessionFactory.getCurrentSession();

		Query theQuery1 = currentSession.createQuery("from Departure where departurePlace=:place");
		theQuery1.setParameter("place", destinationPlace);
		List <Departure> departurelist = theQuery1.getResultList();
		Departure departure = departurelist.get(0);
		
		Query theQuery2 = currentSession.createQuery("from Arrival where arrivalPlace=:place");
		theQuery2.setParameter("place", arrivalPlace);
		List <Arrival> arrivallist = theQuery2.getResultList();
		Arrival arrival = arrivallist.get(0);
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date2 = format.parse(date);

		Query theQuery = currentSession.createQuery("from Flight where departure=:departurePlace and arrival=:arrivalPlace and departureDate >= :date order by departureDate" );
		theQuery.setParameter("departurePlace", departure);
		theQuery.setParameter("arrivalPlace", arrival);
		theQuery.setDate("date", date2);

		List <Flight> flights = theQuery.getResultList();
		
		return flights;
	}

	// add client personal data to database if client isn't in db
	@Override
	public void saveClient(Client theClient) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = currentSession.createQuery("from Client", Client.class);
		List <Client> clients = theQuery.getResultList();
		
		boolean alreadyexists = false;
		int id=0;
		for(int i=0; i<clients.size(); i++)
		{
			if(clients.get(i).getFirstName().equals(theClient.getFirstName()) && 
					clients.get(i).getLastName().equals(theClient.getLastName()) &&
					clients.get(i).getBirthplace().equals(theClient.getBirthplace()) &&
					clients.get(i).getBirthday().equals(theClient.getBirthday()) 
					){
				alreadyexists = true;
				id = clients.get(i).getId();
			}
				
		}
		if(!alreadyexists) currentSession.save(theClient);
		else theClient.setId(id);
		
	}

	
	@Override
	public void saveReservation(String flightNumber, String flightClass, String numberOfPassangers, Client theClient) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Reservation theReservation = new Reservation();
		
		Query flightQuery = currentSession.createQuery("from Flight where flightNumber=:number");
		flightQuery.setParameter("number", Integer.parseInt(flightNumber));
		List <Flight> flights = flightQuery.getResultList();
		
		int numberOfPassangerInt = Integer.parseInt(numberOfPassangers);
		
		int fprice;
		if(flightClass.equals("Business")) fprice = flights.get(0).getFlightPrice()*3;
		else if (flightClass.equals("First")) fprice = flights.get(0).getFlightPrice()*5;
		else fprice = flights.get(0).getFlightPrice();
		int fullPrice = numberOfPassangerInt * fprice;
		
		theReservation.setClient(theClient);
		theReservation.setFlight(flights.get(0));
		theReservation.setFlightClass(flightClass);
		theReservation.setNumberOfPassangers(numberOfPassangerInt);
		theReservation.setFullPrice(fullPrice);
		
		currentSession.save(theReservation);
		
	}

	
	

	// Admin Controll Panell methods
	@Override
	public List <Client> getClients() {

		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = currentSession.createQuery("from Client", Client.class);
		
		List <Client> clients = theQuery.getResultList();

		return clients;
	}

	@Override
	public List<Reservation> getReservations() {
	
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = currentSession.createQuery("from Reservation", Reservation.class);
		
		List <Reservation> reservations = theQuery.getResultList();
		
		return reservations;
	}

	@Override
	public String deleteArrival(int id) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		return deleteDirection(currentSession,"Arrival", id);
	}	

	@Override
	public void saveArrival(Arrival arrival) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(arrival);
		
	}

	@Override
	public String deleteDeparture(int id) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		return deleteDirection(currentSession,"Departure", id);
	}

	@Override
	public void saveDeparture(Departure departure) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(departure);
	}
	
	@Override
	public String deleteFlight(int id) throws ParseException {

		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = currentSession.createQuery("from Flight where id=:flightid");
		theQuery.setParameter("flightid", id);

		List <Flight> flights = theQuery.getResultList();
		String flightStringDate = flights.get(0).getDepartureDate();
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date flightDate = format.parse(flightStringDate);
		
		String todayStringDate= new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		Date today = format.parse(todayStringDate);
		
		if(flightDate.before(today))
		{
			Query deleteQuery = currentSession.createQuery("delete from Flight where id=:flightId");
			deleteQuery.setParameter("flightId", id);
			
			deleteQuery.executeUpdate();
			
			return "false";	
		}
		else
		{
			Query theQuery2 = currentSession.createQuery("from Reservation where flight.id=:ajdi");
			theQuery2.setParameter("ajdi", id);

			List <Reservation> reservations = theQuery2.getResultList();

			if(reservations.size() > 0 ) return "true";
			else 	
			{
				Query deleteQuery = currentSession.createQuery("delete from Flight where id=:flightId");
				deleteQuery.setParameter("flightId", id);
				
				deleteQuery.executeUpdate();
				
				return "false";
			}

		}
	}
	
	@Override
	public void saveFlight(Flight flight) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(flight);
		
	}

	@Override
	public Departure getDeparture(String departurePlace) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = currentSession.createQuery("from Departure where departurePlace=:place");
		theQuery.setParameter("place", departurePlace);
		
		List <Departure> departures = theQuery.getResultList();
		
		return departures.get(0);
	}

	@Override
	public Arrival getArrival(String arrivalPlace) {
		
		Session currentSession = sessionFactory.getCurrentSession();
	
		Query theQuery = currentSession.createQuery("from Arrival where arrivalPlace=:place");
		theQuery.setParameter("place", arrivalPlace);
		
		List <Arrival> arrivals = theQuery.getResultList();
		
		return arrivals.get(0);
	}
	
	
	public static String deleteDirection(Session currentSession, String direction, int id) {
		
		Query theQuery = currentSession.createQuery("from Flight where "+direction.toLowerCase()+".id=:directionId");
		theQuery.setParameter("directionId", id);
		
		List <Flight> flights = theQuery.getResultList();

		if(flights.size() > 0) return "true";
		else
		{
			Query theQuery2 = currentSession.createQuery("delete from "+direction+" where id=:directionId");
			theQuery2.setParameter("directionId", id);
			
			theQuery2.executeUpdate();
			
			return "false";
		}
		
	}

}

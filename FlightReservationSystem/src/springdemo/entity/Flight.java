package springdemo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@Entity
@Table(name="flight")
public class Flight {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_flight")
	private int id;
	
	@Min(value=1000, message="use 4 or more digits")
	@Max(value=100000000, message="use 8 or less digits")
	@Column(name="flight_number")
	private int flightNumber;

	@ManyToOne(cascade= { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="id_departure")
	private Departure departure;
	
	//@NotBlank(message="is required")
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="id_arrival")
	private Arrival arrival;
	
	
	@Column(name="date")
	private String departureDate;
	
	@NotBlank(message="is required")
	@Column(name="departure_time")
	private String departureTime;
	
	@NotBlank(message="is required")
	@Column(name="arrival_time")
	private String arrivalTime;
	
	@Min(value=10, message="price should be more than 10")
	@Max(value=10000, message="price should be less than 10 000")
	@Column(name="flight_price")
	private int flightPrice;
	
	@OneToMany (fetch = FetchType.LAZY,
			cascade = {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH},
			mappedBy = "flight")
	private List <Reservation> reservations;
	
	
	
	
	public Flight() {}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}

	public Departure getDeparture() {
		return departure;
	}


	public void setDeparture(Departure departure) {
		this.departure = departure;
	}

	public Arrival getArrival() {
		return arrival;
	}


	public void setArrival(Arrival arrival) {
		this.arrival = arrival;
	}


	public String getDepartureDate() {
		return departureDate;
	}


	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public String getDepartureTime() {
		return departureTime;
	}


	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}


	public String getArrivalTime() {
		return arrivalTime;
	}


	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}


	public int getFlightPrice() {
		return flightPrice;
	}


	public void setFlightPrice(int flightPrice) {
		this.flightPrice = flightPrice;
	}
	


	public List<Reservation> getReservations() {
		return reservations;
	}


	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}


	


	

	

}

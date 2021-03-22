package springdemo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;


@Entity
@Table(name="departure")
public class Departure {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_departure")
	private int id;
	
	@Pattern(regexp="^[a-zA-Z]{2,25}", message="from 2 to 25 chairs are required ")
	@Column(name="place")
	private String departurePlace;

	@Pattern(regexp="^[a-zA-Z]{2,25}", message="from 2 to 25 chairs are required ")
	@Column(name="country")
	private String departureCountry;
	
	@OneToMany(fetch = FetchType.LAZY,
			mappedBy = "departure",
			cascade = {CascadeType.DETACH, CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	private List <Flight> flights;
	
	
	
	public Departure() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDeparturePlace() {
		return departurePlace;
	}

	public void setDeparturePlace(String departurePlace) {
		this.departurePlace = departurePlace;
	}

	public String getDepartureCountry() {
		return departureCountry;
	}

	public void setDepartureCountry(String departureCountry) {
		this.departureCountry = departureCountry;
	}

	public List<Flight> getFlights() {
		return flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}

	@Override
	public String toString() {
		return "Departure [id=" + id + ", departurePlace=" + departurePlace + ", flights=" + flights + "]";
	}
	
	
	
	
	
}

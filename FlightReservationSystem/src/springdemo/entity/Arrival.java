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
@Table(name="arrival")
public class Arrival {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_arrival")
	private int id;
	
	@Pattern(regexp="^[a-zA-Z]{2,25}", message="from 2 to 25 chairs are required ")
	@Column(name="place")
	private String arrivalPlace;
	
	@Pattern(regexp="^[a-zA-Z]{2,25}", message="from 2 to 25 chairs are required ")
	@Column(name="country")
	private String arrivalCountry;
	
	@OneToMany( fetch = FetchType.LAZY,
			cascade = {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH },
			mappedBy = "arrival")
	private List <Flight> flights;
	
	
	
	
	
	public Arrival() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getArrivalPlace() {
		return arrivalPlace;
	}

	public void setArrivalPlace(String arrivalPlace) {
		this.arrivalPlace = arrivalPlace;
	}

	public String getArrivalCountry() {
		return arrivalCountry;
	}

	public void setArrivalCountry(String arrivalCountry) {
		this.arrivalCountry = arrivalCountry;
	}

	public List<Flight> getFlights() {
		return flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}

	@Override
	public String toString() {
		return "Arrival [id=" + id + ", arrivalPlace=" + arrivalPlace + ", flights=" + flights + "]";
	}

	

}

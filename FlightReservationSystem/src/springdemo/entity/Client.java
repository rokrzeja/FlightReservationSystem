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
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
@Entity
@Table(name="clientt")
public class Client {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	//@NotNull(message="is required")
	@Column(name="id_client")
	private int id;
	
	@Pattern(regexp="^[a-zA-Z]{2,25}", message="from 2 to 25 chairs are required ")
	@Column(name="first_name")
	private String firstName;
	
	@Pattern(regexp="^[a-zA-Z]{2,25}", message="from 2 to 25 chairs are required ")
	@Column(name="last_name")
	private String lastName;
	
	@NotNull(message="is required")
	@Column(name="sex")
	private String sex;
	
	@NotNull(message="is required")
	@Pattern(regexp="(19[0-9][0-9]|200[0-3])-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])", message="incorect date format")
	@Column(name="birthday")
	private String birthday;
	
	@Pattern(regexp="^[a-zA-Z]{2,25}", message="from 2 to 25 chairs are required ")
	@Column(name="birthplace")
	private String birthplace;
	
	@Min(value=100000000, message=" 9 digits are required ")
	@Max(value=999999999, message=" 9 digits are required ")
	@Column(name="telephone_number")
	private int telephoneNumber;
	
	@Email (message="email should be valid")
	@Column(name="email")
	private String email;
	
	@OneToMany( fetch = FetchType.LAZY,
			cascade = {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH},
			mappedBy = "client")
	private List <Reservation> reservations;
	
	public Client() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getBirthplace() {
		return birthplace;
	}

	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}

	public int getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(int telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", sex=" + sex
				+ ", birthday=" + birthday + ", birthplace=" + birthplace + ", telephoneNumber=" + telephoneNumber
				+ ", email=" + email + "]";
	}
	
	
	

}

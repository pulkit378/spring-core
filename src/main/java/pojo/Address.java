package pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ADDRESS")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Address_id")
	private int address_id;
	
	
	@Column(name = "STREET")
	private String street;
	
	
	@Column(name = "CITY")
	private String city;
	
	
	@Column(name = "STATE")
	private String state;
	
	
	@Column(name = "ZIP_CODE")
	private int zipcode;
	
	@ManyToOne
	@JoinColumn(name = "id", nullable = false)
	private customer cust;
	

	public Address() {
	}

	public Address(String street, String city, String state, int zipcode) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}


	public int getAddress_id() {
		return address_id;
	}

	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	

	public customer getCust() {
		return cust;
	}

	public void setCust(customer cust) {
		this.cust = cust;
	}
	
	
	
	
	
}
package pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "customer")
public class customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "first_name")
	private String firstName; 
	   
	@Column(name = "last_name")
	private String lastName;   
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "COMPANY")
	private String company;
	   
	@Column(name = "DISPLAY_NAME")
	private String display_name;
	   
	@Column(name = "OTHER_DETAILS")
	private String otherDetails;
	
	@Column(name = "ZIP_CODE")
	private int zipCode;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cust", cascade = CascadeType.ALL)
	private Set<Address> addresses = new HashSet<Address>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Customer", cascade = CascadeType.ALL)
	private Set<order> orders = new HashSet<order>();
	


	public customer() {}
	   
		
	   
	    public customer(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;

	}



	public int getId() {
	      return id;
	   }
	   
	   public void setId( int id ) {
	      this.id = id;
	   }
	   
	   public String getFirstName() {
	      return firstName;
	   }
	   
	   public void setFirstName( String first_name ) {
	      this.firstName = first_name;
	   }
	   
	   public String getLastName() {
	      return lastName;
	   }
	   
	   public void setLastName( String last_name ) {
	      this.lastName = last_name;
	   }
	   

	   public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getCompany() {
			return company;
		}

		public void setCompany(String company) {
			this.company = company;
		}

		public String getDisplay_name() {
			return display_name;
		}

		public void setDisplay_name(String display_name) {
			this.display_name = display_name;
		}


		public String getOtherDetails() {
			return otherDetails;
		}

		public void setOtherDetails(String otherDetails) {
			this.otherDetails = otherDetails;
		}


		
		public Set<Address> getAddresses() {
			return addresses;
		}



		public void setAddresses(Set<Address> addresses) {
			this.addresses = addresses;
		}



		public Set<order> getOrders() {
			return orders;
		}



		public void setOrders(Set<order> orders) {
			this.orders = orders;
		}



		public int getZipCode() {
			return zipCode;
		}



		public void setZipCode(int zipCode) {
			this.zipCode = zipCode;
		}



		@Override
		public String toString() {
			return "customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
					+ ", company=" + company + ", display_name=" + display_name + ", otherDetails=" + otherDetails
					+ ", zipCode=" + zipCode + "]";
		}
	  	
		
		
		
}

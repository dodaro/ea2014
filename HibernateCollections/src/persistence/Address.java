package persistence;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	
	private String street;
	
	public Address() {
		// TODO Auto-generated constructor stub
		street = "";
	}
	
	public Address(String street) {
		this.street = street;
	}

	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}		
}

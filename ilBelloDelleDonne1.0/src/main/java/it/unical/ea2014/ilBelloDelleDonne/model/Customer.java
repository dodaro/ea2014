package it.unical.ea2014.ilBelloDelleDonne.model;


import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="Customer")
@PrimaryKeyJoinColumn(name="username")
public class Customer extends User {

	private static final long serialVersionUID = 1L;

	@Column(name = "pIva_cf")
	private String pIva_cf;
	
	@Column(name="streetAddress")
	private String streetAddress;
	
	@OneToMany(mappedBy="customer", fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
	private List<Acquire> acquires;
	

	public Customer() {
		super();	
		this.pIva_cf = "lgrvcn89t02d005r";
		this.streetAddress = "via mazzini";
	}
	
	public Customer(Account account, String name, String surname, String email, Date birth, String type, List<Acquire> acquires){
		super(account, name, surname, email, birth, type);
		this.pIva_cf = "lgrvcn89t02d005r";
		this.streetAddress = "via cosenza";
		this.acquires = acquires;
		
	}

	public String getpIva_cf() {
		return pIva_cf;
	}

	public void setpIva_cf(String pIva_cf) {
		this.pIva_cf = pIva_cf;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public List<Acquire> getAcquires() {
		return acquires;
	}

	public void setAcquires(List<Acquire> acquires) {
		this.acquires = acquires;
	}

}
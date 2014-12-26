package it.unical.ilbellodelledonne.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Customer")
@PrimaryKeyJoinColumn(name="username")
public class Customer extends User {

	private static final long serialVersionUID = 1L;

	@Column(name = "pIva_cf")
	private String pIva_cf;

	public Customer() {
		super();
		this.pIva_cf = "lgrvcn89t02d005r";
	}
	
	public Customer(String username, String password, String pIva_cf){
		super(username, password);
		this.pIva_cf = pIva_cf;
		
	}

	public String getpIva_cf() {
		return pIva_cf;
	}

	public void setpIva_cf(String pIva_cf) {
		this.pIva_cf = pIva_cf;
	}	

}

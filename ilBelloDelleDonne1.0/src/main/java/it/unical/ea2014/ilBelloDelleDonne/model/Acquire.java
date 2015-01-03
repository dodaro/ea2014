package it.unical.ea2014.ilBelloDelleDonne.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Acquire")
public class Acquire {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idAcquire")
	private int idAcquire;
	
	@ManyToOne
	@JoinColumn(name="customer")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name="product")
	private Product product;
	
	@Temporal(TemporalType.DATE)
    @Column(name = "date", nullable = false)
    private Date date;
    	
	
	public Acquire(){
		
	}
	
	public Acquire(Customer customer, Product product, Date date){
		this.customer = customer;
		this.product = product;
		this.date = date;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}

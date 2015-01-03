package it.unical.ea2014.ilBelloDelleDonne.model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="Warehouse")
public class Warehouse {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idWarehouse")
	private int idWarehouse;
	
	@OneToMany(mappedBy="warehouse", fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
	private ArrayList<Product> products;
	
	public Warehouse(){
		products = new ArrayList<Product>();
	}
	
	public Warehouse(int idWarehouse, ArrayList<Product> products){
		this.idWarehouse = idWarehouse;
		this.products = products;
	}

	public int getIdWarehouse() {
		return idWarehouse;
	}

	public void setIdWarehouse(int idWarehouse) {
		this.idWarehouse = idWarehouse;
	}

	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}

}


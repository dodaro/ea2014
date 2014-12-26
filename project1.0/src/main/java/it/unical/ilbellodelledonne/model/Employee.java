package it.unical.ilbellodelledonne.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Employee")
@PrimaryKeyJoinColumn(name="username")
public class Employee extends User{

	private static final long serialVersionUID = 1L;
	
	public Employee() {
		super();

	}
	
	public Employee(String username, String password){
		super(username, password);
		
	}

}

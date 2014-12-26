package it.unical.ilbellodelledonne.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Employer")
@PrimaryKeyJoinColumn(name="username")
public class Employer extends User{

	private static final long serialVersionUID = 1L;
	
	public Employer(){
		super();
	}
	
	public Employer(String username, String password){
		super(username, password);
	}

}

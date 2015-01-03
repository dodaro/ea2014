package it.unical.ea2014.ilBelloDelleDonne.model;

import java.util.Date;

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
	
	public Employer(Account account, String name, String surname, String email, Date birth, String type){
		super(account, name, surname, email, birth, type);
	}

}


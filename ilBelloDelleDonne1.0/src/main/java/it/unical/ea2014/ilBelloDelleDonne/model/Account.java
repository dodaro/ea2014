package it.unical.ea2014.ilBelloDelleDonne.model;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class Account {
	
	@OneToOne
	@JoinColumn(name="user")
	private User user;
	
	private String username;
	private String password;
	
	public Account(){
		username = "";
		password = "";
	}
	
	public Account(String username, String password){
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}


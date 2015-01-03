package it.unical.ea2014.ilBelloDelleDonne.dao;

import it.unical.ea2014.ilBelloDelleDonne.model.User;


public interface UserDao {

	void create(User u);
	User retrieve(String username);
	void update(User u);
	void delete(User u);
}

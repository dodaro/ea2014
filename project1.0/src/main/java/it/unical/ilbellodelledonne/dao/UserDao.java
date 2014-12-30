package it.unical.ilbellodelledonne.dao;

import it.unical.ilbellodelledonne.model.User;


public interface UserDao {
	void create(User u);
	User retrieve(String username);
	void update(User u);
	void delete(User u);

}

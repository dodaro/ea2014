package it.unical.ilbellodelledonne.dao;

import it.unical.ilbellodelledonne.model.User;

public interface UserDao {
	
	public void createUser(User user);
	User retrieve(String username);
	void update(User user);
	void delete(User user);

}

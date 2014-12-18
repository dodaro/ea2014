package com.unical.application.dao;

import com.unical.application.model.User;

public interface UserDao {
	void create(User u);
	User retrieve(String username);
	void update(User u);
	void delete(User u);	
}

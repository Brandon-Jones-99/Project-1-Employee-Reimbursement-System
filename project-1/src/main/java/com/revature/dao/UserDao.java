package com.revature.dao;

import java.util.List;

import com.revature.beans.User;

public interface UserDao {

	
	public User getUser(Integer userId);
	
	
	public User getUser(String username, String pass);
	
	
	public User getUser(String firstname, String lastname, Integer userId);
	
	
	public List<User> getAllUsers();
	
	
	public User updateUser(User u);
	

	
	
	//add getAllEmployees?
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

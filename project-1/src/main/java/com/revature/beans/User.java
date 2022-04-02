package com.revature.beans;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {
	
	private static final long serialVersionUID = -662794077232408083L;

	//a User object
	public static enum UserType {
		EMPLOYEE, FINANCEMANAGER
	}
	
	private int userId;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private UserType userType;
	
	
	
	//constructors
	public User(int userId, String username, String password, String firstName, String lastName, String email, UserType userType,
			List<Reimbursement> reimbursements) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userType = userType;
			
	}
	
	public User(String username, String password, String firstName, String lastName, String email, UserType userType) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userType = userType;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public User() {
		super();
	}
	
	//getters and setters
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
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public UserType getUserType() {
		return userType;
	}
	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + ", email=" + email + ", userType=" + userType
				+ "]";
	}

	


	
	
	
	
	
	
	
	
}

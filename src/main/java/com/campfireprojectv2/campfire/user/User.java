package com.campfireprojectv2.campfire.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue
	private Integer id;
	private String username;
	private String password;
	private String usertype;
	private String email;
	private boolean loggedIn;
	
	public User() {
		
	}
	
	public User(String username, String usertype, boolean loggedIn) {
		this.username=username;
		this.usertype=usertype;
		this.loggedIn=loggedIn;
	}

	public User(Integer id, String username, String password, String usertype, String email, boolean loggedIn) {

		this.id = id;
		this.username = username;
		this.password = password;
		this.usertype = usertype;
		this.email = email;
		this.loggedIn = loggedIn;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", "
				+ "usertype=" + usertype + ", email=" + email +", loggedIn="
				+ loggedIn + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	
}

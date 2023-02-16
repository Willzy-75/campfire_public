package com.campfireprojectv2.campfire.user;

public class User {

	private String username;
	private String password;
	private String usertype;
	private boolean loggedIn;
	
	public User() {
		
	}

	public User(String username, String password, String usertype, boolean loggedIn) {
		super();
		this.username = username;
		this.password = password;
		this.usertype = usertype;
		this.loggedIn = loggedIn;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", usertype=" + usertype + ", loggedIn="
				+ loggedIn + "]";
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

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	
	
	
	
	
	
}

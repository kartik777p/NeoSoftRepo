package com.neosoft.beans;

public class AdminLogin {
	private String userName;
	private String Password;

	// cons
	public AdminLogin() {

	}

	// getter setter
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public boolean adminAuthontication(String email, String password2) {
		return false;
	}
}//class

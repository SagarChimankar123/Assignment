package com.infy.dao;

import jakarta.validation.constraints.Size;

public class Login {
	private String custEmail;
	private String custPassword;
	
	
	public String getCustEmail() {
		return custEmail;
	}
	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}
	public String getCustPassword() {
		return custPassword;
	}
	public void setCustPassword(String custPassword) {
		this.custPassword = custPassword;
	}
	public Login(String custEmail, String custPassword) {
		super();
		this.custEmail = custEmail;
		this.custPassword = custPassword;
	}
	@Override
	public String toString() {
		return "Login [custEmail=" + custEmail + ", custPassword=" + custPassword + "]";
	}
	
	
}

package com.oa.couponsWebApp;

import java.util.Date;

import javax.persistence.*;

@Entity
public class User {
	
	
	private String userName;
	private String password;
	Date dateOfRegistration;
	
	//Default Ctor
	public User(){
	}

	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
		this.dateOfRegistration = new Date();
	}




	//***Func**********************
	@Id
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getDateOfRegistration() {
		return dateOfRegistration;
	}
	public void setDateOfRegistration(Date dateOfRegistration) {
		this.dateOfRegistration = dateOfRegistration;
	}
	
	
	@Override
	public String toString() {
		return "Coupon [userName=" + userName + ", password=" + password + ", dateOfRegistration="
				+ dateOfRegistration + "]";
	}
}

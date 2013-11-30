package com.oa.couponsWebApp;

import java.util.Date;

import javax.persistence.*;

@Entity
public class User {

	private String userName;
	private String password;
	private int privilige;		//1=Admin, 0=Regular user
	Date dateOfRegistration;
	

	public User(String userName, String password, int privilige) {
		super();
		this.userName = userName;
		this.password = password;
		this.privilige=privilige; //1=Admin, 0=Regular user
		this.dateOfRegistration = new Date();
	}

	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
		this.privilige=0;  //1=Admin, 0=Regular user
		this.dateOfRegistration = new Date();
	}


	public User() {
		// TODO Auto-generated constructor stub
	}

	
	@Id
	public String getUsername() {
		return userName;
	}
	public void setUsername(String userName) {
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

	public int getPrivilige() {
		return privilige;
	}

	public void setPrivilige(int privilige) {
		this.privilige = privilige;
	}
}

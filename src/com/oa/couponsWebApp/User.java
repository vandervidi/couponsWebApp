package com.oa.couponsWebApp;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import javax.persistence.*;
/**
 * User class
 * @author Vidran & Ofir
 *
 */
@Entity
public class User {

	private String userName;
	private String password;
	private int privilige;		//1=Admin, 0=Regular user
	Date dateOfRegistration;
	
	/**
	 * User class constructor
	 * 
	 * @param userName		User's Username.
	 * @param password		User's password.
	 * @param privilige		User's Privilege.
	 */
	public User(String userName, String password, int privilige) {
		super();
		this.userName = userName;
		this.password = password;
		this.privilige=privilige; //1=Admin, 0=Regular user
		this.dateOfRegistration = new Date();
	}
	/**
	 * User class constructor
	 * 
	 * @param userName		User's Username.
	 * @param password		User's password.
	 */
	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
		this.privilige=0;  //1=Admin, 0=Regular user
		this.dateOfRegistration = new Date();
	}
	/**
	 * User default constructor
	 */
	public User() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @return
	 */
	@Id
	public String getUsername() {
		return userName;
	}
	/**
	 * 
	 * @param userName
	 */
	public void setUsername(String userName) {
		this.userName = userName;
	}
	/**
	 * 
	 * @return
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 
	 * @return
	 */
	public int getPrivilige() {
		return privilige;
	}
	/**
	 * 
	 * @param privilige
	 */
	public void setPrivilige(int privilige) {
		this.privilige = privilige;
	}
	/**
	 * 
	 * @return
	 */
	public Date getDateOfRegistration() {
		return dateOfRegistration;
	}
	/**
	 * 
	 * @param dateOfRegistration
	 */
	public void setDateOfRegistration(Date dateOfRegistration) {
		this.dateOfRegistration = dateOfRegistration;
	}
	
	
	@Override
	public String toString() {
		return "Coupon [userName=" + userName + ", password=" + password + ", dateOfRegistration="
				+ dateOfRegistration + ", privilige=" + privilige + "]";
	}

	
}

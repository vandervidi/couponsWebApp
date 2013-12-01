package com.oa.couponsWebApp;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
		this.setPassword(password);
		this.privilige=privilige; //1=Admin, 0=Regular user
		this.dateOfRegistration = new Date();
	}

	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.setPassword(password);
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
		String encryptedPass = MD5(password);
		if (encryptedPass!= null){
			this.password = encryptedPass;
		}
	}
	
	// Using MD5
	public String MD5(String input) {
		String md5 = null;
		
        if( input == null) return null;
        
        try {
	        //Create MessageDigest object for MD5
	        MessageDigest digest = MessageDigest.getInstance("MD5");
	         
	        //Update input string in message digest
	        digest.update(input.getBytes(), 0, input.length());
	 
	        //Converts message digest value in base 16 (hex) 
	        md5 = new BigInteger(1, digest.digest()).toString(16);
 
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return md5;
	}
	
	public int getPrivilige() {
		return privilige;
	}

	public void setPrivilige(int privilige) {
		this.privilige = privilige;
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
				+ dateOfRegistration + ", privilige=" + privilige + "]";
	}

	
}

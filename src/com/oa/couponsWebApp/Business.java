package com.oa.couponsWebApp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Business {
	public int businessId;
	private String businessName;
	private double length;
	private double width;
	
	
	// Constractors
	
	public Business(int businessId, String businessName, double length, double width) {
		super();
		this.businessId = businessId;
		this.businessName = businessName;
		this.length = length;
		this.width = width;
	}
	
	public Business(String businessName, double length, double width) {
		super();
		this.businessName = businessName;
		this.length = length;
		this.width = width;
	}
	
	public Business() {
		super();
	}

	
	

// getters & setters functions

	@Id 
	@GeneratedValue
	public int getBusinessId() {
		return businessId;
	}
	public void setBusinessId(int businessId) {
		this.businessId = businessId;
	}
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	@Override
	public String toString() {
		return "Business [businessId=" + businessId + ", businessName="
				+ businessName + "]";
	}


	public double getLength() {
		return length;
	}


	public void setLength(double length) {
		this.length = length;
	}


	public double getWidth() {
		return width;
	}


	public void setWidth(double width) {
		this.width = width;
	}	
}

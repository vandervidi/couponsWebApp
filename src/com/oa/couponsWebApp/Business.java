package com.oa.couponsWebApp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Business {
	
	
	public int businessId;
	private String businessName;
	
	
	// Constractors
	public Business() {
	}
	public Business(String businessName) {
		super();
		this.businessName = businessName;
	}
	public Business(int businessId, String businessName) {
		super();
		this.businessId = businessId;
		this.businessName = businessName;
	}

	// getters & setters func
	@Id @GeneratedValue
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
	
	
}

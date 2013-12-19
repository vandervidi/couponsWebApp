package com.oa.couponsWebApp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
/**
 * Busniess class
 * @author Vidran & Ofir
 *
 */
@Entity
public class Business {
	public int businessId;
	private String businessName;
	private double length;
	private double width;
	
	
	// Constractors
	/**
	 * Business constructor
	 * @param businessId			Business's ID number.		
	 * @param businessName			Business's name.
	 * @param length				Business's location length.
	 * @param width					Business's location width.
	 */
	public Business(int businessId, String businessName, double length, double width) {
		super();
		this.businessId = businessId;
		this.businessName = businessName;
		this.length = length;
		this.width = width;
	}
	/**
	 * Business constructor
	 * @param businessName			Business's name.
	 * @param length				Business's location length.
	 * @param width					Business's location width.
	 */
	public Business(String businessName, double length, double width) {
		super();
		this.businessName = businessName;
		this.length = length;
		this.width = width;
	}
	/**
	 * Business default constructor
	 */
	public Business() {
		super();
	}

	/**
	 * Get method for "businessId"
	 * @return businessId
	 */
	@Id 
	@GeneratedValue
	public int getBusinessId() {
		return businessId;
	}
	/**
	 * Set method for "businessId"
	 * @param businessId
	 */
	public void setBusinessId(int businessId) {
		this.businessId = businessId;
	}
	/**
	 * Get method for "businessName"
	 * @return businessName
	 */
	public String getBusinessName() {
		return businessName;
	}
	/**
	 * Set method for "businessName"
	 * @param businessName
	 */
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	@Override
	public String toString() {
		return "Business [businessId=" + businessId + ", businessName="
				+ businessName + "]";
	}

	/**
	 * Get method for "length"
	 * @return length
	 */
	public double getLength() {
		return length;
	}

	/**
	 * Set method for "length"
	 * @param length
	 */
	public void setLength(double length) {
		this.length = length;
	}

	/**
	 * Get method for "width"
	 * @return width
	 */
	public double getWidth() {
		return width;
	}

	/**
	 * Set method for "width"
	 * @param width
	 */
	public void setWidth(double width) {
		this.width = width;
	}	
}

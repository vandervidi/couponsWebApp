package com.oa.couponsWebApp;

import java.util.Date;

import javax.persistence.*;
/**
 * This is the Coupon class
 * @author Vidran & Ofir
 *
 */
@Entity
public class Coupon {
	
	private int id;
	private int businessId;
	private String name;
	private double price;
	private String image;
	private String description;
	private String expireDate;
	private String category;
	
	/**
	 * Coupon deafault constructor.
	 */
	public Coupon(){
	}
	
	/**
	 * Coupon constructor
	 * 
	 * @param name				Coupon's name.
	 * @param businessId		Business ID that the coupon belongs to.
	 * @param image				Coupon's image file name.
	 * @param description		Coupon's descriptino.
	 * @param expireDate		Coupon's expire date.
	 * @param category			Coupon's category.
	 * @param price				Coupon's price.
	 */
	public Coupon(String name,int businessId, String image, String description, String expireDate, String category, double price) {
		super();
		this.name=name;
		this.price=price;
		this.businessId = businessId;
		this.image = image;
		this.description=description;
		this.expireDate=expireDate;
		this.category=category;
	}
	
	/**
	 * Coupon constructor
	 * 
	 * @param id				Coupon's ID number.
	 * @param name				Coupon's name.
	 * @param businessId		Business ID that the coupon belongs to.
	 * @param image				Coupon's image file name.
	 * @param description		Coupon's descriptino.
	 * @param expireDate		Coupon's expire date.
	 * @param category			Coupon's category.
	 * @param price				Coupon's price.
	 */
	public Coupon(int id,String name,int businessId, String image, String description, String expireDate, String category,double price) {
		super();
		this.name=name;
		this.id=id;
		this.businessId = businessId;
		this.image = image;
		this.description=description;
		this.expireDate=expireDate;
		this.category=category;
		this.price=price;
	}
	/**
	 * Get method for "id" 
	 * @return  Coupon ID number
	 */
	@Id @GeneratedValue
	public int getId() {
		return id;
	}
	/**
	 * Set method fot "id"
	 * @param id 	The new id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Get method for "bussinessId"
	 * @return Business ID that the coupon belongs to
	 */
	public int getBusinessId() {
		return businessId;
	}
	/**
	 * Set method for "businessId"
	 * @param BusinessId
	 */
	public void setBusinessId(int BusinessId) {
		this.businessId = BusinessId;
	}
	/**
	 * Get method fot "image"
	 * @return	image name;
	 */
	public String getImage() {
		return image;
	}
	/**
	 * Set method for "image"
	 * @param Coupon's image
	 */
	public void setImage(String image) {
		this.image = image;
	}
	/**
	 * Get method for "description"
	 * @return Coupon's description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * Set method for "description"
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * Get method for "expireDate"
	 * @return Coupon's expire date
	 */
	public String getExpireDate() {
		return expireDate;
	}
	/**
	 * Set method for "expireDate"
	 * @param expireDate
	 */
	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}
	/**
	 * Get method for "category"
	 * @return	category name
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * Set method for "category"
	 * @param category
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Coupon [id=" + id + ", businessId=" + businessId + ", name="
				+ name + ", price=" + price + ", image=" + image
				+ ", description=" + description + ", expireDate=" + expireDate
				+ ", category=" + category + "]";
	}
	/**
	 * Get method for "name"
	 * @return	Coupon's name
	 */
	public String getName() {
		return name;
	}
	/**
	 * Set method for "name"
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Get method for "price"
	 * @return	Coupon's price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * Set method for "price"
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	
	
}

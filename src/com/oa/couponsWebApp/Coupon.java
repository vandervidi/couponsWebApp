package com.oa.couponsWebApp;

import java.util.Date;

import javax.persistence.*;

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
	
	//Default Ctor
	public Coupon(){
	}
	
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
	@Id @GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBusinessId() {
		return businessId;
	}
	public void setBusinessId(int BusinessId) {
		this.businessId = BusinessId;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}

	public String getCategory() {
		return category;
	}

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	
	
}

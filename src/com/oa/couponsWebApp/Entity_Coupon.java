package com.oa.couponsWebApp;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Entity_Coupon {
	
	private int couponId;
	private int businessId;
	private String image;
	private String description;
	private String expireDate;
	
	//Default Ctor
	public Entity_Coupon(){
	}
	
	public Entity_Coupon(int businessId, String image, String description, String expireDate) {
		super();
		this.businessId = businessId;
		this.image = image;
		this.description=description;
		this.setExpireDate(expireDate);
	}
	
	//***Func**********************
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Id @GeneratedValue
	public int getCouponId() {
		return couponId;
	}
	public void setCouponId(int couponId) {
		this.couponId = couponId;
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
	
	
	@Override
	public String toString() {
		return "Coupon [couponId=" + couponId + ", businessId=" + businessId + ", image="
				+ image + ", description=" + description + ", expireDate="
				+ expireDate + "]";
	}
}

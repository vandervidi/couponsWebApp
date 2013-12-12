package com.oa.couponsWebApp;



public class ShoppingCartRow {
	private Coupon coupon;
	private int quantity;
	public ShoppingCartRow(Coupon coupon, int quantity) {
		super();
		this.coupon = coupon;
		this.quantity = quantity;
	}
	public Coupon getCoupon() {
		return coupon;
	}
	public void setCoupon(Coupon coupon) {
		this.coupon = coupon;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
}

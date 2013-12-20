package com.oa.couponsWebApp;



import java.util.Collection;

public interface IShoppingCart {
	public void addCoupon(Coupon coupon) throws CouponsPlatformException;
	public Collection<ShoppingCartRow> getShoppingCartRows() throws CouponsPlatformException;
}

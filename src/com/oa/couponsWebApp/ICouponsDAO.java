package com.oa.couponsWebApp;


import java.util.Iterator;

public interface ICouponsDAO {
	
	public abstract boolean updateCoupon(Entity_Coupon ob);
	public abstract boolean deleteCoupon(int id);
	public abstract Entity_Coupon getCoupon(int id);
    public abstract boolean addCoupon(Entity_Coupon ob);
    public abstract Iterator<Entity_Coupon> getAllCoupons();
}

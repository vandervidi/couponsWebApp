package com.oa.couponsWebApp;


import java.util.Iterator;

public interface ICouponsDAO {
   public abstract Coupon getCoupon(int id);
   public abstract boolean updateCoupon(Coupon ob);
   public abstract Iterator<Coupon> getAllCoupons();
   public abstract boolean deleteCoupon(int id);
   public abstract boolean addCoupon(Coupon ob);
}

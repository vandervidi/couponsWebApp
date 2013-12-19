package com.oa.couponsWebApp;
import java.util.Collection;
/**
 * 
 * @author Vidran & Ofir
 *
 */
public interface IShoppingCart {
	/**
	 * Adds a coupon to the shopping cart.
	 * @param coupon	The coupon we want to add to the cart.
	 * @throws CouponsPlatformException
	 */
	public void addCoupon(Coupon coupon) throws CouponsPlatformException;
	/**
	 * 
	 * @return
	 * @throws CouponsPlatformException
	 */
	public Collection<ShoppingCartRow> getShoppingCartRows() throws CouponsPlatformException;
}

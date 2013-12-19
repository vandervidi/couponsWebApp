package com.oa.couponsWebApp;
import java.util.Iterator;
/**
 * 
 * @author Vidran & Ofir
 *
 */
public interface ICouponsDAO {
	/**
	 * This method returns a Coupon Object from a database.
	 * @param id	The coupon id to retrieve from database.
	 * @return		Coupon object.
	 */
   public abstract Coupon getCoupon(int id);
   /**
    * This method updates a desired coupon in database.
    * @param ob		The object that is to be updated.
    * @return		True if updated sucessfully.Otherwise false.
    */
   public abstract boolean updateCoupon(Coupon ob);
   /**
    * Return an iterator of all coupons from a database.
    * @return	Iterator of Coupons.
    */
   public abstract Iterator<Coupon> getAllCoupons();
   /**
    * This method deletes a coupon by ID.
    * @param id		The coupon id to be deleted.
    * @return		True if deleted successfully.Otherwise false.
    */
   public abstract boolean deleteCoupon(int id);
   /**
    * This method adds a coupon to the database.
    * @param ob		Coupon object which we want to add.
    * @return		True if added sucessfully.Otherwise False.
    */
   public abstract boolean addCoupon(Coupon ob);
}

package com.oa.couponsWebApp;


import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class CouponMain {	
	public static void main(String [] args){

		DAO userInstance = DAO.getInstance();
		System.out.println("UserDAO_ClassInstance="+userInstance);
		User u1 = new User("Ofir", "1234",1);
		User u2 = new User("Vidran", "abcd",0);
		User u3 = new User("Vidran", "2222",0);
		
		userInstance.addUser(u1);
		userInstance.addUser(u2);
		userInstance.addUser(u3);	// duplicate userName "Vidran"- so, not save this
							
		//---------------

		Business b1 = new Business("aaaa");
		Business b2 = new Business("ssss");
		Business b3 = new Business("dddd");
		Business b4 = new Business("ffff");
		Business b5 = new Business("gggg");
		
		DAO businessInstance = DAO.getInstance();
		System.out.println("BusinessDAO_ClassInstance="+businessInstance);
		businessInstance.addBusiness(b1);
		businessInstance.addBusiness(b2);
		businessInstance.addBusiness(b3);
		businessInstance.addBusiness(b4);
		
		//---------------
		
		Coupon c1 = new Coupon(b1.getBusinessId(), "22", "bla bla","1.1.2000");
		Coupon c2 = new Coupon(b1.getBusinessId(), "444", "bla bla","12.1.2000");
		Coupon c3 = new Coupon(b3.getBusinessId(), "11", "bla bla","1.12.2000");
		Coupon c4 = new Coupon(b4.getBusinessId(), "22", "bla bla","15.1.2000");
		Coupon c5 = new Coupon(b5.getBusinessId(), "33", "bla bla","1.10.2000");
		
		// Create Instance of CouponDAO
		DAO CouponInstance = DAO.getInstance();
			System.out.println("CouponDAO_ClassInstance"+CouponInstance);
		System.out.println("---------------\n");
		
		
		
		
		CouponInstance.addCoupon(c1);	
		CouponInstance.addCoupon(c2);
		CouponInstance.addCoupon(c3);
		CouponInstance.addCoupon(c4);	
		CouponInstance.addCoupon(c5);
		
		System.out.println( CouponInstance.getCoupon(11)  );
		
		Iterator iterator = CouponInstance.getAllCoupons();
		while(iterator.hasNext()) 
		{
			System.out.println(iterator.next());
		}
		System.out.println("---------------\n");
		
		CouponInstance.deleteCoupon(100);
		System.out.println("---------------\n");
		
		//System.out.println( CouponInstance.updateCoupon(c2) );
						//System.out.println(c);
						
		CouponInstance.updateCoupon(c2);
		
		
		//CouponInstance.closeConnection();
	}
}

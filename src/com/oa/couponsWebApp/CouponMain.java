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

		
		Coupon c1 = new Coupon(11, "22", "bla bla","1.1.2000");
		Coupon c2 = new Coupon(11, "444", "bla bla","12.1.2000");
		Coupon c3 = new Coupon(100, "11", "bla bla","1.12.2000");
		Coupon c4 = new Coupon(200, "22", "bla bla","15.1.2000");
		Coupon c5 = new Coupon(300, "33", "bla bla","1.10.2000");
		//*******************************************
	
		// Create db Singleton
		//CouponDAO db = null;
		//db.getInstance();
		// Shotcut
		CouponDAO dbInstance = CouponDAO.getInstance();
		
		System.out.println(dbInstance);
		System.out.println("---------------\n");
		//dbInstance.connectToServer();
		
		
		
		dbInstance.addCoupon(c1);	
		dbInstance.addCoupon(c2);
		dbInstance.addCoupon(c3);
		dbInstance.addCoupon(c4);	
		dbInstance.addCoupon(c5);
		
		System.out.println( dbInstance.getCoupon(11)  );
		
		Iterator iterator = dbInstance.getAllCoupons();
		while(iterator.hasNext()) 
		{
			System.out.println(iterator.next());
		}
		System.out.println("---------------\n");
		
		dbInstance.deleteCoupon(100);
		System.out.println("---------------\n");
		
		//System.out.println( dbInstance.updateCoupon(c2) );
						//System.out.println(c);
						
		dbInstance.updateCoupon(c2);
		
		
		//dbInstance.closeConnection();
	}
}

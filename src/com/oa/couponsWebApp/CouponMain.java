package com.oa.couponsWebApp;


import java.awt.Image;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
		
		DAO db = DAO.getInstance();
		
		
		
		System.out.println("UserDAO_ClassInstance="+db);
		
		db.addUser(new User("ofir",	MD5.encryptMD5("1") ,1));
		db.addUser(new User("ofir", 	MD5.encryptMD5("1") ,1));
		db.addUser(new User("ofir", 	MD5.encryptMD5("1") ,1));
		db.addUser(new User("ofir", 	MD5.encryptMD5("1") ,1));
		db.addUser(new User("ofir",   MD5.encryptMD5("1") ,1));
		db.addUser(new User("vidran", MD5.encryptMD5("a") ,0));
		db.addUser(new User("vidran", MD5.encryptMD5("2222") ,0));
		
			//System.out.println( userInstance.getUser("ofir").MD5("c4ca4238a0b923820dcc509a6f75849b") );				
		//---------------
		
		DAO businessInstance = DAO.getInstance();
		System.out.println("BusinessDAO_ClassInstance="+businessInstance);
		db.addBusiness(new Business("aaaa") );
		db.addBusiness(new Business("ssss") );
		db.addBusiness(new Business("dddd") );
		db.addBusiness(new Business("gggg") );
		
		//---------------
		
		Coupon c1 = new Coupon(b1.getBusinessId(), "vidi.jpg", "bla bla","1.1.2000");
		Coupon c2 = new Coupon(b1.getBusinessId(), "vidi.jpg", "bla bla","12.1.2000");
		Coupon c3 = new Coupon(b3.getBusinessId(), "vidi.jpg", "bla bla","1.12.2000");
		Coupon c4 = new Coupon(b4.getBusinessId(), "vidi.jpg", "bla bla","15.1.2000");
		Coupon c5 = new Coupon(b5.getBusinessId(), "vidi.jpg", "bla bla","1.10.2000");
		
		// Create Instance of CouponDAO
		DAO CouponInstance = DAO.getInstance();
			System.out.println("CouponDAO_ClassInstance"+CouponInstance);
		System.out.println("---------------\n");
		
		
		
		
		CouponInstance.addCoupon(new Coupon(b1.getBusinessId(), "22", "bla bla","1.1.2000");	
		CouponInstance.addCoupon(new Coupon(b1.getBusinessId(), "444", "bla bla","12.1.2000");
		CouponInstance.addCoupon(new Coupon(b3.getBusinessId(), "11", "bla bla","1.12.2000");
		CouponInstance.addCoupon(new Coupon(b4.getBusinessId(), "22", "bla bla","15.1.2000");	
		CouponInstance.addCoupon(new Coupon(b5.getBusinessId(), "33", "bla bla","1.10.2000");
		
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

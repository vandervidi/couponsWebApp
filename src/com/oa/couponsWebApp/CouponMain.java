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
		
		// Create Instance of DAO called "db"
		DAO_Implements_Entities db = DAO_Implements_Entities.getInstance();
		
		//------Check User-----------
		db.addUser(new Entity_User("Ofir", "123"));
		db.addUser(new Entity_User("Vidran", "222"));
		System.out.println( db.getUser("Ofir") );
							
		//------Check Business---------
		db.addBusiness( new Entity_Business(124,"aaaa") );
		db.addBusiness( new Entity_Business(23, "ssss")   );
		db.addBusiness( new Entity_Business(92, "dddd")   );
		db.addBusiness( new Entity_Business(93, "ffff")   );
		db.addBusiness( new Entity_Business(94, "gggg")   );

		db.getAllBusinesses();
		System.out.println( db.getBusiness(92));
		db.deleteBusiness(93);
		
		//------Check Coupon---------/
		db.addCoupon( new Entity_Coupon(db.getBusiness(23).getBusinessId(), "22", "bla bla","1.1.2000") );
		db.addCoupon( new Entity_Coupon(db.getBusiness(23).getBusinessId(), "444", "bla bla","12.1.2000" ));
		db.addCoupon( new Entity_Coupon(db.getBusiness(23).getBusinessId(), "11", "bla bla","1.12.2000"));
		db.addCoupon( new Entity_Coupon(db.getBusiness(23).getBusinessId(), "22", "bla bla","15.1.2000"));
		db.addCoupon( new Entity_Coupon(db.getBusiness(23).getBusinessId(), "33", "bla bla","1.10.2000"));
		
		
		System.out.println("---------------\n");
	
		System.out.println( db.getCoupon(11)  );
		
		Iterator iterator = db.getAllCoupons();
		while(iterator.hasNext()) 
		{
			System.out.println(iterator.next());
		}
		System.out.println("---------------\n");
		
		db.deleteCoupon(100);
		System.out.println("---------------\n");
	}
}

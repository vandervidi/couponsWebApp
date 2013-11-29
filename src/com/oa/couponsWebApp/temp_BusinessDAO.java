package com.oa.couponsWebApp;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;

public class temp_BusinessDAO {
	public static SessionFactory sessionFactory = null;
	private Session session = null;
	String cr = "\n----------------";
	
	//**Singleton***************************************************************
	private static temp_BusinessDAO instance;

	
	// Private constructor prevents instantiation from other classes
	  private temp_BusinessDAO() {
		  sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		  //sessionFactory = new Configuration().configure().buildSessionFactory();
	  }

	  public static temp_BusinessDAO getInstance() {
		  if (instance==null)
			  instance=new temp_BusinessDAO();
		  return instance;
	  }

	// Not Working
	public boolean updateBusiness(Entity_Business ob) {
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			//-------------
			session.update(ob);
			//-------------
			session.getTransaction().commit();
			session.close();
									System.out.println("update business "+ob.getBusinessId()+" completed."+cr);
		} catch (Exception e) {
									System.out.println("error: update business "+ob.getBusinessId()+cr);
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean deleteBusiness(int id) {
		Entity_Coupon couponToDel = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			//-------------
			couponToDel = new Entity_Coupon();
			couponToDel.setId(id);
			
			System.out.println(couponToDel);
            session.delete(couponToDel);
			//-------------
			session.getTransaction().commit();
			session.close();
								System.out.println("deleting business "+id+" completed.");
		} catch (HibernateException e) {
        						System.out.println("error: deleting business: "+id);
            return false;
        }
		return true;
	}


	public Entity_Coupon getBusiness(int id) {
		Entity_Coupon coupon = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			//-------------
			coupon =  (Entity_Coupon) session.get(Entity_Coupon.class, id);
			//-------------
			session.getTransaction().commit();
			session.close();
									System.out.println("get business completed."+cr);
		} catch (Exception e) {
									System.out.println("error: get business."+cr);
			e.printStackTrace();
			return null;
		}
		return coupon;
	}
	

	public boolean addBusiness(Entity_Business ob) {

		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			//----------------------
			System.out.println(ob);
			session.save(ob);
			//----------------------
			session.getTransaction().commit();
			session.close();
								System.out.println("add business "+ob.getBusinessId()+" "+ob.getBusinessName()+" comleted."+cr);
		} catch (Exception e) {
								System.out.println("error: add business."+cr);
			return false;
		}
		return true;
	}
	
	public Iterator<Entity_Business> getAllBusinesses() {
		Iterator iterator = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			//-------------
			List coupons = session.createCriteria(Entity_Coupon.class).list();
			System.out.println("There are " + coupons.size() + " business(es):");
			iterator = coupons.iterator();
//			while(iterator.hasNext()) 
//			{
//				System.out.println(iterator.next());
//			}
//			//-------------
			session.getTransaction().commit();
			session.close();
			System.out.println("getting all business completed."+cr);
		} catch (HibernateException e) {
        		System.out.println("error: deleting business"+cr);
			return null;
        }
		return iterator;
	}
}

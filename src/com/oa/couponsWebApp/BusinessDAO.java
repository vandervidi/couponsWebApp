package com.oa.couponsWebApp;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;

public class BusinessDAO {
	public static SessionFactory sessionFactory = null;
	private Session session = null;
	String cr = "\n----------------";
	
	//**Singleton**
	private static BusinessDAO instance;

	
	// Private constructor prevents instantiation from other classes
	  private BusinessDAO() {
		  sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		  
	  }

	  public static BusinessDAO getInstance() {
		  if (instance==null)
			  instance=new BusinessDAO();
		  return instance;
	  }

	// Not Working
	public boolean updateBusiness(Business ob) {
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
		Business businessToDelete  = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();

			businessToDelete = new Business();
			businessToDelete.setBusinessId(id);
			
			System.out.println(businessToDelete);
            session.delete(businessToDelete );

			session.getTransaction().commit();
			session.close();
			System.out.println("deleting business "+id+" completed.");
		} catch (HibernateException e) {
        	System.out.println("error: deleting business: "+id);
            return false;
        }
		return true;
	}


	public Business getBusiness(int id) {
		Business business = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			//-------------
			business =  (Business) session.get(Business.class, id);
			//-------------
			session.getTransaction().commit();
			session.close();
			System.out.println("get business completed."+cr);
		} catch (Exception e) {
			System.out.println("error: get business."+cr);
			e.printStackTrace();
			return null;
		}
		return business;
	}
	

	public boolean addBusiness(Business ob) {

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
	
	public Iterator<Business> getAllBusinesses() {
		Iterator iterator = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			List businesses = session.createCriteria(Business.class).list();
			System.out.println("There are: " + businesses.size() + " business(es):");
			iterator = businesses.iterator();
			session.getTransaction().commit();
			session.close();
			System.out.println("getting all businesses completed."+cr);
		} catch (HibernateException e) {
        		System.out.println("error: failes to make businesses iterator"+cr);
			return null;
        }
		return iterator;
	}
}

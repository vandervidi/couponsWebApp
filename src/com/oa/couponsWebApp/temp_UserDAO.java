package com.oa.couponsWebApp;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;

public class temp_UserDAO {
	public static SessionFactory sessionFactory = null;
	private Session session = null;
	String cr = "\n----------------";
	
	//**Singleton***************************************************************
	private static temp_UserDAO instance;

	
	// Private constructor prevents instantiation from other classes
	  private temp_UserDAO() {
		  sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		  //sessionFactory = new Configuration().configure().buildSessionFactory();
	  }

	  public static temp_UserDAO getInstance() {
		  if (instance==null)
			  instance=new temp_UserDAO();
		  return instance;
	  }

	// Not Working
	public boolean updateUser(Entity_User ob) {
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			//-------------
			session.update(ob);
			//-------------
			session.getTransaction().commit();
			session.close();
									System.out.println("update User "+ob.getUserName()+" completed."+cr);
		} catch (Exception e) {
									System.out.println("error: update User "+ob.getUserName()+cr);
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean deleteUser(int id) {
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
								System.out.println("deleting User "+id+" completed.");
		} catch (HibernateException e) {
        						System.out.println("error: deleting User: "+id);
            return false;
        }
		return true;
	}


	public Entity_Coupon getUser(int id) {
		Entity_Coupon coupon = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			//-------------
			coupon =  (Entity_Coupon) session.get(Entity_Coupon.class, id);
			//-------------
			session.getTransaction().commit();
			session.close();
									System.out.println("get User completed."+cr);
		} catch (Exception e) {
									System.out.println("error: get User."+cr);
			e.printStackTrace();
			return null;
		}
		return coupon;
	}
	

	public boolean addUser(Entity_User ob) {

		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			//----------------------
			System.out.println(ob);
			session.save(ob);
			//----------------------
			session.getTransaction().commit();
			session.close();
								System.out.println("add User "+ob.getUserName()+" "+ob.getPassword()+" comleted."+cr);
		} catch (Exception e) {
								System.out.println("error: add User."+cr);
			return false;
		}
		return true;
	}
	
	public Iterator<Entity_User> getAllUsers() {
		Iterator iterator = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			//-------------
			List coupons = session.createCriteria(Entity_Coupon.class).list();
			System.out.println("There are " + coupons.size() + " User(s):");
			iterator = coupons.iterator();
//			while(iterator.hasNext()) 
//			{
//				System.out.println(iterator.next());
//			}
//			//-------------
			session.getTransaction().commit();
			session.close();
			System.out.println("getting all User completed."+cr);
		} catch (HibernateException e) {
        		System.out.println("error: deleting User"+cr);
			return null;
        }
		return iterator;
	}
}

package com.oa.couponsWebApp;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;

public class DAO implements ICouponsDAO ,IBusinessDAO ,IUsersDAO
{
	private static SessionFactory sessionFactory = null;
	private static DAO instance;
	
	private Session session = null;
	static String  cr = "\n----------------";
	static String  HTMLcr = "<br/>\n";
	
// Private constructor prevents instantiation from other classes
	  private DAO() {
		  sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
	  }

	  public static DAO getInstance() {
		  if (instance==null)
			  instance=new DAO();
		  return instance;
	  }
	  
	@Override
	public Coupon getCoupon(int id) {
		Coupon coupon = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			//-------------
			coupon =  (Coupon) session.get(Coupon.class, id);
			//-------------
			session.getTransaction().commit();
			session.close();
									System.out.println("get coupon completed."+cr);
		} catch (Exception e) {
									System.out.println("error: get coupon."+cr);
			e.printStackTrace();
			return null;
		}
		return coupon;
	}

	@Override
	public boolean updateCoupon(Coupon ob) {
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			//-------------
			session.update(ob);
			//-------------
			session.getTransaction().commit();
			session.close();
			System.out.println("update coupon "+ob.getId()+" completed."+cr);
		} catch (Exception e) {
			System.out.println("error: update coupon "+ob.getId()+cr);
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Iterator<Coupon> getAllCoupons() {
		Iterator iterator = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			List coupons = session.createCriteria(Coupon.class).list();
			System.out.println("There are " + coupons.size() + " coupon(s):");
			iterator = coupons.iterator();	
			session.getTransaction().commit();
			session.close();
			System.out.println("getting all coupons completed."+cr);
		} catch (HibernateException e) {
        		System.out.println("error: failes to make coupons iterator"+cr);
			return null;
        }
		return iterator;
	}

	public boolean deleteCoupon(int id) {
		Coupon couponToDel = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			//-------------
			couponToDel = new Coupon();
			couponToDel.setId(id);
			
			System.out.println(couponToDel);
            session.delete(couponToDel);
			//-------------
			session.getTransaction().commit();
			session.close();
			System.out.println("deleting coupon "+id+" completed.");
		} catch (HibernateException e) {
        	System.out.println("error: deleting coupon: "+id);
            return false;
        }
		return true;
	}

	@Override
	public boolean addCoupon(Coupon ob) {

		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			//----------------------
			System.out.println(ob);
			session.save(ob);
			
			//----------------------
			session.getTransaction().commit();
			session.close();
								System.out.println("add coupon "+ob.getId()+" "+ob.getBusinessId()+" "+ob.getImage()+" comleted."+cr);
		} catch (Exception e) {
								System.out.println("error: add coupon."+cr);
			return false;
		}
		return true;
	}

	@Override
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

	@Override
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

	@Override
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

	@Override
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

	@Override
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

	@Override
	public User getUser(String username) {
		User user = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			//-------------
			user =  (User) session.get(User.class, username);
			//-------------
			session.getTransaction().commit();
			session.close();
			System.out.println("get User completed."+cr);
		} catch (Exception e) {
			System.out.println("error: failed to get User."+cr);
			e.printStackTrace();
			return null;
		}
		return user;
	}

	@Override
	// Not Working
		public boolean updateUser(User ob) {
			try {
				session = sessionFactory.openSession();
				session.beginTransaction();
				//-------------
				session.update(ob);
				//-------------
				session.getTransaction().commit();
				session.close();
				System.out.println("update User "+ob.getUsername()+" completed."+cr);
			} catch (Exception e) {
				System.out.println("error: update User "+ob.getUsername()+cr);
				e.printStackTrace();
				return false;
			}
			return true;
		}


	@Override
	public Iterator<User> getAllUsers() {
		Iterator iterator = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			
			List users = session.createCriteria(User.class).list();
			System.out.println("There are " + users.size() + " User(s):");
			iterator = users.iterator();
			
			session.getTransaction().commit();
			session.close();
			System.out.println("getting all User completed."+cr);
		} catch (HibernateException e) {
        		System.out.println("error: failed to get iterator of users"+cr);
			return null;
        }
		return iterator;
	}

	@Override
	public boolean deleteUser(String username) {
		User UserToDel = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			//-------------
			UserToDel = new User();
			UserToDel.setUsername(username);
			
			System.out.println(UserToDel);
            session.delete(UserToDel);
			//-------------
			session.getTransaction().commit();
			session.close();
			System.out.println("deleting User "+username+" completed.");
		} catch (HibernateException e) {
        	System.out.println("error: deleting User: "+username);
            return false;
        }
		return true;
	}


	@Override
	public boolean addUser(User ob) {

		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			//----------------------
			System.out.println(ob);
			session.save(ob);
			//----------------------
			session.getTransaction().commit();
			session.close();
			System.out.println("add User "+ob.getUsername()+" "+ob.getPassword()+" comleted."+cr);
		} catch (Exception e) {
			System.out.println("error: add User."+cr);
			return false;
		}
		return true;
	}
	
}
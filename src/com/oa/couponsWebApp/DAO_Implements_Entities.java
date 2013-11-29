package com.oa.couponsWebApp;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;

public class DAO_Implements_Entities implements ICouponsDAO, IBusinessesDAO, IUsersDAO{
//	public static String driver = "org.apache.derby.jdbc.ClientDriver";
//  public static String protocol = "jdbc:derby://localhost:1527/ofirDB;create=true";
//  
//  public Connection connection = null;
//	public Statement statement = null;
	//public ResultSet rs = null;
	private static SessionFactory sessionFactory = null;
	private Session session = null;
	String cr = "\n----------------";
	
	//**Singleton***************************************************************
	private static DAO_Implements_Entities instance;

	
	// Private constructor prevents instantiation from other classes
	  private DAO_Implements_Entities() {
		  sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		  //sessionFactory = new Configuration().configure().buildSessionFactory();
	  }

	  public static DAO_Implements_Entities getInstance() {
		  if (instance==null)
			  instance=new DAO_Implements_Entities();
		  return instance;
	  }
	  
//	  public SessionFactory getSessionFactory() {
//		  if (sessionFactory==null){
//			  try{
//				  sessionFactory= new AnnotationConfiguration().configure().buildSessionFactory();
//				  session = sessionFactory.openSession();
//			  }catch(Exception e){
//				  System.out.println("error: getSessionFactory");}
//		  }
//		  return sessionFactory;
//	  }
	  //********************************************************
	  
//	  public void connectToServer(){
//	        try {
//		//creating factory for getting sessions
//	        //sessionFactory = getSessionFactory();
//	        System.out.println(sessionFactory);
//			//creating a new session for adding products
//			session = sessionFactory.openSession();
//			System.out.println("2");
//			session.beginTransaction();
//	            			System.out.println("*******connected to Server.*******");
//	        }
//	        catch(Exception e) {System.out.println("**error: connecting to Server.**"); e.printStackTrace(); }
//	  }
//	  public void closeConnection(){
//			  if (session != null){
//		  			session.close();
//			  }
//	            System.out.println("*******close connection.*******");
//	  }

//	  private boolean createTable(){
//		  try {
//				connectToServer();
//				statement = connection.createStatement();
//				statement.execute("CREATE TABLE inventory(id int, id_company int, icon int)");
//				System.out.println("create table.");
//				closeConnection();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				return false;
//			}
//			return true;
//	  }
//	  public boolean dropTable(){
//		  try {
//				session = sessionFactory.openSession();
//				session.beginTransaction();
//				//-------------
//				System.out.println( session.createQuery("DROP TABLE COUPONS").executeUpdate() );
//				//-------------
//				session.getTransaction().commit();
//				session.close();
//			} catch (Exception e) {
//				System.out.println("error: drop table.");
//				e.printStackTrace();
//				return false;
//			}
//			return true;
//	  }

	// Not Working
	@Override
	public boolean updateCoupon(Entity_Coupon ob) {
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			//-------------
			session.update(ob);
			//-------------
			session.getTransaction().commit();
			session.close();
									System.out.println("update coupon "+ob.getCouponId()+" completed."+cr);
		} catch (Exception e) {
									System.out.println("error: update coupon "+ob.getCouponId()+cr);
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteCoupon(int id) {
		Entity_Coupon couponToDel = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			//-------------
			couponToDel = new Entity_Coupon();
			couponToDel.setCouponId(id);
			
			System.out.println(couponToDel);
          session.delete(couponToDel);
			//-------------
			session.getTransaction().commit();
			session.close();
								System.out.println("deleting coupon: "+id+" completed.");
		} catch (HibernateException e) {
      						System.out.println("error: deleting coupon: "+id);
          return false;
      }
		return true;
	}

	@Override
	public Entity_Coupon getCoupon(int id) {
		Entity_Coupon coupon = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			//-------------
			coupon =  (Entity_Coupon) session.get(Entity_Coupon.class, id);
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
	public boolean addCoupon(Entity_Coupon ob) {

		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			//----------------------
			System.out.println(ob);
			session.save(ob);
			
			//----------------------
			session.getTransaction().commit();
			session.close();
								System.out.println("add coupon "+ob.getCouponId()+" "+ob.getBusinessId()+" "+ob.getImage()+" comleted."+cr);
		} catch (Exception e) {
								System.out.println("error: add coupon."+cr);
			return false;
		}
		return true;
	}
	
	@Override
	public Iterator<Entity_Coupon> getAllCoupons() {
		Iterator iterator = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			//-------------
			List coupons = session.createCriteria(Entity_Coupon.class).list();
			System.out.println("There are " + coupons.size() + " coupon(s):");
			iterator = coupons.iterator();
//			while(iterator.hasNext()) 
//			{
//				System.out.println(iterator.next());
//			}
//			//-------------
			session.getTransaction().commit();
			session.close();
			System.out.println("getting all coupons completed."+cr);
		} catch (HibernateException e) {
      		System.out.println("error: deleting coupon"+cr);
			return null;
      }
		return iterator;
	}
	
	//##################################################################
	
	@Override
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

	@Override
	public boolean deleteBusiness(int id) {
		Entity_Business businessToDel = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			//-------------
			businessToDel = new Entity_Business();
			businessToDel.setBusinessId(id);
			
			System.out.println(businessToDel);
            session.delete(businessToDel);
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

	@Override
	public Entity_Business getBusiness(int id) {
		Entity_Business business = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			//-------------
			business =  (Entity_Business) session.get(Entity_Business.class, id);
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
	
	@Override
	public Iterator<Entity_Business> getAllBusinesses() {
		Iterator iterator = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			//-------------
			List businesses = session.createCriteria(Entity_Business.class).list();
			System.out.println("There are " + businesses.size() + " business(es):");
			iterator = businesses.iterator();
//				while(iterator.hasNext()) 
//				{
//					System.out.println(iterator.next());
//				}
//				//-------------
			session.getTransaction().commit();
			session.close();
			System.out.println("getting all business completed."+cr);
		} catch (HibernateException e) {
        		System.out.println("error: deleting business"+cr);
			return null;
        }
		return iterator;
	}


	//##################################################################
	
	@Override
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

	@Override
	public boolean deleteUser(String userName) {
		Entity_User userToDel = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			//-------------
			userToDel = new Entity_User();
			userToDel.setUserName(userName);
			
			System.out.println(userToDel);
            session.delete(userToDel);
			//-------------
			session.getTransaction().commit();
			session.close();
								System.out.println("deleting User: "+userName+" completed.");
		} catch (HibernateException e) {
        						System.out.println("error: deleting User: "+userName);
            return false;
        }
		return true;
	}

	@Override
	public Entity_User getUser(String userName) {
		Entity_User user = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			//-------------
			user =  (Entity_User) session.get(Entity_User.class, userName);
			//-------------
			session.getTransaction().commit();
			session.close();
									System.out.println("get User completed."+cr);
		} catch (Exception e) {
									System.out.println("error: get User."+cr);
			e.printStackTrace();
			return null;
		}
		return user;
	}
	
	@Override
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
	
	@Override
	public Iterator<Entity_User> getAllUsers() {
		Iterator iterator = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			//-------------
			List users = session.createCriteria(Entity_User.class).list();
			System.out.println("There are " + users.size() + " User(s):");
			iterator = users.iterator();
//				while(iterator.hasNext()) 
//				{
//					System.out.println(iterator.next());
//				}
//				//-------------
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

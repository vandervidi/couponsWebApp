package com.oa.couponsWebApp;


//import java.sql.ResultSet;
import java.util.Iterator;
import java.util.List;



//import javax.management.InstanceAlreadyExistsException;
//import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;


public class CouponDAO implements ICouponsDAO {

//	public static String driver = "org.apache.derby.jdbc.ClientDriver";
//    public static String protocol = "jdbc:derby://localhost:1527/ofirDB;create=true";
//    
//    public Connection connection = null;
//	public Statement statement = null;
	//public ResultSet rs = null;
	private static SessionFactory sessionFactory = null;
	private Session session = null;
	String cr = "\n----------------";
	
	//**Singleton***************************************************************
	private static CouponDAO instance;

	
	// Private constructor prevents instantiation from other classes
	  private CouponDAO() {
		  sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		  //sessionFactory = new Configuration().configure().buildSessionFactory();
	  }

	  public static CouponDAO getInstance() {
		  if (instance==null)
			  instance=new CouponDAO();
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
	public boolean updateCoupon(Coupon ob) {
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			//-------------
			session.update(ob);
			//-------------
			session.getTransaction().commit();
			session.close();
									System.out.println("update coupon "+ob.getId()+"completed."+cr);
		} catch (Exception e) {
									System.out.println("error: update coupon "+ob.getId()+cr);
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
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
								//System.out.println("add coupon "+ob.getId()+" "+ob.getBusinessId()+" "+ob.getImage()+" comleted."+cr);
		} catch (Exception e) {
								System.out.println("error: add coupon."+cr);
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
			//-------------
			List coupons = session.createCriteria(Coupon.class).list();
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
}
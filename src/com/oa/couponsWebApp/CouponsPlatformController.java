package com.oa.couponsWebApp;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;

/**
 * Servlet implementation class CouponsPlatformController
 * 
 */
@WebServlet("/controller/*")
public class CouponsPlatformController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	* Log4j logger
	*/
	private static Logger logger = Logger.getLogger("CouponsPlatformController");
	
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CouponsPlatformController() {
		super();
		// TODO Auto-generated constructor stub
		logger.error("CouponsPlatformController constructor");
	}

	/**
	 * DoPost()
	 * login - for login page (POST)
	 * send cookies with request
	 */
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			 throws ServletException, IOException
	 {
		 String str = request.getPathInfo();
		 // Log in 
		if(str.equals("/login")) {
			
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			password = MD5.encryptMD5(password);
			
			DAO db = DAO.getInstance();
			User user = db.getUser(username);
			if (user!=null){

				//Check password
				if (user.getPassword().equals(password) ) {

					// Pass true
					if (user.getPrivilige() == 1){
						// - 1 - UserName login as admin
						/* Create session & coockie
						 * 
						 * 
						 */
						Cookie cookie = new Cookie("connectedWithPrivilige", "1");
						cookie.setMaxAge(-1);	// till user close browser
						
						cookie.setPath("/");
						response.addCookie( cookie );
						
						Cookie lastUserCookie = new Cookie("lastUser", user.getUsername());
						lastUserCookie.setMaxAge(3600);	// stays alive for 1 hour
						
						lastUserCookie.setPath("/");
						response.addCookie( lastUserCookie );
						
						RequestDispatcher dispatcher = getServletContext()
								.getRequestDispatcher("/views/adminPanel.jsp");
						dispatcher.forward(request, response);
					}
					else{
						// - 0 - userName login as Regular user
						/* Create session & coockie
						 * 
						 * 
						 */
						Cookie cookie = new Cookie("connectedWithPrivilige", "0");
						cookie.setMaxAge(-1);// till user close browser
						
						response.addCookie(new Cookie("connectedWithPrivilige", "0"));
						request.setAttribute("userName", username);
						RequestDispatcher dispatcher = getServletContext()
								.getRequestDispatcher("/views/index.jsp");
						dispatcher.forward(request, response);
					}
						
				}else{	
					// in case the password is not vaild - redirect to error page
					request.setAttribute("msg", " Wrong password");
					RequestDispatcher dispatcher = getServletContext()
							.getRequestDispatcher("/views/error.jsp");
					dispatcher.forward(request, response);
				}
			}
			else
			{
				// in case the username is not vaild - redirect to error page
				request.setAttribute("msg", "User does not exist");
				RequestDispatcher dispatcher = getServletContext()
						.getRequestDispatcher("/views/error.jsp");
				dispatcher.forward(request, response);
			}
		}		
	 }
	 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 * run on all if..else if...else if.....else.    
	 * until find the request
	 * in the else if's:
	 * 
	 *   
	 * category					-for nevigate for user request category of coupons
	 * 
	 * *****************************************************************************************
	 * customJavaBean			-JavaBean ex. create rectangle with parameters (12.4 , 13.5)
	 * customTag				-custom tag ex. create custom tag in jsp and show it
	 * *****************************************************************************************
	 * 
	 * register					-(for future use) register a new user
	 * logout					-logout if user login before
	 * 
	 * addCoupon				-add a coupon to db
	 * addBusiness				-add a business to db
	 * 
	 * updateBusinessPreview	-Preview the business that is to be updated in a form
	 * updateBusiness     		-Update a Business in db
	 * 
	 * updateCouponPreview		-Preview the coupon that is to be updated in a form
	 * updateCoupon				-Update a Coupon in db
	 * 
	 * help						-help page for explain somethings
	 * contact					-contact with us future send mail
	 * about					-about us
	 * 
	 * location					-show coupons from a location by length and width
	 * 
	 * coupons					-show all ACTIVE coupons
	 * expiredCoupons			-show all EXPIRED coupons
	 * 
	 * businesses				-show all businesses
	 * deleteCoupon				-delete a coupon by ID
	 * deleteBusiness			-delete a business by ID
	 * 
	 * coupon					-show a Specific coupon
	 * 
	 * if none of those.. show the index.jsp page
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String str = request.getPathInfo();
		
		// Category
				if (str.equals("/category")) {
					String categoryName = request.getParameter("category");				
					// Coupons Iterator
			        Iterator couponsIterator = DAO.getInstance().getAllCoupons();
			        request.setAttribute("couponsIterator", couponsIterator);			   
				    request.setAttribute("categoryName", categoryName);
					RequestDispatcher dispatcher = getServletContext()
							.getRequestDispatcher("/views/categories.jsp");
					dispatcher.forward(request, response);
				} 
				
				// JavaBean ex. create rectangle with parameters (12.4 , 13.5)
				else if(str.equals("/customJavaBean")){
					Rectangle ob = new Rectangle(12.4,13.5);
					request.setAttribute("rec", ob);
					
					RequestDispatcher dispatcher = getServletContext()
							.getRequestDispatcher("/views/customJavaBean.jsp");
					dispatcher.forward(request, response);
				}
				
				//custom tag ex. create custom tag in jsp and show it
				else if (str.equals("/customTag")){
					RequestDispatcher dispatcher = getServletContext()
							.getRequestDispatcher("/views/customTag.jsp");
					dispatcher.forward(request, response);;
				}
				
		// Register
				else if(str.equals("/register")) {					
					RequestDispatcher dispatcher = getServletContext()
							.getRequestDispatcher("/views/register.jsp");
					dispatcher.forward(request, response);			
				}
				

		// Log out 
			else if(str.equals("/logout")) {
			
				Cookie all [] = request.getCookies();
				for (Cookie c : all){
					if (c.getName().equals("connectedWithPrivilige") ){	
						c.setValue("");
			            c.setPath("/");
						c.setMaxAge(0);		// 0  =  delete cookie immediately from user browser
						response.addCookie(c);
						break;
								
					}
				}
				RequestDispatcher dispatcher = getServletContext()
						.getRequestDispatcher("/controller/");
				dispatcher.forward(request, response);			
			}
		
		//add a coupon to db - working!
		else if(str.equals("/addCoupon")) {

			String name			 = request.getParameter("name");
			String image		 = request.getParameter("image");
			String businessId	 = request.getParameter("businessId");
			String description	 = request.getParameter("description");
			String expireDate	 = request.getParameter("expDate");
			String category		 = request.getParameter("category");
			String price		 = request.getParameter("price"); 
			
			double dooublePrice = Double.parseDouble(price);
			int busId=Integer.parseInt(businessId);
			// Check if busId exist
			if(DAO.getInstance().getBusiness(busId)!=null){
				DAO.getInstance().addCoupon(new Coupon(name,busId,image,description,expireDate,category,dooublePrice));
	
				RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/views/adminPanel.jsp");
				dispatcher.forward(request, response);
			}else{
				request.setAttribute("msg", "This businiess ID does not wxist");
				RequestDispatcher dispatcher = getServletContext()
						.getRequestDispatcher("/views/error.jsp");
				dispatcher.forward(request, response);
			}
		}
		// add a new business - working!
		else if(str.equals("/addBusiness")) {
				String businessName		 = request.getParameter("businessName");
				String businessLength	 = request.getParameter("length");
				String businessWidth	 = request.getParameter("width");
				double busLength=	Double.parseDouble(businessLength);
				double busWidth=	Double.parseDouble(businessWidth);
				DAO.getInstance().addBusiness(new Business(businessName, busLength, busWidth));
				RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/views/businesses.jsp");
				dispatcher.forward(request, response);			
			}

		// Preview the business that is to be updated in a form. - working
				else if(str.equals("/updateBusinessPreview")) {
					String businessId=request.getParameter("updateId");
					int businessIdInteger = Integer.parseInt(businessId);
					Business business = DAO.getInstance().getBusiness(businessIdInteger);
					request.setAttribute("business", business);
					RequestDispatcher dispatcher = getServletContext()
							.getRequestDispatcher("/views/updateBusiness.jsp");
					dispatcher.forward(request, response);			
				}
		
		// Update a Business in db - working
				else if(str.equals("/updateBusiness")) {
					String businessName = request.getParameter("businessName");
					
					// ID
					String businessId = request.getParameter("businessId");
					int busId=Integer.parseInt(businessId);
					
					//Location
					String businessLength	 = request.getParameter("length");
					String businessWidth	 = request.getParameter("width");
					double busLength		 = Double.parseDouble(businessLength);
					double busWidth          = Double.parseDouble(businessWidth);
					
					DAO.getInstance().updateBusiness(new Business(busId,businessName, busLength, busWidth));
					
					RequestDispatcher dispatcher = getServletContext()
							.getRequestDispatcher("/views/businesses.jsp");
					dispatcher.forward(request, response);			
				}

		
		// Preview the coupon that is to be updated in a form. - working
		else if(str.equals("/updateCouponPreview")) {
			String couponId=request.getParameter("updateId");
			int couponIdInteger = Integer.parseInt(couponId);
			Coupon coupon = DAO.getInstance().getCoupon(couponIdInteger);
			request.setAttribute("coupon", coupon);
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/views/updateCoupon.jsp");
			dispatcher.forward(request, response);			
		}
		
		// Update a Coupon in db - Working
				else if(str.equals("/updateCoupon")) {
					String name= request.getParameter("name");
					String price = request.getParameter("price");
					String image = request.getParameter("image");
					String businessId = request.getParameter("businessId");
					String description = request.getParameter("description");
					String expireDate = request.getParameter("expDate");
					double doublePrice = Double.parseDouble(price);
					int busId=Integer.parseInt(businessId);
					String couponId = request.getParameter("couponId");
					int couponIdInteger = Integer.parseInt(couponId);
					String category = request.getParameter("category");
					
					DAO.getInstance().updateCoupon(new Coupon(couponIdInteger,name,busId,image,description,expireDate,category,doublePrice));
					
					RequestDispatcher dispatcher = getServletContext()
							.getRequestDispatcher("/views/adminPanel.jsp");
					dispatcher.forward(request, response);			
				}

		
		// Help - working!
		else if(str.equals("/help")) {
			request.setAttribute("timestamp", new java.util.Date());
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/views/help.jsp");
			dispatcher.forward(request, response);			
		}	
				
		// Contact - working!
		else if(str.equals("/contact")) {
			request.setAttribute("timestamp", new java.util.Date());
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/views/contact.jsp");
			dispatcher.forward(request, response);			
		}
		
		// about- working!
		else if(str.equals("/about")) {
			request.setAttribute("timestamp", new java.util.Date());
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/views/about.jsp");
			dispatcher.forward(request, response);			
		}			
				
		// Show all coupons by location of theyier businesses
		//example : .../location&length=100&width=100
			else if(str.equals("/location")) {
				
				String length=request.getParameter("length");
				String width=request.getParameter("width");
				if (length==null || width==null)
				{
					request.setAttribute("msg", " You used wrong parameters for 'location'! try using 'width' and 'length'");
					RequestDispatcher dispatcher = getServletContext()
							.getRequestDispatcher("/views/error.jsp");
					dispatcher.forward(request, response);
				}	
				else{

				double busLength=	Double.parseDouble(length);
				double busWidth=	Double.parseDouble(width);
				
				request.setAttribute("busLength", busLength);
				request.setAttribute("busWidth", busWidth);
				
				System.out.println("length="+busLength+" width="+busWidth);
				// Business Iterator
				Iterator businessIterator = DAO.getInstance().getAllBusinesses();
		        request.setAttribute("businessIterator", businessIterator);
		        
		        // Coupons Iterator
		        Iterator couponsIterator = DAO.getInstance().getAllCoupons();
		        request.setAttribute("couponsIterator", couponsIterator);
		        
				RequestDispatcher dispatcher = getServletContext()
						.getRequestDispatcher("/views/businessByLocation.jsp");
				dispatcher.forward(request, response);	
				}
			}			
		// show all ACTIVE coupons - working
		else if(str.equals("/coupons")) {
			request.setAttribute("timestamp", new java.util.Date());
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/views/adminPanel.jsp");
			dispatcher.forward(request, response);			
		}
		// show all EXPIRED coupons - working
			else if(str.equals("/expiredCoupons")) {
				request.setAttribute("timestamp", new java.util.Date());
				RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/views/expiredCoupons.jsp");
				dispatcher.forward(request, response);			
					}				
				
		
		// print all businesses - working!
		else if(str.equals("/businesses")) {
			request.setAttribute("timestamp", new java.util.Date());
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/views/businesses.jsp");
			dispatcher.forward(request, response);			
		}
		
		// Delete a coupon by id - working
				else if(str.equals("/deleteCoupon")) {
					String couponId = request.getParameter("deleteId");
					int couponIdTodelete = Integer.parseInt(couponId);
					DAO.getInstance().deleteCoupon(couponIdTodelete);
					
					RequestDispatcher dispatcher = getServletContext()
							.getRequestDispatcher("/views/adminPanel.jsp");
					dispatcher.forward(request, response);			
				}
		
		// Delete a business by id - working
				else if(str.equals("/deleteBusiness")) {
					String businessId = request.getParameter("deleteId");
					int businessIdTodelete = Integer.parseInt(businessId);
					DAO.getInstance().deleteBusiness(businessIdTodelete);
					
					RequestDispatcher dispatcher = getServletContext()
							.getRequestDispatcher("/views/businesses.jsp");
					dispatcher.forward(request, response);	
	
				}
				
		
		// show a Specific coupon - working
		else if(str.contains("/coupon")) {
			request.setAttribute("timestamp", new java.util.Date());
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/views/coupon.jsp");
			dispatcher.forward(request, response);

		}

		// Home-page - working!
		else {
			Cookie cookies[] = request.getCookies();
			
			request.setAttribute("cookies", cookies);
			request.setAttribute("timestamp", new java.util.Date());
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/views/index.jsp");
			dispatcher.forward(request, response);			
		}
		
	}
}

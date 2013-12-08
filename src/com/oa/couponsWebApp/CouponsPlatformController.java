package com.oa.couponsWebApp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CouponsPlatformController
 */
@WebServlet("/controller/*")
public class CouponsPlatformController extends HttpServlet {
	
	// Create db Singleton
	// Shotcut
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CouponsPlatformController() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			 throws ServletException, IOException
	 {
		 String str = request.getPathInfo();
		 System.out.println(str);
		
		 // Log in 
		if(str.equals("/login")) {
			System.out.println("/login");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			password = MD5.encryptMD5(password);
			
			DAO db = DAO.getInstance();
			User user = db.getUser(username);
			if (user!=null){
//										System.out.println("user.toString()="+user.toString());
//										System.out.println("user.getPassword()="+user.getPassword());
//										System.out.println("user.MD5(pagePasswordInput)"+user.MD5(password));
				//Check password
				if (user.getPassword().equals(password) ) {
										System.out.println("user.checkPassword(password) == true");
					// Pass true
					if (user.getPrivilige() == 1){
						// - 1 - UserName login as admin
						/* Create session & coockie
						 * 
						 * 
						 */
						Cookie cookie = new Cookie("connectedWithPrivilige", "1");
						cookie.setMaxAge(-1);	// till user close browser
						
						response.addCookie( cookie );
						RequestDispatcher dispatcher = getServletContext()
								.getRequestDispatcher("/views/adminPanel.jsp");
						dispatcher.forward(request, response);
					}
					else{// - 0 - userName login as Regular user
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
						
				}else{	// Paswword not vaild
					request.setAttribute("number", "20");
					request.setAttribute("msg", "password does not vaild.");
					RequestDispatcher dispatcher = getServletContext()
							.getRequestDispatcher("/views/error.jsp");
					dispatcher.forward(request, response);
				}
			}
		}
		else{
			System.out.println("2222");
		}
	 }
	 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String str = request.getPathInfo();
		
		// Categories
				if (str.equals("/categories")) {
					request.setAttribute("timestamp", new java.util.Date());
					RequestDispatcher dispatcher = getServletContext()
							.getRequestDispatcher("/views/categories.jsp");
					dispatcher.forward(request, response);
				} 
		
		// Register
				else if(str.equals("/register")) {					
					RequestDispatcher dispatcher = getServletContext()
							.getRequestDispatcher("/views/register.jsp");
					dispatcher.forward(request, response);			
				}
				

		// Log out 
			else if(str.equals("/logout")) {
				if (request.getCookies().equals("connectedWithPrivilige" )){
					Cookie all [] =request.getCookies();
					for (Cookie c : all){
//							if (c.getName().equals( "connectedWithPrivilige")){
							System.out.println(  "c.getName().equals(connectedWithPrivilige)");
							c.setMaxAge(0);		// 0 to delete cookie immediately from user browser
							response.addCookie(c);
							
							request.setAttribute("timestamp", new java.util.Date());
							
							request.getCookies();
							
							RequestDispatcher dispatcher = getServletContext()
									.getRequestDispatcher("/views/index.jsp");
							dispatcher.forward(request, response);
										System.out.println("change Cookie to 0, Cookie="+c);
//							}
					}
				}
							
			}
		
		//add a coupon to db - working!
		else if(str.equals("/addCoupon")) {

			String image		 = request.getParameter("image");
			String businessId	 = request.getParameter("businessId");
			String description	 = request.getParameter("description");
			String expireDate	 = request.getParameter("expDate");
			int busId=Integer.parseInt(businessId);
			// Check if busId exist
			if(DAO.getInstance().getBusiness(busId)!=null){
				
				DAO.getInstance().addCoupon(new Coupon(busId,image,description,expireDate));
	
				RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/views/adminPanel.jsp");
				dispatcher.forward(request, response);
			}else{
				request.setAttribute("number", "20");
				request.setAttribute("msg", "businessId does not exist.");
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
				//System.out.println(businessName);
				DAO.getInstance().addBusiness(new Business(businessName, busLength, busWidth));
				RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/views/adminPanel.jsp");
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
					double busLength=	Double.parseDouble(businessLength);
					double busWidth=	Double.parseDouble(businessWidth);
					
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
					String image = request.getParameter("image");
					String businessId = request.getParameter("businessId");
					String description = request.getParameter("description");
					String expireDate = request.getParameter("expDate");
					int busId=Integer.parseInt(businessId);
					String couponId = request.getParameter("couponId");
					int couponIdInteger = Integer.parseInt(couponId);
					DAO.getInstance().updateCoupon(new Coupon(couponIdInteger,busId,image,description,expireDate));
					
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
				
		// Contact
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
				
		// print all coupons - working
		else if(str.equals("/coupons")) {
			request.setAttribute("timestamp", new java.util.Date());
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/views/adminPanel.jsp");
			dispatcher.forward(request, response);			
		}
				// print all EXPIRED coupons - working
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
					String couponId = request.getParameter("deleteId");
					int businessIdTodelete = Integer.parseInt(couponId);
					DAO.getInstance().deleteBusiness(businessIdTodelete);
					
					RequestDispatcher dispatcher = getServletContext()
							.getRequestDispatcher("/views/businesses.jsp");
					dispatcher.forward(request, response);	
	
				}
		// Specific coupon - working
		else if(str.contains("/coupon")) {
			request.setAttribute("timestamp", new java.util.Date());
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/views/coupon.jsp");
			dispatcher.forward(request, response);

		}

		// Home-page - working!
		else {
			request.setAttribute("timestamp", new java.util.Date());
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/views/index.jsp");
			dispatcher.forward(request, response);			
		}
		
	}

//	void sendError(HttpServletRequest request, HttpServletResponse response, int nm, String msg) throws IOException, ServletException{
//		request.setAttribute("number", nm);
//		request.setAttribute("msg", msg);
//		request.setAttribute("timestamp", new java.util.Date());
//		RequestDispatcher dispatcher = getServletContext()
//				.getRequestDispatcher("/views/error.jsp");
//		dispatcher.forward(request, response);	
//	}
}

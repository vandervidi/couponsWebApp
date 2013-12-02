package com.oa.couponsWebApp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
		 //System.out.println("1111");
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
		
		// Log in 
				else if(str.equals("/register")) {					
					//make a new "user" object.construct only by name
					//locate the user in the users database
					//encrypt the password and compare with the one in the DB.
					//if it matches-> make session. else- redirect to index.
					//if admin logs in-> redirect to adminPanel.jsp
					
					RequestDispatcher dispatcher = getServletContext()
							.getRequestDispatcher("/views/register.jsp");
					dispatcher.forward(request, response);			
				}
				
		// Log in 
				else if(str.equals("/login")) {
					String username = request.getParameter("username");
					String password = request.getParameter("password");
					DAO db = DAO.getInstance();
					User user = db.getUser(username);
					user.toString();
					System.out.println("The username from db:"+ user.getUsername());
					System.out.println("The password from index.jsp:"+ password);
					System.out.println("Hased pass from index:"+user.MD5(password));
					System.out.println("the password from DB:"+user.getPassword());
					if (user!=null){
						
						//Check password
						if (user.checkPassword(password) == true) {
							
							// Pass true
							if (user.getPrivilige() == 1){
								// UserName login as admin
								RequestDispatcher dispatcher = getServletContext()
										.getRequestDispatcher("/views/adminPanel.jsp");
								dispatcher.forward(request, response);
							}
							else{
								request.setAttribute("userName", username);
								RequestDispatcher dispatcher = getServletContext()
										.getRequestDispatcher("/views/helloPage.jsp");
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
		
		// Log out 
				else if(str.equals("/logout")) {
					request.setAttribute("timestamp", new java.util.Date());
					RequestDispatcher dispatcher = getServletContext()
							.getRequestDispatcher("/views/logout.jsp");
					dispatcher.forward(request, response);			
				}
		
		//add a coupon to db - working!
		else if(str.equals("/addCoupon")) {

			String image = request.getParameter("image");
			String businessId = request.getParameter("businessId");
			String description = request.getParameter("description");
			String expireDate = request.getParameter("expDate");
			int busId=Integer.parseInt(businessId);
			DAO.getInstance().addCoupon(new Coupon(busId,image,description,expireDate));

			RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/views/adminPanel.jsp");
			dispatcher.forward(request, response);			
		}
		// add a new business - working!
		else if(str.equals("/addBusiness")) {
				String businessName = request.getParameter("businessName");
				System.out.println(businessName);
				DAO.getInstance().addBusiness(new Business(businessName));
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
					String businessId = request.getParameter("businessId");
					int busId=Integer.parseInt(businessId);
					DAO.getInstance().updateBusiness(new Business(busId,businessName));
					
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

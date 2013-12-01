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
		 
	 }
	 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String str = request.getPathInfo();

		// about- working!
		if (str.equals("/about")) {
			request.setAttribute("timestamp", new java.util.Date());
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/views/about.jsp");
			dispatcher.forward(request, response);
		} 
		// Log in 
				else if(str.equals("/logIn")) {
					String username = request.getParameter("username");
					String password = request.getParameter("password");
					
					//make a new "user" object.construct only by name
					//locate the user in the users database
					//encrypt the password and compare with the one in the DB.
					//if it matches-> make session. else- redirect to index.
					//if admin logs in-> redirect to adminPanel.jsp
					
					RequestDispatcher dispatcher = getServletContext()
							.getRequestDispatcher("/views/businesses.jsp");
					dispatcher.forward(request, response);			
				}
		
		// Log out 
				else if(str.equals("/logIn")) {
					request.setAttribute("timestamp", new java.util.Date());
					RequestDispatcher dispatcher = getServletContext()
							.getRequestDispatcher("/views/businesses.jsp");
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
			if (str.length()>=8 && str.charAt(7)=='/'){
				String couponId = str.substring(8);
				if (couponId!=null && couponId!=""){
					request.setAttribute("couponId", couponId);
					//request.setAttribute("couponUserRequest", couponUserRequest);
					request.setAttribute("timestamp", new java.util.Date());
					RequestDispatcher dispatcher = getServletContext()
							.getRequestDispatcher("/views/coupon.jsp");
					dispatcher.forward(request, response);
				}
				else{
				response.sendError(20, "error: coupon id not vaild!");
				}
			}
			//redirect to coupon
			else{
				response.sendRedirect("/couponsWebApp/controller/coupon/");
			}
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

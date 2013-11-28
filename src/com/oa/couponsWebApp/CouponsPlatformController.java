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

		//part of the code for adding a coupon into db
//		String image = request.getParameter("image");
//		String  bussinessId = request.getParameter("bussinessId");
//		String description = request.getParameter("description");
//		String expireDate = request.getParameter("expDate");
//		
//		int busId=Integer.parseInt(bussinessId);
//		CouponDAO.getInstance().addCoupon(new Coupon(busId,image,description,expireDate));
//		
		
		// about
		if (str.equals("/about")) {
			request.setAttribute("timestamp", new java.util.Date());
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/views/about.jsp");
			dispatcher.forward(request, response);
		} 
		
		// Help
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
		
		// All coupons
		else if(str.equals("/coupons")) {
			request.setAttribute("timestamp", new java.util.Date());
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/views/coupons.jsp");
			dispatcher.forward(request, response);			
		}
		
		// Specific coupon
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
		
		
//		else if(str.contains("/coupon")) {
//			CouponDAO dbInstance = null;
//			Coupon couponUserRequest = null;
//			//String couponId = str.substring(8);
//			System.out.println(CouponDAO.getInstance());
//			try{
//				
//				//						System.out.println("couponId="+couponId);
//				//dbInstance = db.getInstance();
//				
//				//						System.out.println( db.getInstance() );
//				//couponUserRequest = dbInstance.getCoupon( Integer.parseInt(couponId) );
//				//						System.out.println("finish");
//				request.setAttribute("couponId", couponId);						
//				request.setAttribute("timestamp", new java.util.Date());
//				RequestDispatcher dispatcher = getServletContext()
//						.getRequestDispatcher("/views/coupon.jsp");
//				dispatcher.forward(request, response);	
//			}
//			catch(Exception e){	
//				System.out.println("ffff");
//			}
//		}
		
		// Home-page
		else {
			request.setAttribute("timestamp", new java.util.Date());
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/views/home-page.jsp");
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

<%@ page language="java" contentType="text/html; charset=windows-1255" pageEncoding="windows-1255"%>
<%@ page import="com.oa.couponsWebApp.temp_CouponDAO,com.oa.couponsWebApp.Coupon" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">
<title>Insert title here</title>
</head>
<body>
	<h2>coupon</h2>
	<%
		//CouponDAO couponInstance = null;
		Object couponId = request.getAttribute("couponId");
		String couponIdString = ((String)couponId);
		Coupon coupon = temp_CouponDAO.getInstance().getCoupon( Integer.parseInt(couponIdString) );
		if (coupon!=null){
			out.println("Your coupon id request is: "+ coupon.getId() +"<br/>\n"+ coupon +"<br/>\n");
		}else{
			out.println("error: Your coupon id "+ couponId +" was not found!" +"<br/>\n");
			//response.sendError(20, "error: Your coupon id "+ couponId +"was not found!");
		}
			
		Object ob = request.getAttribute("timestamp");
		out.println("<br/>\n" + ob);
	%>
</body>
</html>
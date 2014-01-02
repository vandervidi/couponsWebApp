<%@ page language="java" contentType="text/html; charset=windows-1255" pageEncoding="windows-1255"%>
<%@ page import="com.oa.couponsWebApp.DAO 
		,com.oa.couponsWebApp.Coupon 
		,com.oa.couponsWebApp.Business
		,com.oa.couponsWebApp.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">
<title>Insert title here</title>
</head>
<body>
	<h2>Show coupon by id</h2>
	
	<form action="../controller/coupon" method="get">
	coupon Id: <input type=text name="coupon"><br>
	<input type=submit>
	</form>
	
<%--	
		//CouponDAO couponInstance = null;
		Object couponFound = request.getAttribute("couponFound");
		//String couponFoundString = ((String)couponFound);
		Coupon coupon = (Coupon) couponFound;
		if (coupon!=null){
			out.println("Your coupon id request is: "+ coupon.getCouponId() +"<br/>\n"+ coupon +"<br/>\n");
		}else{
			out.println("error: Your coupon id "+ coupon +" was not found!" +"<br/>\n");
			//response.sendError(20, "error: Your coupon id "+ couponId +"was not found!");
		}
			
		Object ob = request.getAttribute("timestamp");
		out.println("<br/>\n" + ob);
	--%>
</body>
</html>
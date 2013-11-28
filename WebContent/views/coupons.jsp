<%@ page language="java" contentType="text/html; charset=windows-1255" pageEncoding="windows-1255"%>
<%@ page import="com.oa.couponsWebApp.CouponDAO , java.util.Iterator" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">
<title>Insert title here</title>
</head>
<body>
	<h2>coupons</h2>
<%
	Iterator iterator = CouponDAO.getInstance().getAllCoupons();
	
	while(iterator.hasNext()) {
		out.println(iterator.next()+ "<br/>\n");	
	}
	
	Object ob = request.getAttribute("timestamp");
	out.println("<br/>\n" + ob);
%>
</body>
</html>
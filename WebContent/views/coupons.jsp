<%@page import="com.oa.couponsWebApp.Coupon"%>
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
	<img src="vidi.jpeg">
<%
Object ob = request.getAttribute("timestamp");
out.println("<br/>\n" + ob);
//Iterator of Coupons
	Iterator iterator = CouponDAO.getInstance().getAllCoupons();
	Object tempOb;
	while(iterator.hasNext()) {
		tempOb=iterator.next();
	
%>


<br><br><br><br><br>
<div id="container" style="width:700px">

<div id="header" style="background-color:#FFA500;">
<h1 style="margin-bottom:0;">Coupon name</h1></div>

<div id="menu" style="background-color:#FFD700;height:200px;width:400px;float:left;">
<img src=<% out.println(((Coupon)tempOb).getImage()); %>width="300"></div>

<div id="content" style="background-color:#EEEEEE;height:200px;width:300px;float:right;">
<% out.println(((Coupon)tempOb).getDescription()); %></div>

</div>
<br><br>
<br>
<br>
<% } %>
</body>
</html>
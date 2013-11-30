<%@page import="com.oa.couponsWebApp.Business"%>
<%@page import="com.oa.couponsWebApp.DAO"%>
<%@page import="com.oa.couponsWebApp.Coupon"%>
<%@ page language="java" contentType="text/html; charset=windows-1255" pageEncoding="windows-1255"%>
<%@ page import="com.oa.couponsWebApp.DAO , java.util.Iterator" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">
<title>Admin Panel</title>
</head>
<body>
	<h2>Admin Panel - List of all businesses registered</h2>
<br>
<div style="color: white; background-color:#151515;text-align: center; margin:0 auto; padding-top: 2px;padding-bottom: 1px;">
        <a href="../views/addCoupon.html">
        <div>ADD COUPON</div></a>
        <a href="../views/addBusiness.html">
        <div>ADD BUSINESS</div></a>
         <a href="../controller/coupons">
        <div>SHOW COUPONS</div></a>   
        <a href="../controller/logOut">
        <div>LOG OUT</div></a>      
        </div>


<%
//Iterator of businesses
	Iterator iterator = DAO.getInstance().getAllBusinesses();
	Object tempOb;
	while(iterator.hasNext()) {
		tempOb=iterator.next();
	
%>

<br><br><br><br><br>
<div id="container" style="width:400px">

<div id="header" style="background-color:#FFA500;">
<h1 style="margin-bottom:0;"><% out.println(((Business)tempOb).getBusinessName()); %></h1></div>

<div id="id" style="background-color:#FFD700;height:200px;width:400px;float:left;">
Business id: <% out.println(((Business)tempOb).getBusinessId()); %></div>

</div>
<br><br>
<br>
<br>
<% } %>
</body>
</html>
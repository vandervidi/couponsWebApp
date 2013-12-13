<%@ page language="java" contentType="text/html; charset=windows-1255" pageEncoding="windows-1255"%>
<%@ page import="javax.servlet.http.Cookie" %>
<%@ page import="com.oa.couponsWebApp.DAO , java.util.Iterator,java.text.* ,java.util.*" %>

<%@page import="com.oa.couponsWebApp.Coupon"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Admin-Panel</title>
<meta charset="utf-8">
<link type="text/css" rel="stylesheet" href="../views/styles/style.css" />

</head>

<body class="page">
<div id="wrap">
  <div id="header"> 
     logo
    <div id="nav">
      <ul class="menu">
        <li><a href="../views/addCoupon.html">Add coupon</a></li>
        <li><a href="../views/addBusiness.html">Add business</a></li>
        <li><a href="../controller/businesses">Show businesses</a></li>
        <li><a href="../controller/expiredCoupons">Show expired coupons</a></li>
         <li><a href="../controller/logout">logout</a></li>
      </ul>
    </div>
    <!--end nav-->
<%
out.print("Connected as admin.");
%>
  </div>
  <!--end header-->

    <div id="porfolio-content">
      
<h2>ADMIN PANEL - all coupons</h2>            
     <%

//Iterator of Coupons - printing only up to date Coupons. Today's day=EXPIRED!
        Iterator iterator = DAO.getInstance().getAllCoupons();
        Object tempOb;
        Date currDate=new Date();
        
        while(iterator.hasNext()) {
                tempOb=iterator.next();
                String expireDate=((Coupon)tempOb).getExpireDate();
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		   		Date expDate =  df.parse(expireDate);
		   		
		   		if (( expDate.after(currDate) )
	        			|| ( expDate.getYear()==currDate.getYear()
	        				&& expDate.getMonth()==currDate.getMonth()
	        				&& expDate.getDay()==currDate.getDay()) )
	            {   
%>
<br><br>
<div style="width:600px">

<div style="background-color:#FFA500;height: 30px;">
<h3 style="margin-bottom:0;"><% out.print(((Coupon)tempOb).getName()); %></h3></div>

<div style="background-color:#FFD700;height:200px;width:300px;float:left;">
<img src="../views/<% out.print(((Coupon)tempOb).getImage()); %>" width="300"></div>

<div style="background-color:#EEEEEE;height:200px;width:300px;float:right;">
<% out.print(((Coupon)tempOb).getDescription()); %></div><br>

<div style="background-color:#EEEEEE;height:20px;width:300px;float:left;">
<% out.print("Price: " +((Coupon)tempOb).getPrice()); %></div>

<div style="background-color:#EEEEEE;height:20px;width:300px;float:right;">
<% out.print("Expire date: " +((Coupon)tempOb).getExpireDate()); %></div>
<form action="../controller/updateCouponPreview" method="get">
<input type="hidden" name="updateId" value="<% out.print(((Coupon)tempOb).getId());%>">
<input type="submit" value="Update"></form>

<form action="../controller/deleteCoupon" method="get">
<input type="hidden" name="deleteId" value="<% out.print(((Coupon)tempOb).getId());%>"><input type="submit" value="Delete"></form>
</div>


<% 			}
	}
%>
        
    </div>
</div>
<!--end wrap-->
</html>
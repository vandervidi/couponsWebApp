<%@ page language="java" contentType="text/html; charset=windows-1255" pageEncoding="windows-1255"%>
<%@ page import="javax.servlet.http.Cookie" %>
<%@ page import="com.oa.couponsWebApp.DAO , java.util.Iterator,java.text.* ,java.util.*" %>

<%@page import="com.oa.couponsWebApp.Coupon"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Expired Coupons</title>
<meta charset="utf-8">
<link type="text/css" rel="stylesheet" href="../views/styles/style.css" />

</head>

<body class="page">
<div id="wrap">
  <div id="header"> 
    
    <div id="nav">
            <ul class="menu">
      <li><a href="../views/adminPanel.jsp">Panel</a></li>
        <li><a href="../views/addCoupon.html">Add coupon</a></li>
        <li><a href="../views/addBusiness.html">Add business</a></li>
        <li><a href="../controller/businesses">Businesses</a></li>
        <li class="current_page_item"><a href="../controller/expiredCoupons">Expired coupons</a></li>
         <li><a href="../controller/logout">logout</a></li>
      </ul>
    </div>
    <!--end nav-->
  </div>
  <!--end header-->

    <div id="porfolio-content">
      
<h2>List of all <span style="color:red;">EXPIRED</span> coupons</h2>            
<% 
Iterator couponsIterator = DAO.getInstance().getAllCoupons();
Coupon coupon;
Date currDate=new Date();
if (couponsIterator!=null)
{
	
while(couponsIterator.hasNext()) {
	coupon=(Coupon)couponsIterator.next();

        String expireDate=coupon.getExpireDate();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
   		Date expDate =  df.parse(expireDate); 
            
   		if ( expDate.before(currDate) 
        		&& ( expDate.getDay()!=currDate.getDay()) ) {  
%>			
<div style="width:600px; display:inline-block; margin: 0 auto;">

<div style="background-color:#B0E0E6;height: 30px;">
<h3 style="margin-bottom:0;">
<% out.print("<a href=\"../views/shoppingcart.jsp?id=" + coupon.getId() +"\">" +(coupon.getName()) +"</a>"); %></h3></div>

<div style="background-color:#EEEEEE;height:180px;width:300px;float:left;">
<img src="../views/<% out.print(coupon.getImage()); %>" width="300"></div>

<div style="background-color:#EEEEEE;height:180px;width:300px;float:right;">
<% out.print(coupon.getDescription()); %></div><br>

<div style="background-color:#B0E0E6;height:20px;width:300px;float:right;">
<% out.print("Expire date: " +(coupon.getExpireDate())); %></div>

<div style="background-color:#B0E0E6;height:20px;width:300px;float:left;">
<% out.print("Price: " + coupon.getPrice()); %></div>

<form action="../controller/updateCouponPreview" method="get">
<input type="hidden" name="updateId" value="<% out.print(coupon.getId());%>">
<input type="submit" value="Update"></form>

<form action="../controller/deleteCoupon" method="get">
<input type="hidden" name="deleteId" value="<% out.print(coupon.getId());%>"><input type="submit" value="Delete"></form>

</div>
		
				
<%
            }

           
	}
} 
%>
        
    </div>
</div>
<!--end wrap-->
</html>
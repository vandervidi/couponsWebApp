<%@page import="com.oa.couponsWebApp.Business"%>
<%@page import="com.oa.couponsWebApp.DAO"%>
<%@page import="com.oa.couponsWebApp.Coupon"%>
<%@ page language="java" contentType="text/html; charset=windows-1255" pageEncoding="windows-1255"%>
<%@ page import="com.oa.couponsWebApp.DAO , java.util.Iterator" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Businesses</title>
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
        <li class="current_page_item"><a href="../controller/businesses">Businesses</a></li>
        <li><a href="../controller/expiredCoupons">Expired coupons</a></li>
         <li><a href="../controller/logout">logout</a></li>
      </ul>
    </div>
    <!--end nav-->

  </div>
  <!--end header-->

    <div id="porfolio-content">
      
<h3>Registered businesses:</h3>            
<%
//Iterator of businesses
	Iterator iterator = DAO.getInstance().getAllBusinesses();
	Object tempOb;
	while(iterator.hasNext()) {
		tempOb=iterator.next();
	
%>		
<div style="width:400px; display:inline-block; margin: 0 auto;">

<div  style="background-color:#B0E0E6;height: 30px;">
<h3 style="margin-bottom:0;"><% out.println(((Business)tempOb).getBusinessName()); %></h3></div>

<div style="background-color:#EEEEEE;height:	180px;width:400px;float:left;">
Business id: <% out.println(((Business)tempOb).getBusinessId()); %><br>
	Location [length]: <% out.println(((Business)tempOb).getLength()); %><br>
	Location [Width]: <% out.println(((Business)tempOb).getWidth()); %><br>
</div>

<form action="../controller/updateBusinessPreview" method="get">
<input type="hidden" name="updateId" value="<% out.print(((Business)tempOb).getBusinessId());%>">
<input type="submit" value="Update"></form>

<form action="../controller/deleteBusiness" method="get">
<input type="hidden" name="deleteId" value="<% out.print(((Business)tempOb).getBusinessId());%>">
<input type="submit" value="Delete"></form>
</div>
		
				
<% } %>
        
    </div>
</div>
<!--end wrap-->
</html>
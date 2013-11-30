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
        <h2>Admin Panel - list of all coupons </h2>
<br>
<div style="color: white; background-color:#151515;text-align: center; margin:0 auto; padding-top: 2px;padding-bottom: 1px;">
        <a href="../views/addCoupon.html">
        <div>ADD COUPON</div></a>
        <a href="../views/addBusiness.html">
        <div>ADD BUSINESS</div></a>
         <a href="../controller/businesses">
        <div>SHOW BUSINESSES</div></a>   
         <a href="../controller/logOut">
        <div>LOG OUT</div></a>      
        </div>


<%

//Iterator of Coupons
        Iterator iterator = DAO.getInstance().getAllCoupons();
        Object tempOb;
        while(iterator.hasNext()) {
                tempOb=iterator.next();
        
%>


<br><br><br><br><br>
<div id="container" style="width:700px">

<div id="header" style="background-color:#FFA500;">
<h1 style="margin-bottom:0;">Coupon name</h1></div>

<div style="background-color:#FFD700;height:200px;width:400px;float:left;">
<img src=<% out.print(((Coupon)tempOb).getImage()); %>width="300"></div>

<div id="content" style="background-color:#EEEEEE;height:200px;width:300px;float:right;">
<% out.print(((Coupon)tempOb).getDescription()); %></div>

<form action="../controller/updateCouponPreview" method="get">
<input type="hidden" name="updateId" value="<% out.print(((Coupon)tempOb).getId());%>">
<input type="submit" value="Update"></form>

<form action="../controller/deleteCoupon" method="get">
<input type="hidden" name="deleteId" value="<% out.print(((Coupon)tempOb).getId());%>">
<input type="submit" value="Delete"></form>
</div>
<br><br>
<br>
<br>
<% } %>
</body>
</html>
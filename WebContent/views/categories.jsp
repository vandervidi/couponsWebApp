<%@ page language="java" contentType="text/html; charset=windows-1255" pageEncoding="windows-1255"%>
<%@ page import="com.oa.couponsWebApp.Coupon , java.util.Iterator" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>WebCouponsApp</title>
<meta charset="utf-8">
<link type="text/css" rel="stylesheet" href="../views/styles/style.css" />

</head>
<body class="page">
<div id="wrap">
  <div id="header"> 
     logo
    <div id="nav">
      <ul class="menu">
        <li ><a href="../controller/">Home</a></li>
        <li ><a href="../controller/help">Help</a></li>
        <li><a href="../controller/about">About</a></li>
        <li><a href="../controller/contact">Contact</a></li>
         <li><a href="../controller/shoppingCart">Cart</a></li>
      </ul>
    </div>
    <!--end nav-->
 
  </div>
  <!--end header-->
    <div id="porfolio-content">
      
<% 
Iterator couponsIterator;
Coupon coupon;
String category= (String)request.getAttribute("categoryName");
couponsIterator = (Iterator)request.getAttribute("couponsIterator");
 if (couponsIterator!=null)
{
	
		while(couponsIterator.hasNext())
		{
			coupon=(Coupon)couponsIterator.next();
			if (coupon.getCategory().equals(category))
			{
				out.println(coupon.toString());
			}
		}
 }
 else
 {
   out.print("<h2>This category is empty!<h2>");
 }

%>
      
    </div>
    <!--portfolio-content-->
  <!--end main-->  
</div>
<!--end wrap-->
<!--end cache-images-->
</html>
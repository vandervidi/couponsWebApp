<%@ page language="java" contentType="text/html; charset=windows-1255" pageEncoding="windows-1255"%>
<%@ page import="com.oa.couponsWebApp.Coupon,java.util.Iterator,java.text.*,java.util.*;" %>
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
Date currDate=new Date();
if (couponsIterator!=null)
{
	
while(couponsIterator.hasNext()) {
	coupon=(Coupon)couponsIterator.next();

        String expireDate=coupon.getExpireDate();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
   		Date expDate =  df.parse(expireDate); 
            if (coupon.getCategory().equals(category))
            {
            	if(( expDate.after(currDate) )
	        			|| ( expDate.getYear()==currDate.getYear()
        				&& expDate.getMonth()==currDate.getMonth()
        				&& expDate.getDay()==currDate.getDay()) ){
%>
				
				<br><br>
<div style="width:600px">

<div style="background-color:#FFA500;height: 30px;">
<h3 style="margin-bottom:0;"><%
out.print("<a href=\"../views/shoppingcart.jsp?id=" + coupon.getId() +"\">" +(coupon.getName()) +"</a>"); %></h3></div>

<div style="background-color:#FFD700;height:200px;width:300px;float:left;">
<img src="../views/<% out.print(coupon.getImage()); %>" width="300"></div>

<div style="background-color:#EEEEEE;height:200px;width:300px;float:right;">
<% out.print(coupon.getDescription()); %></div><br>

<div style="background-color:#EEEEEE;height:20px;width:300px;float:left;">
<% out.print("Price: " + coupon.getPrice()); %></div>

<div style="background-color:#EEEEEE;height:20px;width:300px;float:right;">
<% out.print("Expire date: " +(coupon.getExpireDate())); %></div>
<form action="../controller/updateCouponPreview" method="get">
<input type="hidden" name="updateId" value="<% out.print(coupon.getId());%>">
<input type="submit" value="Update"></form>
</div>
				
				
<%
            }

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
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
<div id="wrap" style=" ">
  <div id="header"> 
<div width="100%" style=" margin: 0 auto; "> 
<a href="../controller/category?category=restaurants"><img src="../views/images/circle-red.png" height="100px"/></a> 
<a href="../controller/category?category=toys"><img src="../views/images/circle-pink.png" height="100px"/></a> 
<a href="../controller/category?category=tickets"><img src="../views/images/circle-orange.png" height="100px"/></a>
<a href="../controller/category?category=sports"><img src="../views/images/circle-yellow.png" height="100px"/></a> 
    
    <div id="nav">
      <ul class="menu">
        <li ><a href="../controller/">Home</a></li>
        <li ><a href="../controller/help">Help</a></li>
        <li><a href="../controller/about">About</a></li>
        <li><a href="../controller/contact">Contact</a></li>
         <li><a href="../controller/shoppingCart">Cart</a></li>
      </ul>
      </div>
    </div>
    <!--end nav-->
  </div>
  <!--end header-->
    <div style=" display: inline-block; margin: 0 auto; ">
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
<br>			
<div style="width:600px" display: inline-block; margin: 0 auto;>

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

</div>
<br><br><br><br><br><br>			
				
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
</div>
<!--end wrap-->
</html>
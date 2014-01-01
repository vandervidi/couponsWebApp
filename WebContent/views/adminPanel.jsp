<%@ page language="java" contentType="text/html; charset=windows-1255" pageEncoding="windows-1255"%>
<%@ page import="com.oa.couponsWebApp.DAO , java.util.Iterator,java.text.* ,java.util.*" %>
<%@page import="com.oa.couponsWebApp.Coupon"%>


<!DOCTYPE html>
<html>
        <head>
                <title>Coupons Web-App</title>
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <link href = "../views/css/bootstrap.min.css" rel = "stylesheet">
                <link href = "../views/css/styles.css" rel = "stylesheet">
        </head>
        <body>
 
                <div class = "navbar navbar-inverse navbar-static-top">
                        <div class = "container">
                               
                                <a href = "#" class = "navbar-brand">Admin Panel</a>
                                <button class = "navbar-toggle" data-toggle = "collapse" data-target = ".navHeaderCollapse">
                                        <span class = "icon-bar"></span>
                                        <span class = "icon-bar"></span>
                                        <span class = "icon-bar"></span>
                                </button>
                               
                                <div class = "collapse navbar-collapse navHeaderCollapse">                              
                                        <ul class = "nav navbar-nav navbar-right">
                                                <li><a href="../views/addCoupon.html">Add coupon</a></li>
												<li><a href="../views/addBusiness.html">Add business</a></li>
												<li><a href="../controller/businesses">Businesses</a></li>
												<li><a href="../controller/expiredCoupons">Expired coupons</a></li>
												<li><a href="../controller/logout">logout</a></li>
                                        </ul>
                               
                                </div>
                               
                        </div>
                </div>


      
<div class="container"><h2>ADMIN PANEL <small> List of up to date coupons</small></h2></div>

<div class="container" style="display:inline;">          
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
            
   		if (( expDate.after(currDate) )
    			|| ( expDate.getYear()==currDate.getYear()
    				&& expDate.getMonth()==currDate.getMonth()
    				&& expDate.getDay()==currDate.getDay()) )
        {   
%>			

<div class="column">
  <div class="col-sm-6 col-md-4">

<div style="background-color:#B0E0E6;width:300px; ">
<% out.print((coupon.getName())); %>  <span class="label label-danger" style="float: right;"><% out.print((coupon.getCategory())); %></span> </div>

<div style="background-color:#EEEEEE;width:300px">
<img src="../views/<% out.print(coupon.getImage()); %>" style="height: auto; width: inherit;"></div>

<div style="background-color:#EEEEEE;height:120px;width:300px;">
<span class="label label-info">Info :</span><% out.print("  "+coupon.getDescription()); %></div>

<div style="background-color:#B0E0E6;height:20px;width:300px;">
<% out.print("Expire date: " +(coupon.getExpireDate())); %></div>

<div style="background-color:#B0E0E6;height:20px;width:300px;">
<% out.print("Price: " + coupon.getPrice()); %></div>

<form action="../controller/updateCouponPreview" method="get">
<input type="hidden" name="updateId" value="<% out.print(coupon.getId());%>">
<input type="submit" value="Update"></form>

<form action="../controller/deleteCoupon" method="get">
<input type="hidden" name="deleteId" value="<% out.print(coupon.getId());%>"><input type="submit" value="Delete"></form>
<br><br>
</div>	
	</div>	
			
<%
            }

           
	}
} 
%>  
  </div>
  
                <script src = "http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
                <script src = "../views/js/bootstrap.js"></script>
               
        </body>
</html>
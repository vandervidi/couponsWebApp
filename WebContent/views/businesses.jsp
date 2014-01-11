<%@page import="com.oa.couponsWebApp.Business"%>
<%@page import="com.oa.couponsWebApp.DAO"%>
<%@page import="com.oa.couponsWebApp.Coupon"%>
<%@ page language="java" contentType="text/html; charset=windows-1255" pageEncoding="windows-1255"%>
<%@ page import="com.oa.couponsWebApp.DAO , java.util.Iterator" %>


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
                                       			 <li><a href="../views/adminPanel.jsp">Panel</a></li>
                                                <li><a href="../views/addCoupon.html">Add coupon</a></li>
												<li><a href="../views/addBusiness.html">Add business</a></li>
												<li class="active"><a href="../controller/businesses">Businesses</a></li>
												<li><a href="../controller/expiredCoupons">Expired coupons</a></li>
												<li><a href="../controller/logout">logout</a></li>
                                        </ul>
                               
                                </div>
                               
                        </div>
                </div>


      
<div class="container"><h2>Businesses <small> List of registered businesses</small></h2></div>

<div class="container" style="display:inline;">          
<%
//Iterator of businesses
	Iterator iterator = DAO.getInstance().getAllBusinesses();
	Object tempOb;
	while(iterator.hasNext()) {
		tempOb=iterator.next();
	
%>			

<div class="column">
  <div class="col-sm-6 col-md-4">

<div style="width:300px; display:inline-block; margin: 0 auto;">

<div  style="background-color:#B0E0E6;height: 30px;">
<h3 style="margin-bottom:0;"><% out.println(((Business)tempOb).getBusinessName()); %></h3></div>

<div style="background-color:#EEEEEE;height:100px;width:300px;float:left;">
Business id: <% out.println(((Business)tempOb).getBusinessId()); %><br>
	Location [length]: <% out.println(((Business)tempOb).getLength()); %><br>
	Location [Width]: <% out.println(((Business)tempOb).getWidth()); %><br>
</div>
<div  style="background-color:#B0E0E6;">
<form action="../controller/updateBusinessPreview" method="get" style="display: inline;">
<input type="hidden" name="updateId" value="<% out.print(((Business)tempOb).getBusinessId());%>">
<button type="submit" class="btn btn-primary btn-sm">Update</button></form>

<form action="../controller/deleteBusiness" method="get" style="display: inline;">
<input type="hidden" name="deleteId" value="<% out.print(((Business)tempOb).getBusinessId());%>">
<button type="submit" class="btn btn-danger btn-sm">Delete</button></form>
</div>
</div>
	</div>
	</div>	
				
<% } %> 
  </div>
  
                <script src = "http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
                <script src = "../views/js/bootstrap.js"></script>
               
        </body>
</html>
<%@ page language="java" contentType="text/html; charset=windows-1255" pageEncoding="windows-1255"%>
<%@ page import="com.oa.couponsWebApp.DAO , com.oa.couponsWebApp.Coupon" %>


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
												<li><a href="../controller/businesses">Businesses</a></li>
												<li><a href="../controller/expiredCoupons">Expired coupons</a></li>
												<li><a href="../controller/logout">logout</a></li>
                                        </ul>
                               
                                </div>
                               
                        </div>
                </div>

<div class="container"><h2>Update coupon</h2></div>
        <%
        		Object ob = request.getAttribute("coupon");
       			System.out.println("Coupon to be updated=:"+ ob);
               
      %>
     <table class="table table-striped">
    <form action="../controller/updateCoupon" method="get">
    <input type="hidden" name="couponId" value="<% out.print(((Coupon)ob).getId()); %>">
    <tr><td>Name: </td><td> <input type=text name="name" value="<% out.print(((Coupon)ob).getName()); %>"></td></tr>
    <tr><td>Price:</td><td> <input type=text name="price" value="<% out.print(((Coupon)ob).getPrice()); %>"></td></tr>
	<tr><td>Image:</td><td> <input type=text name="image" value="<% out.print(((Coupon)ob).getImage()); %>"></td></tr>
	<tr><td>Business id:</td><td> <input type=text name="businessId" value="<% out.print(((Coupon)ob).getBusinessId()); %>"></td></tr>
	<tr><td>Description:</td><td> <textarea name="description"><% out.print(((Coupon)ob).getDescription()); %></textarea> </td></tr>
	<tr><td>Expire date: </td><td><input type="date" name="expDate" value="<% out.print(((Coupon)ob).getExpireDate()); %>"></td></tr>
	<tr><td>Category:</td><td> <select name="category">
	  <option  value="sports" <% if (((Coupon)ob).getCategory().equals("sports")){ out.print("selected"); }%>>Sports</option>
	  <option  value="toys" <% if (((Coupon)ob).getCategory().equals("toys")){ out.print("selected"); }%>>Toys</option>
	  <option  value="restaurants" <% if (((Coupon)ob).getCategory().equals("restaurants")){ out.print("selected"); }%>>Restaurants</option>
	  <option  value="tickets" <% if (((Coupon)ob).getCategory().equals("tickets")){ out.print("selected"); }%>>Tickets</option>
	  </select>
	  </td></tr>
	<tr><td><button type="submit" class="btn btn-success btn-sm">Update</button></td></tr>
	</form>
</table>


                <script src = "http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
                <script src = "../views/js/bootstrap.js"></script>
               
        </body>
</html>
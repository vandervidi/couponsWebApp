<%@ page language="java" contentType="text/html; charset=windows-1255" pageEncoding="windows-1255"%>
<%@ page import="com.oa.couponsWebApp.DAO , com.oa.couponsWebApp.Coupon" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">
<title>Update Coupon</title>
</head>
<body>
        <h2>Update coupon</h2>
        <%
        		Object ob = request.getAttribute("coupon");
       			System.out.println("Coupon to be updated=:"+ ob);
               
      %>
    <form action="../controller/updateCoupon" method="get">
    <input type="hidden" name="couponId" value=<% out.print(((Coupon)ob).getId()); %>>
    Name:  <input type=text name="name" value="<% out.print(((Coupon)ob).getName()); %>"><br>
    Price: <input type=text name="price" value="<% out.print(((Coupon)ob).getPrice()); %>"><br>
	Image: <input type=text name="image" value="<% out.print(((Coupon)ob).getImage()); %>"><br>
	Business id: <input type=text name="businessId" value="<% out.print(((Coupon)ob).getBusinessId()); %>"><br>
	Description: <textarea name="description"><% out.print(((Coupon)ob).getDescription()); %></textarea> <br>
	Expire date: <input type="date" name="expDate" value="<% out.print(((Coupon)ob).getExpireDate()); %>">
	Category: <select>
	  <option name="category" value="sports" <% if (((Coupon)ob).getCategory().equals("sports")){%> selected <%}%>>Sports</option>
	  <option name="category" value="toys" <% if (((Coupon)ob).getCategory().equals("toys")){%> selected <%}%>>Toys</option>
	  <option name="category" value="restaurants" <% if (((Coupon)ob).getCategory().equals("restaurants")){%> selected <%}%>>Restaurants</option>
	  <option name="category" value="tickets" <% if (((Coupon)ob).getCategory().equals("tickests")){%> selected <%}%>>Tickets</option>
	  </select>
	<input type=submit value="Udpate">
	</form>

</body>
</html>
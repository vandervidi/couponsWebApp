<%@ page language="java" contentType="text/html; charset=windows-1255" pageEncoding="windows-1255"%>
<%@ page import="com.oa.couponsWebApp.DAO , com.oa.couponsWebApp.Business" %>


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
<div class="container"><h2>Update business</h2></div>
        <%
        		Object ob = request.getAttribute("business");
       			System.out.println("business to be updated=:"+ ob);
               
         %>
         <table class="table table-stripped">
         		<form action="../controller/updateBusiness" method="get">
         		<input type="hidden" name="businessId" value=<% out.print(((Business)ob).getBusinessId()); %>>
					<tr><td>Business name:     </td><td> <input type="text" name="businessName" value="<% out.print(((Business)ob).getBusinessName()); %>" ></td></tr>
					<tr><td>location [Length]: </td><td><input type="number" name="length" value="<% out.print(((Business)ob).getLength()); %>" min="0"  step="0.01"></td></tr>
					<tr><td>location [Width]:  </td><td><input type="number" name="width" value="<% out.print(((Business)ob).getWidth()); %>" min="0"  step="0.01"></td></tr>
				<tr><td><button type="submit" class="btn btn-success btn-sm">Update</button></td></tr>
				</form>
		</table>


                <script src = "http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
                <script src = "../views/js/bootstrap.js"></script>
               
        </body>
</html>
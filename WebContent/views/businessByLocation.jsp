<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
<%@ page import="java.util.Iterator" %>
<%@ page import="com.oa.couponsWebApp.Business" %>
<%@ page import="com.oa.couponsWebApp.Coupon" %>


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
                               
                                <a href = "../controller/" class = "navbar-brand">Coupons Web-App</a>
                               
                                <button class = "navbar-toggle" data-toggle = "collapse" data-target = ".navHeaderCollapse">
                                        <span class = "icon-bar"></span>
                                        <span class = "icon-bar"></span>
                                        <span class = "icon-bar"></span>
                                </button>
                               
                                <div class = "collapse navbar-collapse navHeaderCollapse">
                               
                                        <ul class = "nav navbar-nav navbar-right">
                                       
                                                <li><a href="../controller/">Home</a></li>
												<li><a href="../controller/help">Help</a></li>
												<li><a href="../controller/about">About</a></li>
												<li><a href="../controller/contact">Contact</a></li>
												<li><a href="../views/shoppingcart.jsp">Cart</a></li>
                                       
                                        </ul>
                               
                                </div>
                               
                        </div>
                </div>

<%
		Double busLength = (Double) request.getAttribute("busLength");
		Double busWidth = (Double) request.getAttribute("busWidth");
		Iterator businessIterator;
		Iterator couponsIterator;
		
		
		businessIterator = (Iterator)request.getAttribute("businessIterator");
		couponsIterator = (Iterator)request.getAttribute("couponsIterator"); 
		
				Business ob =null;
		        while(businessIterator.hasNext()) {
	                ob=(Business)businessIterator.next();
	                if (ob.getLength()==busLength && ob.getWidth()==busWidth){
	                	out.println("<div class=\"container\"><h2>"+ ob.getBusinessName() +" "+"<small> List of coupons</small></h2></div><br>"
	                	+"<table class=\"table table-striped\"><tr><th>Name</th><th>Price</th><th>Description</th><th>Category</th><th>Expire Date</th></tr>");
	                	Coupon c = null;
	    		        while (couponsIterator.hasNext()) {
	    		        	c = (Coupon)couponsIterator.next();
	    		        	if (c.getBusinessId() == ob.getBusinessId())
	    		        		out.print("<tr><td>"+c.getName()+"</td><td>"+c.getPrice()+"</td><td>"+c.getDescription()+"</td><td>"+c.getCategory()+"</td><td>"+c.getExpireDate()+"</td></tr>");
	    		        }
	                }
		        }
	        
%>
</table>


                <script src = "http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
                <script src = "../views/js/bootstrap.js"></script>
               
        </body>
</html>
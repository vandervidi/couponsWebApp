<%@ page language="java" contentType="text/html; charset=windows-1255" pageEncoding="windows-1255"%>
<%@ page import="com.oa.couponsWebApp.Coupon,java.util.Iterator,java.text.*,java.util.*;" %>



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
                                          <li ><a href="../controller/">Home</a></li>
												<li><a href="../controller/help">Help</a></li>
												<li ><a href="../controller/about">About</a></li>
												<li><a href="../controller/contact">Contact</a></li>
												 <li><a href="../views/shoppingcart.jsp">Cart</a></li>
                                        </ul>
                               
                                </div>
                               
                        </div>
                </div>


 <% String category= (String)request.getAttribute("categoryName"); %>    
<div class="container"><h2>Items in <% out.print(category); %> category</h2></div>

<div class="container" style="display:inline;">          
<% 
Iterator couponsIterator;
Coupon coupon;
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

<div class="column">
  <div class="col-sm-6 col-md-4">

<div style="background-color:#B0E0E6;width:300px; ">
<% out.print("<a href=\"../views/shoppingcart.jsp?id=" + coupon.getId() +"\">" +(coupon.getName()) +"</a>"); %></div>

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
} 
else
 {
   out.print("<h2>This category is empty!<h2>");
 }

%> 
  </div>
  
                <script src = "http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
                <script src = "../views/js/bootstrap.js"></script>
               
        </body>
</html>
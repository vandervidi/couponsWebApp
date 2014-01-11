    <%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255" import="com.oa.couponsWebApp.*,java.util.*" %>

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
												<li ><a href="../controller/about">About</a></li>
												<li><a href="../controller/contact">Contact</a></li>
												 <li class = "active"><a href="../views/shoppingcart.jsp">Cart</a></li>
                                       
                                        </ul>
                               
                                </div>
                               
                        </div>
                </div>
<div class="container"><h2>Cart and payment</h2></div>

<%
		double totalPrice=0.00;
		//getting our dao
		DAO dao = DAO.getInstance();

	
		//checking if a shopping cart exists, if not then create one
		IShoppingCart cart = (IShoppingCart)session.getAttribute("cart");
		if(cart==null)
		{
			cart = new BasicShoppingCart();
			session.setAttribute("cart",cart);
		}
	
		//adding the product if id was sent
		String str = request.getParameter("id");
		if(str!=null)
		{
			int id = Integer.parseInt(str);
			cart.addCoupon(dao.getCoupon(id));
		}
		
		//printing out the content of the shopping cart
		out.println("<table class=\"table table-striped table-hover table-responsive\">");
		out.println("<tr>");
		out.println("<th>Coupon name</th><th>quantity</th><th>price</th><th>total</th></tr>");
		Collection<ShoppingCartRow> rows = cart.getShoppingCartRows();
		Iterator<ShoppingCartRow> iterator = rows.iterator();
		while(iterator.hasNext())
		{
			ShoppingCartRow current = iterator.next();
			double price = current.getCoupon().getPrice();
			totalPrice+=price;
			int quantity = current.getQuantity();
			out.println("<tr>");
			out.println("<td>"+current.getCoupon().getName()+"</td>");
			out.println("<td>"+quantity+"</td>");
			out.println("<td>"+price+"</td>");
			out.println("<td>"+(price*quantity)+"</td>");
			out.println("</tr>");
		}
	%>

<nav class="navbar navbar-inverse navbar-fixed-bottom" role="navigation">
<span style="color:white; font-size: 40px" >Total Price: <%out.print(totalPrice); %></span>
<button class="btn btn-success btn-lg" style="float: right;">Checkout!</button>
</nav>
                <script src = "http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
                <script src = "../views/js/bootstrap.js"></script>
               
        </body>
</html>
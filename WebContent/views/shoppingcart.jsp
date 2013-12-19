    <%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255" import="com.oa.couponsWebApp.*,java.util.*" %>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Shopping Cart</title>
<meta charset="utf-8">
<link type="text/css" rel="stylesheet" href="../views/styles/style.css" />

</head>
<body class="page">
<div id="wrap">
  <div id="header"> 
     <div width="100%" style=" margin: 0 auto; "> 
<a href="../controller/category?category=restaurants"><img src="../views/images/circle-red.png" height="100px"/></a> 
<a href="../controller/category?category=toys"><img src="../views/images/circle-pink.png" height="100px"/></a> 
<a href="../controller/category?category=tickets"><img src="../views/images/circle-orange.png" height="100px"/></a>
<a href="../controller/category?category=sports"><img src="../views/images/circle-yellow.png" height="100px"/></a> 
    </div>
    <div id="nav">
      <ul class="menu">
        <li ><a href="../controller/">Home</a></li>
        <li ><a href="../controller/help">Help</a></li>
        <li ><a href="../controller/about">About</a></li>
        <li ><a href="../controller/contact">Contact</a></li>
         <li class="current_page_item"><a href="../views/shoppingcart.jsp">Cart</a></li>
      </ul>
    </div>
    <!--end nav-->

  </div>
  <!--end header-->

  
  <div style=" margin: 0 auto;" >
  
<div width="100%" style=" margin: 0 auto;"> 
<%
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
		out.println("<table>");
		out.println("<tr>");
		out.println("<th>Coupon name</th><th>quantity</th><th>price</th><th>total</th></tr>");
		Collection<ShoppingCartRow> rows = cart.getShoppingCartRows();
		Iterator<ShoppingCartRow> iterator = rows.iterator();
		while(iterator.hasNext())
		{
			ShoppingCartRow current = iterator.next();
			double price = current.getCoupon().getPrice();
			int quantity = current.getQuantity();
			out.println("<tr>");
			out.println("<td>"+current.getCoupon().getName()+"</td>");
			out.println("<td>"+quantity+"</td>");
			out.println("<td>"+price+"</td>");
			out.println("<td>"+(price*quantity)+"</td>");
			out.println("</tr>");
		}
	%>
    </div>
    <div id="porfolio-content">
      
    </div>
    <!--portfolio-content-->
  
  <!--end main-->  
</div>
</div>
<!--end wrap-->
<!--end cache-images-->
</html>
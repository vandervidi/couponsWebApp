<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255" import="com.oa.couponsWebApp.*,java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">
<title>Shopping cart</title>
</head>
<body>
	<h3>Shopping cart</h3>
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
</body>
</html>
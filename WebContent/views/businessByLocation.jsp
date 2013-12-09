<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
<%@ page import="java.util.Iterator" %>
<%@ page import="com.oa.couponsWebApp.Business" %>
<%@ page import="com.oa.couponsWebApp.Coupon" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">
<title>Insert title here</title>
</head>
<body>
<h1>businessByLocation <h1>

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
	                	Coupon c = null;
	    		        while (couponsIterator.hasNext()) {
	    		        	c = (Coupon)couponsIterator.next();
	    		        	if (c.getBusinessId() == ob.getBusinessId())
	    		        		out.print(c+"<br>");
	    		        }
	                }
		        }
		        
		     
		        
%>

</body>
</html>
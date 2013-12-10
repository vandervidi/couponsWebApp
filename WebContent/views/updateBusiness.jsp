<%@ page language="java" contentType="text/html; charset=windows-1255" pageEncoding="windows-1255"%>
<%@ page import="com.oa.couponsWebApp.DAO , com.oa.couponsWebApp.Business" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">
<title>Update Business</title>
</head>
<body>
        <h2>Update business</h2>
        <%
        		Object ob = request.getAttribute("business");
       			System.out.println("business to be updated=:"+ ob);
               
         %>
         		<form action="../controller/updateBusiness" method="get">
         		<input type="hidden" name="businessId" value=<% out.print(((Business)ob).getBusinessId()); %>>
					Business name: <input type="text" name="businessName" value="<% out.print(((Business)ob).getBusinessName()); %>"><br>
					location [Length]: <input type=text name="length" value="<% out.print(((Business)ob).getLength()); %>"><br>
					location [Width]: <input type=text name="width" value="<% out.print(((Business)ob).getWidth()); %>"><br>
				<input type=submit value="Update">
				</form>
				<br><br><a href="../views/businesses.jsp">Go back</a>

</body>
</html>
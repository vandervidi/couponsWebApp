<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
<%@ page import="com.oa.couponsWebApp.DAO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">
<title>Insert title here</title>
</head>
<body>
<%
	String username = request.getParameter("username");
	
	if (DAO.getInstance().getUser(username)!=null)
		out.print("<font color='green'>"+username+" exists</font>");
	else
		out.print("<font color='red'>"+username+" Doesn't exist</font>");
%>
</body>
</html>
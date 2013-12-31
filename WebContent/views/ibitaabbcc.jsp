<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
<%@ page import="com.oa.couponsWebApp.DAO 
		,com.oa.couponsWebApp.MD5
		,com.oa.couponsWebApp.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">
<title>init sql</title>
</head>
<body>
<%
DAO userInstance = DAO.getInstance();
	
		userInstance.addUser(new User("ofir",	MD5.encryptMD5("1") ,1));
		userInstance.addUser(new User("vidran", MD5.encryptMD5("a") ,0));
%>
</body>
</html>
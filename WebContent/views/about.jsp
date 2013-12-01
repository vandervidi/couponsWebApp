<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">
<title>about</title>
</head>
<body>
	<h2>about</h2>
	<br><br><br>
	vidran & ofir<br> 
	java EE - course project<br><br><br>
	<%
	Object ob = request.getAttribute("timestamp");
	out.println(ob);
	%>
</body>
</html>
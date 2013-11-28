<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">
<title>Insert title here</title>
</head>
<body>
	<h2>error</h2>
	<%
	Object number = request.getAttribute("number");
	Object msg = request.getAttribute("msg");
	
	request.setAttribute("timestamp", new java.util.Date());
	Object date = request.getAttribute("timestamp");
	out.println(number+" \n"  +msg+" \n"  +date+" \n");
	%>
</body>
</html>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1255">
<title>Insert title here</title>
</head>
<body>
<%
String username = request.getParameter("username");
out.print("<font color='red'>"+username+" is not exit</font>");
%>
</body>
</html>
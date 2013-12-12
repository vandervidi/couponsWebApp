<%@ page language="java" contentType="text/html; charset=windows-1255" pageEncoding="windows-1255"%>
<%@ page import="javax.servlet.http.Cookie , java.util.Iterator" %>

<!DOCTYPE html>
<html lang="en">
<head>
<title>WebCouponsApp</title>
<meta charset="utf-8">
<link type="text/css" rel="stylesheet" href="../views/styles/style.css" />

</head>
<% 
boolean knownUser=false;
Cookie tmpCookie=null;
Cookie cookies[] = (Cookie[])request.getAttribute("cookies");
if (cookies!=null)
{
        for (Cookie cookie:cookies)
        {
            if (cookie.getName().equals("lastUser"))
             {
                knownUser=true;
               tmpCookie=cookie;
             }
        }
}
%>

<body class="page">
<div id="wrap">
  <div id="header"> 
     logo
    <div id="nav">
      <ul class="menu">
        <li class="current_page_item"><a href="../controller/">Home</a></li>
        <li ><a href="../controller/help">Help</a></li>
        <li><a href="../controller/about">About</a></li>
        <li><a href="../controller/contact">Contact</a></li>
         <li><a href="../views/shoppingcart.jsp">Cart</a></li>
      </ul>
    </div>
    <!--end nav-->


<!-- Login -->

<form method="post" action="../controller/login">
User:<input autocomplete="off" type="text" name="username" size="9">
Pass:<input autocomplete="off" type="password" name="password" size="9">
<input type="hidden" name="login"><input type="submit" value="Log in">   
</form>
<%
if (knownUser==true)
out.print("Last login from this browser by: "+tmpCookie.getValue());
%>
  </div>
  <!--end header-->

  
  <div >
  
<div width="100%" > 
<a href="../controller/category?category=restaurants"><img src="../views/images/circle-red.png" /></a> 
<a href="../controller/category?category=toys"><img src="../views/images/circle-pink.png" /></a> 
<a href="../controller/category?category=tickets"><img src="../views/images/circle-orange.png" /></a>
<a href="../controller/category?category=sports"><img src="../views/images/circle-yellow.png" /></a> 
    </div>
    <div id="porfolio-content">
      
    </div>
    <!--portfolio-content-->
  </div>
  <!--end main-->  
</div>
<!--end wrap-->
<!--end cache-images-->
</html>
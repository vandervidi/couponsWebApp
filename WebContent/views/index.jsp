<%@ page language="java" contentType="text/html; charset=windows-1255" pageEncoding="windows-1255"%>
<%@ page import="javax.servlet.http.Cookie , java.util.Iterator" %>
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

<!DOCTYPE html>
<html>
        <head>
            <title>Coupons Web-Application</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="../views/css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->

        </head>
        <body>
 
                <div class = "navbar navbar-inverse navbar-static-top">
                        <div class = "container">
                               
                                <a href = "../controller/" class = "navbar-brand">Coupons Web-App</a>
                               
                                <button class = "navbar-toggle" data-toggle = "collapse" data-target = ".navHeaderCollapse">
                                        <span class = "icon-bar"></span>
                                        <span class = "icon-bar"></span>
                                        <span class = "icon-bar"></span>
                                </button>
                               
                                <div class = "collapse navbar-collapse navHeaderCollapse">
                               
                                        <ul class = "nav navbar-nav navbar-right">
                                       
                                                <li class = "active"><a href="../controller/">Home</a></li>
												<li><a href="../controller/help">Help</a></li>
												<li ><a href="../controller/about">About</a></li>
												<li><a href="../controller/contact">Contact</a></li>
												 <li><a href="../views/shoppingcart.jsp">Cart</a></li>
                                       
                                        </ul>
                               
                                </div>
                               
                        </div>
                </div>


<div style="text-align: center;"> 
<a href="../controller/category?category=restaurants"><img src="../views/images/circle-red.png"  style="witdh:100px;"/></a> 
<a href="../controller/category?category=toys"><img src="../views/images/circle-pink.png"  style="witdh:100px;"/></a> 
<a href="../controller/category?category=tickets"><img src="../views/images/circle-orange.png" style="witdh:100px;"/></a>
<a href="../controller/category?category=sports"><img src="../views/images/circle-yellow.png" style="witdh:100px;"/></a> 
</div>

<nav class="navbar navbar-inverse navbar-fixed-bottom" role="navigation" style="text-align: center; color:white;">
<form method="post" action="../controller/login">
 User:<input autocomplete="off" type="text" name="username" size="9">
 Pass:<input autocomplete="off" type="password" name="password" size="9">
 <input type="hidden" name="login">
 <button type="submit" class="btn btn-primary">Login</button> 
 </form>


  <%
if (knownUser==true)
out.print("Last login from this browser by: "+tmpCookie.getValue());
%>
</div>
</nav>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://code.jquery.com/jquery.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="../views/js/bootstrap.min.js"></script>   
               
               
        </body>
</html>
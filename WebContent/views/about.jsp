<%@ page language="java" contentType="text/html; charset=windows-1255" pageEncoding="windows-1255"%>
<%@ page import="javax.servlet.http.Cookie , java.util.Iterator" %>


<!DOCTYPE html>
<html>
        <head>
                <title>Coupons Web-App</title>
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <link href = "../views/css/bootstrap.min.css" rel = "stylesheet">
                <link href = "../views/css/styles.css" rel = "stylesheet">
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
                                       
                                                <li ><a href="../controller/">Home</a></li>
												<li><a href="../controller/help">Help</a></li>
												<li class = "active"><a href="../controller/about">About</a></li>
												<li><a href="../controller/contact">Contact</a></li>
												 <li><a href="../views/shoppingcart.jsp">Cart</a></li>
                                       
                                        </ul>
                               
                                </div>
                               
                        </div>
                </div>

About page - Vidran & Ofir javaEE project


                <script src = "http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
                <script src = "../views/js/bootstrap.js"></script>
               
        </body>
</html>
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



	<!-- ajax -->
	    <script type="text/javascript">
		function loadXMLDoc(url)//the parameter url for our resource
		{
		if (window.XMLHttpRequest)
		  {// code for IE7+, Firefox, Chrome, Opera, Safari
		  xmlhttp=new XMLHttpRequest();//creating a new object for ajax
		  }
		else
		  {// code for IE6, IE5
		  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");//creating a new object for ajax
		  }
		xmlhttp.onreadystatechange=function()//Stores a function (or the name of a function) to be called //automatically each time the readyState property changes
		  {
		  if (xmlhttp.readyState==4 && xmlhttp.status==200)//if status is succes and request is processed
		    {
		    document.getElementById('p1').innerHTML=new Date();//getting all response data
		//alert(xmlhttp.getResponseHeader('Content-Type'));//getting specific response data
		//alert(xmlhttp.responseText);
		    }
		  }
		xmlhttp.open("GET",url,true);//it is making a get request with our url asynchronously
		xmlhttp.send();
		}
		</script>
	<!-- ajax -->

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

		<!-- ajax -->
			<p id="p1">  </p>
        	<button onclick="loadXMLDoc('xmlhttp_info.txt')">Get Date</button>
        <!-- ajax -->
        
</div>
</nav>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://code.jquery.com/jquery.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="../views/js/bootstrap.min.js"></script>   
               
               
        </body>
</html>
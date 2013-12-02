<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1255">
<title>Insert title here</title>
</head>
<body>
<div style=" background-color: #2E2E2E;font-family: Arial;
     color:#b6ff00;font-size:15px;padding-bottom: 10px;word-break: normal;width: 400px">
    
<div style="background-color:#b6ff00;width: 400px;color: #000;font-family: Dotum;font-size: 17px;
            padding-left: 3px;padding-top: 1px;padding-bottom: 1px;">LOGIN</div>
<div style="padding-left: 5px;padding-top: 3px;">





<!-- Login -->

<form method="post" action="../controller/login">
<table>
<tr><td>Username:</td>
<td><input autocomplete="off" type="text" name="username" size="20"></td></tr>
<tr><td>Password:</td>
<td><input autocomplete="off" type="password" name="password" size="20"></td>
</tr>
</table>
<input type="hidden" name="login">
<input type="submit" value="Log in">   
<br> 
</form>








<!-- Register -->
<form method="get" action="../controller/register">
<input type="hidden" name="register">
<input type="submit" value="Register">   
<br> 
</form>

</div>
</div>
	<a href="../controller/categories">Coupons-categories</a> <br>
	<a href="../controller/coupons">All-Coupons</a> <br>
	<a href="../controller/coupon">Show coupon By ID</a> <br>
	<a href="../controller/help">Help</a> <br>
	<a href="../controller/contact">Contact Us</a><br>
	<a href="../controller/about">About</a>
</body>
</html>
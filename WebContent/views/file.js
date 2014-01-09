function check_username(username)
		{
			// Create variable
			if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
				xmlhttp = new XMLHttpRequest();//creating a new object for ajax
			} else {// code for IE6, IE5
				xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");//creating a new object for ajax
			}
			
			xmlhttp.abort();
			//-----2 options---------------------------------------------------------------
			xmlhttp.open("GET","../views/showUsername.jsp?username="+username, true);		// Working
			//xmlhttp.open("GET", "../controller/showUsername?username="+username, true);		// Working (if uncomment this, uncomment from controller "/showUsername" too)
			//-----------------------------------------------------------------------------
			xmlhttp.onreadystatechange= function()
			{
				if (xmlhttp.readyState == 4) 
				{
					document.getElementById('msg').innerHTML =
						xmlhttp.responseText;
				}
			};
			xmlhttp.send(null);
		} 
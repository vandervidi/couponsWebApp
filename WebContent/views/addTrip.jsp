<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">
<title>Add Trip</title>
</head>
<body>
<h1>Add Trip:</h1><br><br>
        <form action="../controller/create" method="get">
			Trip name: <input type="text" name="tripName"><br>
			Start date: <input type="text" name="startDate"><br>
			End date: <input type="text" name="endDate"><br>
			Rate per traveler: <input type="text" name="ratePerTraveler"><br>
			Number Of Travelers:<input type="text" name="numOfTravelers"><br>
			<input type="submit" value="Submit">
        </form>
</body>
</html>
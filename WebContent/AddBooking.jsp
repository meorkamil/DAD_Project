<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!--  Muhammad Adib Bin Noor Hazuki -->
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Booking</title>
</head>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />
 
  <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
 
  <script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
<body>
<h1>Customer Booking</h1>
<form method="post" action="AddBookingServlet">
Name:
<input type="text" name="CustomerName">
<br>
Tel No:
<input type="text" name="TelNo">
<br>
Address:
<textarea name="Address"></textarea>
<br>
Date Start:
<input type="date" name="DateStart">
<br>
Date End:
<input type="date" name="DateEnd">
<input type="submit" value="Submit">
</form>
	<br>
		<a href="index.html">Back</a>
</body>
</html>

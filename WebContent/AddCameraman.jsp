<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
 <!-- Muhammad Adib Bin Noor Hazuki -->   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Cameraman</title>
</head>
<body>
<h1>Add Cameraman</h1>
<form method="post" action="AddCameramanServlet">
		Name:
		<input type="text" name="Name"><br>
		Rate:
		<input type="text" name="Rate" ><br>
		
		<input type="submit" value="Submit">
	</form>
	<br>
		<a href="CameramanListServlet">Back</a>
</body>
</html>
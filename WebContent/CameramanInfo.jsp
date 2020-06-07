<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="controller.project2.com.Cameraman"%>

<!--  Muhammad Adib Bin Noor Hazuki -->

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cameraman Info</title>
</head>
<body>
	<%
		Cameraman cameraman = (Cameraman) request.getAttribute("cameraman");
	%>
	<h1>Update Cameraman</h1>
	<form method="post" action="UpdateCameramanServlet">
		Cameraman No:
		<input type="text" value="<%= cameraman.getCameramanNo() %>" disabled><br>
		<input type="hidden" name="CameramanNo" value="<%= cameraman.getCameramanNo() %>">
		Name:
		<input type="text" name="Name" value="<%= cameraman.getName() %>"><br>
		Price:
		<input type="text" name="Rate"  value="<%= cameraman.getRate() %>"><br>
		
		<input type="submit" value="Submit">
	</form>
		<br>
		<a href="CameramanListServlet">Back</a>
</body>
</html>
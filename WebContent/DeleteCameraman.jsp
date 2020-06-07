<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ page import="controller.project2.com.Cameraman"%>
  
 <!-- Muhammad Adib Bin Noor Hazuki -->
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Cameraman</title>
</head>
<body>
	<%
		Cameraman cameraman = (Cameraman) request.getAttribute("cameraman");
	%>
	<h3>Confirm to delete Cameraman?</h3>
	<form method="post" action="DeleteCameramanServlet">
		Product Code:
		<input type="number" value="<%= cameraman.getCameramanNo() %>" disabled><br>
		<input type="hidden" name="cameramanNo" value="<%= cameraman.getCameramanNo() %>">
		Name:
		<input type="text" value="<%= cameraman.getName() %>" disabled><br>
		<input type="hidden" name="Name" value="<%= cameraman.getName() %>">
		Price:
		<input type="number" step=".01" value="<%= cameraman.getRate() %>" disabled><br>
		<input type="hidden" name="Rate" step=".01" value="<%= cameraman.getRate() %>">
	
		<input type="submit" value="Yes">
	</form>
		<br>
		<a href="CameramanListServlet">Back</a>
</body>
</html>
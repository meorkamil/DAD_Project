<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="controller.project2.com.Cameraman"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>

<!-- Muhammad Adib Bin Noor Hazuki -->

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cameramans List</title>
</head>
<body>
	<%
		@SuppressWarnings ("unchecked")
		List<Cameraman> cameramans =  (ArrayList<Cameraman>) request.getAttribute("cameramans");
		String result =  (String)request.getAttribute("result");
		
	
	%>
	
	<div align="center">
	
	<table border="1" cellpadding="5">
	
                 <h1>Cameraman List</h1>
                 	<h2><% out.print(result); %></h2>
                 		<a href="AddCameraman.jsp">Add Cameraman</a>
                 		<br>
            <tr>
                <th>No</th>
                <th>Name</th>
                <th>Price</th>
                 <th>Action</th>
       </tr>
       
            <%
            for (Cameraman cameraman : cameramans) {
    			out.print("<tr><td>"+cameraman.getCameramanNo()+"</td><td>" + cameraman.getName() + "</td><td>RM "+ cameraman.getRate() +" </td><td><a href='DisplayCameramanServlet?cameramanNo="+cameraman.getCameramanNo()+ "'>Edit</a> | <a href='DeleteConfirmationServlet?cameramanNo="+cameraman.getCameramanNo()+"'>Delete</a></td></tr>");
    		}
            %>

	</table>
<br>
<a href="BookingListServlet">Booking List</a>
<br>
	<a href="index.html">Home</a><br>
	
	</div>
</body>
</html>
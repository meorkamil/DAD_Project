<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="controller.project2.com.Booking"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>

<!-- Muhammad Adib Bin Noor Hazuki  -->

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search</title>
</head>
<body>

	<%
		@SuppressWarnings ("unchecked")
		List<Booking> bookings =  (ArrayList<Booking>) request.getAttribute("bookings");
		String result =  (String)request.getAttribute("result");
		
	
	%>
	<div align="center">
	 <h1>Booking List</h1>
                 	<h2><% out.print(result); %></h2>
	<form action="SearchBookingServlet" method="post">
	Search By Customer Name:<br>
	<input type="text" name="CustomerName" >
	<br>
	<input type="submit" value="Search" >
	<br>
	<br>
	</form>
	<table border="1" cellpadding="5">
	
                
            <tr>
            
                <th>Customer Name</th>
                <th>Cameraman Name</th>
                <th>Price</th>
                <th>Date</th>
          
       </tr>
       
            <%
            for (Booking booking : bookings) {
    			out.print("<tr><td>"+booking.getName()+"</td><td>" + booking.getCameramanName() + "</td><td>RM "+ booking.getTotalPrice() +" </td><td>"+booking.getDateStart()+ " - "+booking.getDateEnd()+ "</td></tr>");
    		}
            %>

	</table>
<br>
	<a href="CameramanListServlet">Back</a>
	<br>
	<a href="index.html">Home</a>
	</div>
	
</body>
</html>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Details of Car</title>
</head>
<body>
	<% ResultSet rs = (ResultSet)  request.getAttribute("carList"); %>

	<table border="">
		<tr>
			<th>CarId</th>
			<th>CarModle</th>
			<th>CarBrand</th>
			<th>CarPrice</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>

		<% while(rs.next()){ %>
		<tr>
			<td><%= rs.getInt(1) %></td>
			<td><%= rs.getString(2) %></td>
			<td><%= rs.getString(3) %></td>
			<td><%= rs.getInt(4) %></td>
			<td><a href="updateCar?carId=<%=rs.getInt(1)%>">UPDATE</a></td>
			<td><a href="deleteCar?carId=<%=rs.getInt(1)%>">DELETE</a></td>
		</tr>

		<%} %>

	</table>
	
	<h2>
	<a href="index.jsp"> Go back to Car Dashboard</a>
	</h2>

</body>
</html>
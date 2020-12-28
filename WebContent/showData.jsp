<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="#972378">
	<%@ page import="website.JavaDatabase, website.User, java.util.*" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<h1 align="center"><b>User List</b></h1>
	<%
		ArrayList<User> list = JavaDatabase.showData();
		request.setAttribute("list",list);
	%>
	<table width="60%" align="center">
		<tr>
			<th align="center">Id</th>
			<th align="center">Name</th>
			<th align="center">Email</th>
			<th align="center">Sex</th>
			<th align="center">Country</th>
		</tr>
		<c:forEach var="i" items="${list}">
			<tr>
				<td align="center">${i.getId() }</td>
				<td align="center">${i.getName() }</td>
				<td align="center">${i.getEmail() }</td>
				<td align="center">${i.getSex() }</td>
				<td align="center">${i.getCountry() }</td>
				<!--  <td align="center"><a href="EditData.jsp?id=${i }">Edit</a></td>-->
				<!-- <td align="center"><a href="DeleteData.jsp?id=${i.getId() }">Delete</a></td>-->
			</tr>
		</c:forEach>
	</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ page import="website.sqlCommand, website.User, java.util.*" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%//script tag
		String rm = request.getParameter("sqlCommond");
		String t = request.getParameter("table");
		String q = request.getParameter("query");
		ArrayList[] list;
		System.out.println(t+" = "+q);
		String result = "";
		if(t != null){
			result = sqlCommand.CreateDropData(rm);
			request.setAttribute("result",result);
		}else{
			list = sqlCommand.showData(rm);
			request.setAttribute("list",list);
		}
	%>
	<c:out value="${result}">Result</c:out>
	<table width="60%" align="center">
		<tr>
			<c:forEach var="i" items="${list[0]}">
				<th align="center">${i}</th>
			</c:forEach>
		</tr>
		<c:forEach var="i" items="${list[1]}">
			<tr>
			<td align="center">${i.getId() }</td>
			<td align="center">${i.getName() }</td>
			<td align="center">${i.getStstd()}</td>
			<td align="center">${i.getEmail() }</td>
			<td align="center">${i.getSex() }</td>
			<td align="center">${i.getCountry() }</td>
			<td align="center"><a href="EditData.jsp?id=${i }">Edit</a></td>
			<td align="center"><a href="DeleteData.jsp?id=${i.getId() }">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
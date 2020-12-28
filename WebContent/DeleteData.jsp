<%@ page import="website.JavaDatabase"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>	
	<jsp:useBean id="u" class="website.User"></jsp:useBean>
	<jsp:setProperty property="*" name="u"/>
	<%
		boolean status = JavaDatabase.deleteData(u.getId());
		response.sendRedirect("HomePage.jsp");
	%>
</body>
</html>
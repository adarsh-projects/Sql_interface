<%@ page import="website.JavaDatabase"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
</head>
<body bgcolor="#abcd27">
	<jsp:useBean id="u" class="website.User"></jsp:useBean>
	<jsp:setProperty property="*" name="u"></jsp:setProperty>
	<% 
		//After completing open the comment to save user register data
		/* boolean status = JavaDatabase.saveData(u);
		if(status){
			   out.println("<script type=\"text/javascript\">");
			   out.println("alert('Successfully data is uploaded');");
			   out.println("</script>");
		}else{
			   out.println("<script type=\"text/javascript\">");
			   out.println("alert('Data isn't uploaded, please try again');");
			   out.println("</script>");
		} */
	%>
	<div align="center" margin="20px">
		<h1>Hello, Admin</h1>
		<div align="center">
			<a href="SQlEditor.html" target="_blank"><img src="sql.png"/></a>
		</div>
		<div align="center" >
			<a href="showData.jsp" target="_blank"><img src="database.png"/></a>
		</div>
	</div>
</body>
</html>
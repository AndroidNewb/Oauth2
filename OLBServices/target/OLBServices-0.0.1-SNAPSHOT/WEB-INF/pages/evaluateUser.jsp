<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Evaluate User</title>
</head>
<body>
	<%
		String userType = (String) request.getHeader("OLBTYPE");
		String userName = (String) request.getHeader("USERNAME");

		request.getSession().setAttribute("olbuser", userName);
		
		if (userType != null && userType.equalsIgnoreCase("admin"))
			response.sendRedirect("http://localhost:9000/ui/searchuser");
		else if (userType != null)
			response.sendRedirect("http://localhost:9000/ui/home");
		else
			out.print("usertype is " + userType);
		
		
		
	%>
	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>

<form action="/action_page.php">
  Username:<br>
  <input type="text" name="username" id="username" >
  <br>
  Password:<br>
  <input type="password" name="password" id="password" >
  <br><br>
  <input type="hidden" id="request_id" name="request_id" value=<% out.print(request.getParameter("request_id"));%>/>
  
  <input type="submit" value="Submit">
</form> 
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="/resources/style.css" >
<title>Search User</title>
</head>
<body>
<ul>
  <li><a  class="active" href="http://localhost:9000/ui/searchuser">Search User</a></li>
  <li><a  href="http://localhost:9000/ui/createuser">Create User</a></li>
  <li><a href="http://localhost:9000/ui/transfermoney">Create Branch</a></li>
  <li><a href="#about">Logout</a></li>
</ul>
Search by username or account number 
<br>
	<form method="post" action="http://localhost:9000/api/searchUserfromDB">
		<table border="0">
			<tr>
				<td>Username</td>
				<td><input type="text" name="username" size="25"></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="Submit" name="submitButton"></td>

			</tr>
		</table>
	</form>
</body>
</html>
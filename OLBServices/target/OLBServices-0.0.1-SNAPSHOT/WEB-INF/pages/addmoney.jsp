<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>add Money</title>
<link rel="stylesheet" href="/resources/style.css" >
</head>
<body>

<ul>
  <li><a  href="http://localhost:9000/home">Home</a></li>
  <li><a class="active" href="http://localhost:9000/addmoney">Add Money</a></li>
  <li><a href="http://localhost:9000/transfermoney">Transfer Money</a></li>
  <li><a href="#about">Logout</a></li>
</ul>
	<h3>
		<%
			HttpSession httpSession = request.getSession();
			out.print(httpSession.getAttribute("olbuser"));
		%>
	</h3>

	<form method="post" action="http://localhost:5556/addmoneypersist">
		<table border="0">
			<tr>
				<td>Username</td>
				<td><input type="text" name="username" size="25" value=<%out.print(httpSession.getAttribute("olbuser")); %> readonly="readonly"></td>
			</tr>
			<tr>
				<td>Account No</td>
				<td><input type="text" name="accountNo" size="25" value=<%out.print(httpSession.getAttribute("accountno")); %> readonly="readonly"></td>
			</tr>
			<tr>
				<td>Amount</td>
				<td><input type="text" name="amount" size="25"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit" name="submitButton"></td>

			</tr>
		</table>
	</form>
</body>
</html>
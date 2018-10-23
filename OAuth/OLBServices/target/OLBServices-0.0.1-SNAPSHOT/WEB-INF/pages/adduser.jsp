<%@page import="olbservices.services.GeneralServices"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add User</title>
</head>
<body>


	<form method="post" action="http://localhost:5556/persistuser">
		<table border="0">
			<tr>
				<td>Username</td>
				<td><input type="text" name="username" size="25"></td>
			</tr>
			<tr>
				<td>PAN</td>
				<td><input type="text" name="pan" size="25"></td>
			</tr>
			<tr>
				<td>First name</td>
				<td><input type="text" name="fn" size="25"></td>
			</tr>
			<tr>
				<td>Last name</td>
				<td><input type="text" name="ln" size="25"></td>
			</tr>
			<tr>
				<td>Email ID</td>
				<td><input type="text" name="email" size="25"></td>
			</tr>
			<tr>
				<td>Phone No</td>
				<td><input type="text" name="phone" size="25"></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><input type="text" name="address" size="25"></td>
			</tr>
			<tr>
				<td>Deposit</td>
				<td><input type="text" name="deposit" size="25"></td>
			</tr>
			<tr>
				<td>Branch</td>
				<td><input type="text" name="branch" size="25"></td>
			</tr>
		</table>
		<p>
			<input type="submit" value="Submit" name="b1">
		</p>
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All users</title>
</head>
<body>
	<c:if test="${not empty olbusers}">
		<c:forEach var="olbuser" items="${olbusers}">
			<table border="1" cellpadding="5">

				<tr>
					<td>PAN</td>
					<td><c:out value="${olbuser.PAN}" /></td>
				</tr>
				<tr>
					<td>Username</td>
					<td><c:out value="${olbuser.username}" /></td>
				</tr>
				<tr>
					<td>First name</td>
					<td><c:out value="${olbuser.firstName}" /></td>
				</tr>
				<tr>
					<td>Last name</td>
					<td><c:out value="${olbuser.lastName}" /></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><c:out value="${olbuser.email}" /></td>
				</tr>
				<tr>
					<td>Phone no</td>
					<td><c:out value="${olbuser.phoneNo}" /></td>
				</tr>
				<tr>
					<td>Address</td>
					<td><c:out value="${olbuser.address}" /></td>
				</tr>
			</table>
			<hr>
		</c:forEach>



	</c:if>
</body>
</html>
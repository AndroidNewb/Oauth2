<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" href="/resources/style.css" >
</head>
<body>

<ul>
  <li><a class="active" href="http://localhost:9000/home">Home</a></li>
  <li><a href="http://localhost:9000/addmoney">Add Money</a></li>
  <li><a href="http://localhost:9000/transfermoney">Transfer Money</a></li>
  <li><a href="#about">Logout</a></li>
</ul>
<br>
<br>
	<c:if test="${not empty user}">

		<table border="1" cellpadding="5">

			<tr>
				<td>PAN</td>
				<td><c:out value="${user.PAN}" /></td>
			</tr>
			<tr>
				<td>Username</td>
				<td><c:out value="${user.username}" /></td>
			</tr>
			<tr>
				<td>First name</td>
				<td><c:out value="${user.firstName}" /></td>
			</tr>
			<tr>
				<td>Last name</td>
				<td><c:out value="${user.lastName}" /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><c:out value="${user.email}" /></td>
			</tr>
			<tr>
				<td>Phone no</td>
				<td><c:out value="${user.phoneNo}" /></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><c:out value="${user.address}" /></td>
			</tr>

		</table>
		<hr>
	</c:if>


	<c:if test="${not empty account}">

		<table border="1" cellpadding="5">
			<tr>
				<td>Account no</td>
				<td><c:out value="${account.savingsAccountNumber}" /></td>
			</tr>
			<tr>
				<td>Balance</td>
				<td><c:out value="${account.savingsAvailableBalance}" /></td>
			</tr>
		</table>
	</c:if>
	<hr>
	<c:if test="${not empty branch}">

		<table border="1" cellpadding="5">
			<tr>
				<td>IFSC</td>
				<td><c:out value="${branch.ifsc}" /></td>
			</tr>
			<tr>
				<td>Location</td>
				<td><c:out value="${branch.branchLocation}" /></td>
			</tr>
			<tr>
				<td>City</td>
				<td><c:out value="${branch.branchCity}" /></td>
			</tr>
			<tr>
				<td>State</td>
				<td><c:out value="${branch.branchState}" /></td>
			</tr>
		</table>
	</c:if>
	<hr>
	<c:if test="${not empty transactions}">


		<table border="1" cellpadding="5">
		<tr>
		<th>Transaction ID</th>
		<th>From Account</th>
		<th>To Account</th>
		<th>Amount</th>
			<c:forEach items="${transactions}" var="transaction">
				<tr>
					<td><c:out value="${transaction.transactionID}" /></td>
					<td><c:out value="${transaction.fromAccount}" /></td>
					<td><c:out value="${transaction.toAccount}" /></td>
					<td><c:out value="${transaction.amount}" /></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>
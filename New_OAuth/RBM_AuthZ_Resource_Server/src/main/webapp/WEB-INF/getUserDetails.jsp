<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>User bank details</title>
</head>
<body>


<c:if test="${not empty user}">

		<table border="1" cellpadding="5">

			<tr>
				<th>Username</th>
				<td><c:out value="${user.username}" /></td>
			</tr>
			<tr>
				<th>Account Number</th>
				<td><c:out value="${user.accountNo}" /></td>
			</tr>
			<tr>
				<th>Available Balance</th>
				<td><c:out value="${user.balance}" /></td>
			</tr>
	
		</table>
		<hr>
	</c:if>


	<hr>
	<c:if test="${not empty user}">


		<table border="1" cellpadding="5">
		<tr>
		<th>Transaction ID</th>
		<th>Time</th>
		<th>From Account</th>
		<th>To Account</th>
		<th>Amount</th>
			<c:forEach items="${user.transactions}" var="transaction">
				<tr>
					<td><c:out value="${transaction.transactionID}" /></td>
					<td><c:out value="${transaction.transactionTime}" /></td>
					<td><c:out value="${transaction.fromAccount}" /></td>
					<td><c:out value="${transaction.toAccount}" /></td>
					<td><c:out value="${transaction.amount}" /></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>
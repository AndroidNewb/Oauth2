<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page session="false"%>
<html>
<head>
<title>User information</title>
</head>
<body>

		<c:if test="${not empty user}">

		<table border="1" cellpadding="5">

			
			<tr>
				<th>Username</th>
				<td><c:out value="${user.username}" /></td>
			</tr>
		
			<tr>
				<th>Account No</th>
				<td><c:out value="${user.accountNo}" /></td>
			</tr>
			<tr>
				<th>Balance</th>
				<td><c:out value="${user.balance}" /></td>
			</tr>
			

		</table>
		<hr>
	</c:if>

	<c:if test="${not empty user.transactions}">


		<table border="1" cellpadding="5">
			<tr>
				<th>Transaction ID</th>
				<th>Time</th>
				<th>From Account</th>
				<th>To Account</th>
				<th>Amount</th>
			</tr>
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
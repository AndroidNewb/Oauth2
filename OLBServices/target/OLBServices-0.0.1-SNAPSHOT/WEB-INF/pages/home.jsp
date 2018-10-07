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

<%
String runningENV=System.getenv("ENV");

if (runningENV.equalsIgnoreCase("dev"))
{	
%>
<ul>
  <li><a class="active" href="http://localhost:9000/ui/home/<%out.print(request.getSession().getAttribute("olbuser")); %>">Home</a></li>
  <li><a  href="http://localhost:9000/ui/creditmoney">Credit Money</a></li>
  <li><a  href="http://localhost:9000/ui/transfermoney">Transfer Money</a></li>
  <li><a href="#about">Logout</a></li>
</ul>
<%
}
else if(runningENV.equalsIgnoreCase("prod"))
{
%>
<ul>
  <li><a  class="active" href="http://localhost:7777/ui/home/<%out.print(request.getSession().getAttribute("olbuser")); %>">Home</a></li>
  <li><a href="http://localhost:7777/ui/creditmoney">Credit Money</a></li>
  <li><a  href="http://localhost:7777/ui/transfermoney">Transfer Money</a></li>
  <li><a href="#about">Logout</a></li>
</ul>
<%
}
%>
<br>
<br>
<h3>Hi <%out.print(request.getSession().getAttribute("olbuser"));%>, welcome home</h3>
<br>

	<c:if test="${not empty user}">

		<table border="1" cellpadding="5">

			<tr>
				<th>PAN</th>
				<td><c:out value="${user.PAN}" /></td>
			</tr>
			<tr>
				<th>Username</th>
				<td><c:out value="${user.username}" /></td>
			</tr>
			<tr>
				<th>First name</th>
				<td><c:out value="${user.firstName}" /></td>
			</tr>
			<tr>
				<th>Last name</th>
				<td><c:out value="${user.lastName}" /></td>
			</tr>
			<tr>
				<th>Email</th>
				<td><c:out value="${user.email}" /></td>
			</tr>
			<tr>
				<th>Phone no</th>
				<td><c:out value="${user.phoneNo}" /></td>
			</tr>
			<tr>
				<th>Address</th>
				<td><c:out value="${user.address}" /></td>
			</tr>

		</table>
		<hr>
	</c:if>


	<c:if test="${not empty account}">

		<table border="1" cellpadding="5">
			<tr>
				<th>Account no</th>
				<td><c:out value="${account.savingsAccountNumber}" /></td>
			</tr>
			<tr>
				<th>Balance</td>
				<td><c:out value="${account.savingsAvailableBalance}" /></td>
			</tr>
		</table>
	</c:if>
	<hr>
	<c:if test="${not empty branch}">

		<table border="1" cellpadding="5">
			<tr>
				<th>IFSC</th>
				<td><c:out value="${branch.ifsc}" /></td>
			</tr>
			<tr>
				<th>Location</th>
				<td><c:out value="${branch.branchLocation}" /></td>
			</tr>
			<tr>
				<th>City</th>
				<td><c:out value="${branch.branchCity}" /></td>
			</tr>
			<tr>
				<th>State</th>
				<td><c:out value="${branch.branchState}" /></td>
			</tr>
		</table>
	</c:if>
	<hr>
	<c:if test="${not empty transactions}">


		<table border="1" cellpadding="5">
		<tr>
		<th>Transaction ID</th>
		<th>Time</th>
		<th>From Account</th>
		<th>To Account</th>
		<th>Amount</th>
			<c:forEach items="${transactions}" var="transaction">
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
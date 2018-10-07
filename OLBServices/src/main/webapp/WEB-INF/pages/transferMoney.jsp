<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transfer money</title>
<link rel="stylesheet" href="/resources/style.css" >
</head>
<body>

<%
String runningENV=System.getenv("ENV");

if (runningENV.equalsIgnoreCase("dev"))
{	
%>
<ul>
  <li><a  href="http://localhost:9000/ui/home/<%out.print(request.getSession().getAttribute("olbuser")); %>">Home</a></li>
  <li><a  href="http://localhost:9000/ui/creditmoney">Credit Money</a></li>
  <li><a class="active"  href="http://localhost:9000/ui/transfermoney">Transfer Money</a></li>
  <li><a href="#about">Logout</a></li>
</ul>
<%
}
else if(runningENV.equalsIgnoreCase("prod"))
{
%>
<ul>
  <li><a  href="http://localhost:7777/ui/home/<%out.print(request.getSession().getAttribute("olbuser")); %>">Home</a></li>
  <li><a href="http://localhost:7777/ui/creditmoney">Credit Money</a></li>
  <li><a class="active" href="http://localhost:7777/ui/transfermoney">Transfer Money</a></li>
  <li><a href="#about">Logout</a></li>
</ul>
<%
}
%>
	<%
		HttpSession httpSession = request.getSession();
		String port="";
		if (runningENV.equalsIgnoreCase("dev"))
			port="9000";
		else if (runningENV.equalsIgnoreCase("prod"))
			port="7777";
	%>
	<form method="post" action="http://localhost:<%out.print(port); %>/api/saveTransaction">
		<table border="0">
			<tr>
				<td>From Account No</td>
				<td><input type="text" name="accountNo" size="25"
					value=<%out.print(httpSession.getAttribute("accountno"));%> readonly="readonly"></td>
			</tr>
			<tr>
				<td>To Account No</td>
				<td><input type="text" name="toAccountNo" size="25"></td>
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
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transfer money</title>
</head>
<body>
	<%
		HttpSession httpSession = request.getSession();
	%>
	<form method="post" action="http://localhost:5556/saveTransaction">
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
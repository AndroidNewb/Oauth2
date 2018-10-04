<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Branch</title>
</head>
<body>
<form method="post" action="http://localhost:5556/persistnewbranch">
		<table border="0">
			<tr>
				<td>Branch location</td>
				<td><input type="text" name="branchLocation" size="35" ></td>
			</tr>
			<tr>
				<td>Branch City</td>
				<td><input type="text" name="branchCity" size="25" ></td>
			</tr>
				<tr>
				<td>Branch PIN</td>
				<td><input type="text" name="branchPIN" size="6" ></td>
			</tr>
			<tr>
				<td>Branch State</td>
				<td><input type="text" name="branchState" size="25"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit" name="submitButton"></td>

			</tr>
		</table>
	</form>
</body>
</html>
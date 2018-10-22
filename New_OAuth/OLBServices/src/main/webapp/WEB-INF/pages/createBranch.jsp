<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Branch</title>
<link rel="stylesheet" href="/resources/style.css" >
<link rel="stylesheet" href="/resources/css/bootstrap.min.css" >
</head>
<body>
<div name="logo" id="name" style="background-color:#333; padding-top:5px;">
<img src="/resources/logo-bar.png" width=70% height=40% > 
</div>
<%
String runningENV=System.getenv("ENV");

if (runningENV.equalsIgnoreCase("dev"))
{	
%>
<ul>
  <li><a  href="http://localhost:9000/ui/searchuser">Search User</a></li>
  <li><a  href="http://localhost:9000/ui/createuser">Create User</a></li>
  <li><a class="active" href="http://localhost:9000/ui/createbranch">Create Branch</a></li>
  <li><a href="#about">Logout</a></li>
</ul>
<%
}
else if(runningENV.equalsIgnoreCase("prod"))
{
%>
<ul>
  <li><a  href="http://localhost:7777/ui/searchuser">Search User</a></li>
  <li><a  href="http://localhost:7777/ui/createuser">Create User</a></li>
  <li><a class="active" href="http://localhost:7777/ui/createbranch">Create Branch</a></li>
  <li><a href="#about">Logout</a></li>
</ul>
<%
}
%>
<br>
<br>
<%
String port="";
if (runningENV.equalsIgnoreCase("dev"))
	port="9000";
else if (runningENV.equalsIgnoreCase("prod"))
	port="7777";
%>
<form method="post" action="http://localhost:<%out.print(port); %>/api/saveNewBranch">
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
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AddEntry</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
<script>
	$(function() {
		$("#shiftDate").datepicker();
	});
</script>

</head>
<body>


	<form id="newEntry" action="/api/saveEntry" method="POST">
		<table border="2">
			<tr>
				<td>Date: </td>
				<td><input type="text" id="shiftDate"></td> 
				
			</tr>
			<tr>
				<td>Current Shift: </td>
				<td><select id="currentShift">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
				</select>
				</td>
			</tr>
			<tr>
				<td>Next Shift: </td>
				<td><select id="nextShift">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
				</select></td>
			</tr>
			<tr>
				<td> Completed tasks: </td>
				<td><textarea id="completedTasks"
						rows="7" cols="70">
</textarea></td>
			</tr>
			<tr>
				<td> In Progress tasks: </td>
				<td><textarea id="inProgressTasks"
						rows="7" cols="70">
</textarea> </td>
			</tr>
			<tr>
				<td> Issues encountered: </td>
				<td><textarea id="issues"
						rows="7" cols="70">
</textarea> </td>
			</tr>
			<tr>
				<td> Changes: </td>
				<td><textarea id="changes" rows="7"
						cols="70">
</textarea></td>
			</tr>
			<tr>
				<td> Handover By: </td>
				<td><select id="handover_By">
						<option value="vamshika">Vamshika</option>
						<option value="Vineet">Vineet</option>
						<option value="Aswin">Aswin</option>
						<option value="Amit_Kumar">Amit_Kumar</option>
						<option value="Lydia">Lydia</option>

				</select></td>
			</tr>
			<tr>
				<td> Handover To: </td>
				<td><select id="handover_To">
						<option value="vamshika">Vamshika</option>
						<option value="Vineet">Vineet</option>
						<option value="Aswin">Aswin</option>
						<option value="Amit_Kumar">Amit_Kumar</option>
						<option value="Lydia">Lydia</option>

				</select> </td>
			</tr>
			<tr>
				<td> <input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="/resources/css/bootstrap.min.css" >
</head>
<body>


	<table>
		<tr>
			<td style="width: 40%; height: 100%"><img src="/resources/logo.png"
				style="margin-top: 70px; margin-left: 50px;"></td>
			<td style="width: 50%;">

				<form class="form-signin" style="padding: 60px;" action="http://"
					method="post">
					<h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
					<div class="mb-3">
						<input type="text" class="form-control" id="firstName"
							placeholder="Username" value="" required>
						<div class="invalid-feedback">Valid first name is required.
						</div>
					</div>
					<div class="mb-3">

						<label for="inputPassword" class="sr-only">Password</label> <input
							type="password" id="inputPassword" class="form-control"
							placeholder="Password" required>
					</div>
					<div class="mb-3">
						<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
							in</button>
					</div>
				</form>
			</td>
		</tr>
	</table>
</body>
</html>
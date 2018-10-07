<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Refresh" content="5;url=http://localhost:9000/ui/home/<%out.print(request.getSession().getAttribute("olbuser")); %>">
<title>Status</title>
</head>
<body>

<h3>You will automatically be redirected, do not refresh</h3>
<img src="/resources/loading.gif" bor>
	<c:if test="${not empty userErrorStatus}">
		<h2>
			<c:out value="${userErrorStatus}" />
		</h2>
	</c:if>
	<br>
	<c:if test="${not empty PANErrorStatus}">
		<h2>
			<c:out value="${PANErrorStatus}" />
		</h2>
	</c:if>
	<br>
	<c:if test="${not empty emailErrorStatus}">
		<h2>
			<c:out value="${emailErrorStatus}" />
		</h2>
	</c:if>
	<br>
	<c:if test="${not empty phoneErrorStatus}">
		<h2>
			<c:out value="${phoneErrorStatus}" />
		</h2>
	</c:if>
	<br>
	<c:if test="${not empty depositErrorStatus}">
		<h2>
			<c:out value="${depositErrorStatus}" />
		</h2>
	</c:if>
	<c:if test="${not empty status}">
		<h2>
			<c:out value="${status}" />
		</h2>
	</c:if>
	<br>
</body>
</html>
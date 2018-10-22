<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Get Employees</title>
</head>
<body>
    <h3 style="color: red;">Get Employee Info</h3>

    <div id="getEmployees">
        <form:form action="http://localhost:5001/oauth/authorize"
            method="post" modelAttribute="emp">
            <p>
                <label>Client Details</label><br>
                 Grant type: <input type="text" name="response_type" value="code" /> 
                 <br>
                 <br>
                 Client ID:<input type="text" name="client_id" value="javainuse" />
                 <br>
                 <br>
                 Callback URL:<input type="text" size="50" name="redirect_uri" value="http://localhost:5002/showEmployees" />
                 <br>
                 <br>
                 Scope:<input type="text" name="scope" value="read" /> 
                 <br>
                 <br>
                 <input type="SUBMIT" value="Get Employee info" />
        </form:form>
    </div>
</body>
</html>
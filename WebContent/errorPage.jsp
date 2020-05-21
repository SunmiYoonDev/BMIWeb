<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ErrorPage</title>
</head>
<body>
	<h1>Sunmi's BMI calculator</h1>
	<p>The cause is an input error: ${requestScope.errorMessage}</p>
	<a href="${pageContext.request.contextPath}">Start Over</a>.

</body>
</html>
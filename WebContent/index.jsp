<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>
<h1>Sunmi's Body Mass Index calculator</h1>
	<p>Please select the units you would like to work with:</p>
	<form action="${pageContext.request.contextPath}/usa" method="get">
		<p>Pounds and Inches <input name="btn" type="submit" value="USA"></p>			
	</form>
	<form action="${pageContext.request.contextPath}/metric" method="get">
		<p>Kilograms and Meters <input  name="btn" type="submit" value="Metric"></p>
	</form>

</body>
</html>
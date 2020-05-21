<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- copy the next line to any JSP page that uses the core JSTL tags  -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- copy the next line to any JSP page formats  numbers              -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BMI Calculator</title>
</head>
<body>
	<p><h1>Sunmi's BMI calculator</h1></p>
	<p style="color:red">${requestScope.errorMessage}</p>
		<c:choose>	
			<c:when test="${type eq 1}">
				<form action="${pageContext.request.contextPath}/usa" method="post">		
					<p>Please enter your values in American standard units.</p>
					<p>Height in inches:  <input name="height" type="text" value="${requestScope.height}"></p>
					<p>Weight in pounds:  <input name="weight" type="text" value="${requestScope.weight}"></p>
					<input name="btnCal" type="submit" value="Calculate BMI">
				</form>
			</c:when>
			<c:when test="${type eq 2}">
				<form action="${pageContext.request.contextPath}/metric" method="post">
					<p>Please enter your values in metric units.</p>
					<p>Height in centimeters: <input name="height" type="text" value="${requestScope.height}"></p>
					<p>Weight in kilograms: <input name="weight" type="text" value="${requestScope.weight}"></p>
					<input name="btnCal" type="submit" value="Calculate BMI">
				</form>
			</c:when>
		</c:choose>
</body>
</html>
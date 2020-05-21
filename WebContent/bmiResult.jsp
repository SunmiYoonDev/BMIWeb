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
<title>BMI Result</title>
</head>
<body>
	<p><h1> Sunmi Calculates a BMI of: 
	<fmt:formatNumber type="number" maxFractionDigits="1"
			value="${requestScope.bmi}" /></h1></p>
	<c:choose>
		<c:when test="${type eq 1}">
			<p>For a person with <b>height ${requestScope.height} inches</b>
				 and <b>weight <fmt:formatNumber type="number" maxFractionDigits="1"
								value="${requestScope.weight}" /> pounds</b></p>
			<p><h2>What does my BMI value mean?</h2></p>
			<p>${requestScope.value}</p>
			<p><a href="${pageContext.request.contextPath}/usa">Try again</a> (same units) 
			or <a href="${pageContext.request.contextPath}">Start Over</a> to change units.</p>
		</c:when>
		<c:when test="${type eq 2}">
			<p>For a person with <b>height ${requestScope.height} meters</b>
				 and <b>weight <fmt:formatNumber type="number" maxFractionDigits="1"
								value="${requestScope.weight}" /> kilograms</b></p>
			<p><h2>What does my BMI value mean?</h2></p>
			<p>${requestScope.value}</p>
			<a href="${pageContext.request.contextPath}/metric">Try again</a> (same units) 
			or <a href="${pageContext.request.contextPath}">Start Over</a> to change units.
		</c:when>
	</c:choose>			
	</body>
</html>
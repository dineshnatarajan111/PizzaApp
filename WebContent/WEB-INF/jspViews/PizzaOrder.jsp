<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.error {
color: #ff0000;
font-style: italic;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
ADD PIZZA DETAILS<br/><br/>
<form:form method="POST" modelAttribute="pizzaOrderBean" action="addPizzaOrderDetails.html">
Customer Name :<form:input path="customerName"/><br/><br/>
Customer Contact :<form:input path="contactNumber"/><br/><br/>
Pizza Name :<form:select path="pizzaId">
			<form:option value="" label="--Select--" />
			<form:options items="${pizzaNameAndPrice}"/> 
			</form:select><br/><br/>
Quantity :<form:input path="numberOfPiecesOrdered"/><br/><br/>
<input type="submit" value="Order">

<br/><br/>
<spring:hasBindErrors name="pizzaOrderBean">
			<h3>All Errors</h3>
			<form:errors path="*"  cssClass="error"/>
</spring:hasBindErrors>
</form:form><br/><br/>
<a href="index.jsp">Home</a>

</body>
</html>
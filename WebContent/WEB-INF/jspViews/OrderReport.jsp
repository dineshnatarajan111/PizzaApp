<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form method="POST" modelAttribute="billRangeBean" action="getOrderDetails.html">
From Price :<form:input path="fromPrice"/>
To Price :<form:input path="toPrice"/>
<input type="submit" value="FetchDetails">
</form:form>
<br/><br/>
<c:if test="${pizzaOrderBeans != null}">
<table border="1">
<tr>
<th>Order ID</th>
<th>Customer Name</th>
<th>Pizza ID</th>
<th>Bill</th>
<th>Quantity</th>
</tr>
<c:forEach var="pizzaOrderBean" items="${pizzaOrderBeans}">
<tr> <td><c:out value="${pizzaOrderBean.orderId}"></c:out></td>
     <td><c:out value="${pizzaOrderBean.customerName}"></c:out></td>
     <td><c:out value="${pizzaOrderBean.pizzaId}"></c:out></td>
     <td><c:out value="${pizzaOrderBean.bill}"></c:out></td>
     <td><c:out value="${pizzaOrderBean.numberOfPiecesOrdered}"></c:out></td>
</tr>
</c:forEach>
</table>
</c:if>
<br/><br/>
<a href="index.jsp">Home</a>
</body>
</html>
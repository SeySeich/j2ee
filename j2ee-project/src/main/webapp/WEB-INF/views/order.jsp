<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Склады</title>
	</head>
	<body>
		<h1 align="center" >Заказы продукта ${product.name}</h1>
		<hr />
		<div align="center">
			<c:forEach var="orderItem" items="${product.orderItems}">
				<hr />
				<c:out value="Товар: ${orderItem.product.name}" /><p>
				<c:out value="Склад: ${orderItem.warehouse.name}" /><p>
				<c:out value="Количество: ${orderItem.quantity}" /><p>
				<p>
			</c:forEach>
			<p>
			<a href="/j2ee/whinfo/${warehouse.id}">Назад</a>
		</div>
	</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Склады</title>
	</head>
	<body>
		<h1 align="center" >Склад ${warehouse.name}</h1>
		<hr />
		<div align="center">
			<c:forEach var="product" items="${warehouse.products}">
				<hr />
				<c:out value="Имя: ${product.name}" /><p>
				<c:out value="Категория: ${product.category.name}" /><p>
				<c:out value="Описание: ${product.description}" /><p>
				<c:out value="Цена: ${product.price}" /><p>
				<c:out value="Количество: ${product.quantity}" /><p>
				<c:out value="Скидка: ${product.discount}" /><p>
				<p>
				<a href="/j2ee/orders/warehouse/${warehouse.id}/product/${product.id}">Посмотреть заказы...</a>
			</c:forEach>
			<p>
			<a href="/j2ee">Назад</a>
		</div>
	</body>
</html>
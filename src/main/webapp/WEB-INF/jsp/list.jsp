<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head></head>
	<body>
		<h1>Products</h1>
	
		<div>
			<table>
				<c:forEach var="product" items="${products}">
					<tr>
						<td>${product.code}</td>
						<td><a href="/mvc1.0/web/products/${product.code}">${product.name}</a></td>
						<td>${product.price}</td>
						<td>${product.description}</td>
					</tr>
				</c:forEach>
			</table>
			<br>
			<form method="GET" action="products/new">
				<button type="submit">Add</button>
			</form>
		</div>
	</body>
</html>
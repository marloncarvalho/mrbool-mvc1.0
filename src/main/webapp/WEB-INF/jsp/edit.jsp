<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<header> </header>
<body>
	<h1>Product</h1>
	<div>
		<table>
			<c:forEach var="error" items="${errors}">
				<tr>
					<td style="color: red">${error.message}</td>
				</tr>
			</c:forEach>
		</table>
		<br> <br> <br>

		<form method="POST" action="">
			Code: <input type="text" name="code" id="code" value="${product.code}" /><br> 
			Name: <input type="text" name="name" id="name" value="${product.name}" /><br> 
			Price: <input type="text" name="price" id="price" value="${product.price}" /><br>
			Description: <input type="text" name="description" id="description" value="${product.description}" /><br>
			<button type="submit">Send</button>
		</form>
		
	</div>
</body>
</html>
<%@ page contentType="text/html; encoding=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Shopping List</title>
<script src="/scripts/app.js"></script>
<link rel="stylesheet"
	href="https://unpkg.com/sakura.css/css/sakura-dark.css" type="text/css">
<style>
td {
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
}

button {
	float: right;
}
</style>
</head>
<body>
	<h1>Shopping List</h1>

	<form method="post">
		<input name="title" type="text" required
			placeholder="type item here..." autofocus /> <input type="submit"
			value="Add to list" />
	</form>
	<table>
		<thead>
			<tr>
				<th>Product</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ items }" var="shoppingListItem">
				<tr id="product-${ shoppingListItem.getId() }">
					<td><c:out value="${ shoppingListItem.getId() }" /> <c:out
							value=" ${ shoppingListItem.getTitle() }" />
						<button onclick="removeProduct(${ shoppingListItem.getId() })">Remove</button></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
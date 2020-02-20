<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="navigationServlet">
<table>
<c:forEach items="${requestScope.allBooks}" var="currentBook">
<tr>
	<td><input type="radio" name="id" value="${currentBook.id}"></td>
	<td>${currentBook.title} </td>
	<td>${currentBook.author}</td>
	<td>${currentBook.year}</td>
</tr>
</c:forEach>
</table>
<input type="submit" value="edit" name="doThisToBook">
<input type="submit" value="delete" name="doThisToBook">
<input type="submit" value="add" name="doThisToBook">
</form>
</body>
</html>
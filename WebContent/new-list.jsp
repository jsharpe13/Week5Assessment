<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>create a new list</title>
</head>
<body>
<form action = "createNewListServlet" method="post">
List Name: <input type="text" name="listName"><br />
Person's Name: <input type="text" name="PersonName"><br />

Available Items:<br />
<select name="allItemsToAdd" multiple size="10">
<c:forEach items="${requestScope.allItems}" var="currentitem">
	<option value="${currentitem.id}">${currentitem.title} | ${currentitem.author} | ${currentitem.year}</option>
</c:forEach>
</select>
<br />
<input type = "submit" value="Create List and Add Items">
</form>
<a href = "index.html">add new items instead.</a>
</body>
</html>
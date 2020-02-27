<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit a list</title>
</head>
<body>
<form action="editExistingListServlet" method="post">
List Name: <input type="text" name="listName" value="${listToEdit.listName}"><br />
Person's Name: <input type="text" name="PersonName" value="${listToEdit.person.getPersonName()}"><br />
<input type = "hidden" name="id" value="${listToEdit.id}">
Current Items:<br />
<select name="currentItems" multiple size="6">
<c:forEach var="listVal" items="${listToEdit.bookList}">
	<option value = "${listVal.id}">${listVal.title} | ${listVal.author} | ${listVal.year}</option>
</c:forEach>
</select>
<br />
Remaining Items: <br />
<select name="itemsToAdd" multiple size="6">
<c:forEach items="${requestScope.allItemsToAdd}" var="currentitem">
	<option value="${currentitem.id}">${currentitem.title} | ${currentitem.author} | ${currentitem.year}</option>
</c:forEach>
</select>
<br />
<input type="submit" value="Edit List and Edit Books">
</form>
<a href="index.html">Add new items instead</a>
</body>
</html>
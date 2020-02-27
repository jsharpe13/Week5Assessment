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
<body>
<form method="post" action = "listNavigationServlet">
<table>
<c:forEach items ="${requestScope.allLists}" var="currentlist">
<tr>
	<td><input type="radio" name="id" value="${currentlist.id}"></td>
    <td><h2>${currentlist.listName}</h2></td></tr>
    <tr><td colspan="10">Person: ${currentlist.person.getPersonName()}</td></tr>
    <c:forEach var="listVal" items = "${currentlist.bookList}">
    	<tr><td></td><td colspan="3">
    		${listVal.title}, ${listVal.author}, ${listVal.year}
    		</td>
    	</tr>
    </c:forEach>
</c:forEach>
</table>
<input type = "submit" value = "edit" name="doThisToItem">
<input type = "submit" value = "delete" name="doThisToItem">
<input type="submit" value = "add" name = "doThisToItem">
</form>
<a href="addBooksForListServlet">Create a new List</a>
<a href="index.html">Insert a new item</a>
</body>

</body>
</html>
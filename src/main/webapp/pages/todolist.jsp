<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>todo list form</title>
</head>
<body>
<div align="center"> 
<h1>ToDo List</h1>
<p style="color:red;">${status}</p>
<table border="2" width="70%" cellpadding="2">
	<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Marks</th>
		<th>Delete</th>
	</tr>
	<c:forEach var="list" items="${todoList}">
		<tr>
			<td>${list.id}</td>
			<td>${list.name}</td>
			<td>${list.marks}</td>
			<td><a href="delete/${list.id}">Delete</a></td>
		</tr>
	</c:forEach>
</table>
<br />
<a href="/getform">Add New ToDo</a>
</div>
</body>
</html>
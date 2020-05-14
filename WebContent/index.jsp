<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<sql:setDataSource var="myDataBase" driver="com.mysql.jdbc.Driver"
	url="jdbc:mysql://localhost:3306/goods" user="root" password="1111"
	scope="session" />
<sql:query var="date" dataSource="${myDataBase}">
	select * from goods
</sql:query>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main</title>
</head>
<body>
	<h2>Table</h2>
	<table border="1">
		<tr>
			<th>id</th>
			<th>name</th>
			<th>price</th>
			<th>count</th>
		</tr>
		<c:forEach var="row" items="${date.rows}">
			<tr>
				<td><p>${row.id}</p></td>
				<td><p>${row.name}</p></td>
				<td><p>${row.price}</p></td>
				<td><p>${row.count}</p></td>
				<td><a href="delete?id=${row.id}">Удалить</a></td>
				<td><a href="update.jsp?id=${row.id}&name=${row.name}&price=${row.price}&count=${row.count}">Редактировать</a></td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<form action='add.jsp' method='GET'>
		<button type='submit' value='Submit'>Добавить товар</button>
	</form>
</body>
</html>
<%@page import="com.sun.xml.internal.bind.CycleRecoverable.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add</title>
</head>
<body>
    <form action='add' method='POST'>
    <p><input type="text" name="name" value="">Название</p>
    <p><input type="text" name="price" value="">Цена</p>
    <p><input type="text" name="count" value="">Количество</p>
	<input type='submit' value='Сохранить'>
	</form>
</body>
</html>
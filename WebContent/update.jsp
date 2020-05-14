<%@page import="com.sun.xml.internal.bind.CycleRecoverable.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update</title>
	<% String formId = request.getParameter("id"); %>
	<% String formName = request.getParameter("name"); %>
	<% String formPrice = request.getParameter("price"); %>
	<% String formCount = request.getParameter("count"); %>
</head>
<body>

    <form action='update' method='POST'>
	<input type="hidden" name="id" value="<%=formId%>">
    <p><input type="text" name="name" value="<%=formName%>">Название</p>
    <p><input type="text" name="price" value=<%=formPrice%>>Цена</p>
    <p><input type="text" name="count" value=<%=formCount%>>Количество</p>
	<input type='submit' value='Сохранить'>
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Klinika dla zwierząt</title>
    <link href="/css/style.css"
          rel="stylesheet">
</head>
<body>
<%@include file="fragments/header.jspf" %>


<form:form action="/edit-owner" method="post" modelAttribute="owner">
    Imie: <form:input path="firstName"/><br />
    Nazwisko: <form:input path="lastName"/><br />
    Miasto: <form:input path="city"/><br />
    Adres: <form:input path="address"/><br />
    Telefon: <form:input path="telephoneNumber"/><br />
    <form:hidden path="id"/>
    <input type="submit" value="Aktualizuj"/>
</form:form>

</body>
</html>
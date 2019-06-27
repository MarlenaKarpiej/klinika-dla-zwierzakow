<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Klinika dla zwierząt</title>
</head>
<body>
<%@include file="fragments/header.jspf" %>
<c:forEach items="${allOwners}" var="owner">
    <c:out value="${owner.id}" />
    <c:out value="${owner.firstName}" />
    <c:out value="${owner.lastName}" />
    <c:out value="${owner.city}" />
    <c:out value="${owner.address}" />
    <c:out value="${owner.telephoneNumber}" />
    <a href="delete-owner?id=${owner.id}">Usuń</a>
    <a href="edit-owner?id=${owner.id}">Edytuj</a>
    <br/>
</c:forEach>

</body>
</html>
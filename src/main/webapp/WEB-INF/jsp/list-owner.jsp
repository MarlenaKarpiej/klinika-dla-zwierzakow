<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

<c:if test="${empty allOwners}">
    <h3>Sorry, no records found</h3>
</c:if>
<c:forEach items="${allOwners}" var="owner">
    <c:out value="${owner.id}" />
    <c:out value="${owner.firstName}" />
    <c:out value="${owner.lastName}" /><br/>
    <c:out value="${owner.city}" />
    <c:out value="${owner.address}" /><br/>
    <c:out value="${owner.telephoneNumber}" /><br/>
    <c:forEach items="${owner.pets}" var="pet">
        <c:out value="${pet.id}"/>
        <c:out value="${pet.name}"/>
        <c:out value="${pet.birthDate}"/>
        <c:out value="${pet.petType}"/>
        <a href="/pet/delete-pet/${pet.id}">Usuń</a>
        <a href="/pet/edit-pet/${pet.id}/${owner.id}">Edytuj</a>
        <a href="/visit/create/${pet.id}">Dodaj wizytę</a>
        <br/>
    </c:forEach>
    <a href="/delete-owner/${owner.id}">Usuń</a>
    <a href="/edit-owner/${owner.id}">Edytuj</a>
    <a href="/pet/create/${owner.id}">Dodaj pupila</a>
    <br/><br/><br/>
</c:forEach>

</body>
</html>
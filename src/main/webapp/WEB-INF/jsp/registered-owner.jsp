<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Klinika dla zwierząt</title>
</head>
<body>
<%@include file="fragments/header.jspf" %>

Dodano właściciela! <br />

Imie: ${owner.firstName}<br />
Nazwisko: ${owner.lastName}<br />
Miasto: ${owner.city}<br />
Adres: ${owner.address}<br />
Telefon: ${owner.telephoneNumber}<br />

</body>
</html>
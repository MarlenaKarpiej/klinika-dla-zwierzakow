<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add owner</title>
</head>
<body>
<%@include file="fragments/header.jspf" %>


<form:form action="/owner/form" method="post" modelAttribute="newOwner">
    Imie: <form:input path="firstName"/><br />
    Nazwisko: <form:input path="lastName"/><br />
    Miasto: <form:input path="city"/><br />
    Adres: <form:input path="address"/><br />
    Telefon: <form:input path="telephone"/><br />
    <input type="submit" value="Zarejestruj"/>
</form:form>

</body>
</html>
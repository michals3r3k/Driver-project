<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Dodaj poradę</title>
</head>
<body>
<h1>Dodaj poradę</h1>
<form:form modelAttribute="advice">
    Tytuł: <form:input path="title"/><br>
    Opis: <form:input path="description"/><br>
    <button type="submit">Wyślij</button>
</form:form>

</body>
</html>

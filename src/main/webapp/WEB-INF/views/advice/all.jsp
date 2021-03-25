<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Porady</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>" type="text/css">
</head>
<body>
<h1>Lista wszystkich porad:</h1>
<table class="custom-table">
    <thead>
        <tr class="custom-tr">
            <th class="custom-td">Id</th>
            <th class="custom-td">Tytuł</th>
            <th class="custom-td">Data publikacji</th>
            <th class="custom-td">Godzina publikacji</th>
            <th class="custom-td">Akcja</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${advices}" var="advice">
            <tr class="custom-tr">
                <td class="custom-td">${advice.id}</td>
                <td class="custom-td">${advice.title}</td>
                <td class="custom-td">${advice.dateOfPublic}</td>
                <td class="custom-td">${advice.timeOfPublic}</td>
                <td class="custom-td">
                    <button>Edytuj</button>
                    <button>Szczegóły</button>
                </td>
            </tr>
        </c:forEach>
    </tbody>
    <tfoot>
        <tr class="custom-tr">
            <td class="custom-td" colspan="5"><a href="/admin/advice/add"><button>+</button></a> <em>Dodaj nową poradę</em></td>
        </tr>
    </tfoot>
</table>

</body>
</html>

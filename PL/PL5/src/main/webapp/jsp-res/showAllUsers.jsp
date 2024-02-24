<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>All users</title>
</head>
<body>
<table>
    <tr>
        <th>Name</th>
        <th>Programming language</th>
        <th>Experience</th>
    </tr>
    <c:forEach var="person" items="${allProg}">

        <c:url var="deleteButton" value="/deleteProgrammer">
            <c:param name="personId" value="${person.id}"/>
        </c:url>

        <tr>
            <td>${person.name}</td>
            <td>${person.progLang}</td>
            <td>${person.exp}</td>
            <td>
                <input type="button" value="Delete" onclick="window.location.href='${deleteButton}'"/>
            </td>
        </tr>
    </c:forEach>
</table>
<input type="button" onclick="window.location.href = '/addUser'" value="Add user">

</body>
</html>

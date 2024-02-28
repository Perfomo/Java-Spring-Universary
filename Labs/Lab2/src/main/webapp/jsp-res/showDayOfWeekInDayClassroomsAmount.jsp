<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Show Task4</title>
</head>
<body>
    <c:forEach var="var" items="${info}">
        <h2>
                ${var.getDayOfWeek()}
        </h2>
        <br><br>
    </c:forEach>
</body>
</html>

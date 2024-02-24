<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add User</title>
</head>
<body>
    <form:form method="post" modelAttribute="newProgrammer">
        <form:hidden path="id"/>
        <br><br>
        Name <form:input path="name"/>
        <br><br>
        Prog lang <form:input path="progLang"/>
        <br><br>
        Exp <form:input path="exp"/>
        <br><br>
        <input type="submit" value="ok">
    </form:form>
</body>
</html>

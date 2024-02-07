<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Input word</title>
</head>
<body>
    <form>
        <input type="text" name="findText" value="Input key">
        <input type="text" name="changeText" value="Input text to change">
        <input type="checkbox" name="ifChange" value="True">
        <input type="submit" formmethod="post" value="ok">
    </form>
</body>
</html>

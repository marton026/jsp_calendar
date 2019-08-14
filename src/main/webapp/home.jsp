<%@ page import="pl.sda.user.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Strona Główna</title>
</head>
<body>

    <h1>Witaj ${sessionScope.get("user").name}</h1>
    <form action="/logout" method="post">
        <input type="submit" value="Wyloguj">
    </form>
</body>
</html>

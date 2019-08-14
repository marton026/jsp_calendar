<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <%
        String errorMessage = (String) request.getAttribute("errorMessage");
        if (errorMessage != null) {
            out.print("<h4>" + errorMessage + "</h4>");
        }
    %>
    <form action="/login" method="post">
        <p>Login</p>
        <input name="login">
        <p>Hasło</p>
        <input name="password" type="password">
        <p></p>
        <input type="submit" value="Zaloguj">
    </form>
</body>
</html>

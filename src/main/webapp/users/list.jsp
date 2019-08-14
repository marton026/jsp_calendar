<%@ page import="pl.sda.user.repository.UserHashMapRepository" %>
<%@ page import="pl.sda.user.model.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Lista użytkowników</title>

    <style>
        table, th, td {
            border: solid 1px gray;
        }
    </style>
</head>
<body>

<h1>Lista użytkowników</h1>
<table>
    <tr>
        <th>l.p</th>
        <th>Login</th>
        <th>E-mail</th>
        <th>Nazwa</th>
        <th>Operacja</th>
    </tr>

    <% int no = 0; %>
    <c:forEach items="${users}" var="user">
        <tr>
            <td><%=++no%></td>
            <td>${user.login}</td>
            <td>${user.email}</td>
            <td>${user.name}</td>
            <td><a href=/users/del?id=${user.id}>Usuń</a></td>
        </tr>
    </c:forEach>

</table>

<br>
<form>
    <button formaction="create">Dodaj nowego użytkownika</button>           //przycisk z linkiem 1 sposób
</form>
<a href="/login">
    <button>Panel logowania</button>                       //przycisk z linkiem 2 sposób
</a>

</body>
</html>

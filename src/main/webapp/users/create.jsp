<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Utwórz użytkownika</title>
</head>
<body>

    <%
        String errorMessage =
                (String) request.getAttribute("errorMessage");
        if(errorMessage!=null){
            out.print("<h2>"+errorMessage+"</h2>");
        }
    %>

    <h1>Stwórz nowego użytkownika</h1>
    <form method="post" action="/users/create">
        <p>Login</p>
        <input name="login"/>
        <p>Nazwa użytkownika</p>
        <input name="name"/>
        <p>E-mail</p>
        <input type="email" name="email"/>
        <p>Hasło</p>
        <input type="password" name="pass"/>
        <p>Powtórz Hasło</p>
        <input type="password" name="retype-pass"/>
        <br/>
        <input type="submit" value="Utwórz użytkownika">
    </form>

</body>
</html>

<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>Hello World</title>
</head>
<body>
<h1>Hello World JSP</h1>

<%
    String hello = "hello";
    String world = "world :)";

    out.print(hello + " " + world);

    String to = request.getParameter("to");
    int toInt;
    if (to == null) {
        toInt = 1;
    } else {
        toInt = Integer.parseInt(to);
    }
%>

<h4>Umiem liczyć do <%= toInt%></h4>

<% for(int i = 1; i<=toInt; i++) { %>
    <p><%=i%></p>
<% } %>

<p> Teraz jest: <%= LocalDateTime.now()%>
</p>
</body>
</html>

<%@ page import="java.util.Optional" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tabliczka Mnożenia</title>
    <style>
        table, tr, th, td {
            border: 1px solid black;
        }
    </style>
</head>
<body>

    <h1>Tabliczka mnożenia</h1>

    <%
        int from = Integer.parseInt(
                Optional.ofNullable(
                        request.getParameter("from")
                ).orElse("10")
        );
        int to = Integer.parseInt(Optional.ofNullable(request.getParameter("to")).orElse("10"));
    %>

    <table>
        <tr>
            <th></th>
            <% for(int i = from; i<=to; i++){ %>
                <th><%=i%></th>
            <% } %>
        </tr>
        <% for(int i = from; i<=to; i++){
            out.print("<tr>");
            out.print("<th>" + i + "</th>");
            for (int j = from; j <= to; j++) {
                out.print("<td>"+i*j+"</td>");
            }
            out.print("</tr>");
        }%>
    </table>

</body>
</html>

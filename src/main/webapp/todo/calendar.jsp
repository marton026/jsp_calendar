<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="pl.sda.todo.model.Task" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.time.temporal.TemporalAdjusters" %>
<%@ page import="java.time.DayOfWeek" %>
<%@ page import="java.time.Month" %>
<%@ page import="com.sun.tracing.dtrace.ModuleName" %>
<%@ page import="java.time.Year" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Kalendarz</title>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    <script>
        $(function () {
            $('[data-toggle="tooltip"]').tooltip()
        })
    </script>

    <script type="text/javascript">


        MonthName = new Array(12)
        MonthName[0] = "&nbsp;&nbsp;&nbsp;styczeń&nbsp;&nbsp;&nbsp; "                            //&nbsp;  twarda spacja
        MonthName[1] = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;luty&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
        MonthName[2] = "&nbsp;&nbsp;&nbsp;marzec&nbsp;&nbsp;&nbsp; "
        MonthName[3] = "&nbsp;&nbsp;kwiecień&nbsp;&nbsp;&nbsp; "
        MonthName[4] = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;maj&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
        MonthName[5] = "&nbsp;&nbsp;czerwiec&nbsp;&nbsp;&nbsp; "
        MonthName[6] = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;lipiec&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
        MonthName[7] = "&nbsp;&nbsp;&nbsp;sierpień&nbsp;&nbsp;&nbsp;"
        MonthName[8] = "&nbsp;&nbsp;wrzesień&nbsp;&nbsp;&nbsp;"
        MonthName[9] = "październik"
        MonthName[10] = "&nbsp;&nbsp;&nbsp;listopad&nbsp;&nbsp;&nbsp; "
        MonthName[11] = "&nbsp;&nbsp;grudzień&nbsp;&nbsp;&nbsp; "

    </script>



    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <style>

        .sunday {
            color: red;
        }

        .saturday {
            color: grey;
        }

        .now {
            color: blue;
        }

        .done {
            text-decoration: line-through;
        }

        button {
            background-color: paleturquoise;
        }

    </style>
</head>

<body>
<% LocalDate now = LocalDate.now();
    LocalDate from = (LocalDate) request.getAttribute("from");
    LocalDate to = (LocalDate) request.getAttribute("to");
    Integer thisMonth = (Integer) request.getAttribute("thisMonth");
    Integer thisYear = (Integer) request.getAttribute("thisYear");

    LocalDate firstMonday = from.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
    LocalDate lastSunday = to.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
    Map<LocalDate, List<Task>> tasks = (Map<LocalDate, List<Task>>) request.getAttribute("tasks");
%>



<div class="card" style="margin: 20px">
    <div class="card-header">

<%--        <%  int month = LocalDate.now().getMonthValue();%>--%>

        <div>
            Moje zadania na miesiąc :
            <input type="button" value="<<" id="decButton" />
            <span style="color: blue;font-weight: bold"  id ="displayCount" ></span>

            <input type="button" value=">>" id="incButton" />
            <input style="margin-left: 10px" type="button" value="<<" id="decYearButton" />
            <span style="color: #ff8438;font-weight: bold" id ="displayYear" ></span>

            <input type="button" value=">>" id="incYearButton" />
            <input style="width: 100px;margin-left: 10px" type="button" value="Zatwierdź" id="okButton" />
            <a href="new">
                <button style="margin-left: 30px">Dodaj nowe zadanie</button>                       <%--przycisk z linkiem 2 sposób--%>
            </a>
            <a href="list">
                <button style="margin-left: 30px">Lista zadań</button>
            </a>

        </div>
        <script>document.write("<%=Month.of(thisMonth)%>")</script>
        <script>document.write("<%=Year.of(thisYear)%>")</script>
<%--        <script>document.write("<%=now.getYear()%>")</script>--%>

            <script type="text/javascript">



                const currentDate = new Date();
                 // var m = currentDate.getMonth();

                var count = <%=thisMonth-1%>;
                var year = <%=thisYear%>;
                var incButton = document.getElementById("incButton");
                var okButton = document.getElementById("okButton");
                var displayCount = document.getElementById("displayCount");
                var incYearButton = document.getElementById("incYearButton");
                var displayYear = document.getElementById("displayYear");
                displayCount.innerHTML = MonthName[<%=thisMonth-1%>];
                <%--displayYear.innerHTML = <%=thisYear+1997%>;--%>
                displayYear.innerHTML = <%=Year.of(thisYear)%>;
                incButton.onclick = function(){
                    if (count < 11) {
                        count++;
                        displayCount.innerHTML = MonthName[count];
                    }
                }
                decButton.onclick = function(){
                    if (count>0) {
                        count--;
                        displayCount.innerHTML = MonthName[count];
                    }

                }
                okButton.onclick = function(){

                    window.location.href="?month="+(count+1)+"&year="+year;
                    displayCount.innerText = MonthName[count];
                    displayYear.innerText=year;
                }

                incYearButton.onclick = function(){
                    if (year < 3000) {
                        year++;
                        displayYear.innerHTML = year;
                    }
                }
                decYearButton.onclick = function(){
                    if (year ><%=now.getYear()%>) {
                        year--;
                        displayYear.innerHTML = year;
                    }
                }

            </script>


    </div>
    <div class="card-body">
<table class="table table-striped table-light table-sm table-hover">
    <thead class="thead-light">
        <tr>
            <th>Poniedziałek</th>
            <th>Wtorek</th>
            <th>Środa</th>
            <th>Czwartek</th>
            <th>Piątek</th>
            <th>Sobota</th>
            <th>Niedziela</th>
        </tr>
    </thead>

    <% for (LocalDate date = firstMonday; !date.isAfter(lastSunday); date = date.plusDays(1)) {
        String className = date.getDayOfWeek().toString().toLowerCase();
        if (date.equals(LocalDate.now())) {
            className = "now";
        }
        if (date.getDayOfWeek().equals(DayOfWeek.MONDAY)) {
            out.print("<tr>");
        }
    %>
    <td>
        <h2 class="<%=className%>"><%=date.getDayOfMonth()%>
        </h2>

        <% List<Task> taskByDay = tasks.get(date);
            if (taskByDay != null) {
                for (Task task : taskByDay) {
                    if (task.getCompleted()) {
                        out.print("<p class='done'>" + task.getTitle() + "</p>");
                    } else {
//                        out.print("<p data-toggle=\"tooltip\" data-placement=\"top\" title=\""
//                                +task.getDescription()+"\">" + task.getTitle() + "</p>");
                        out.print("<a href=\"/todo/done?id="+task.getId()+"\"> <p data-toggle=\"tooltip\" data-placement=\"top\" title=\""
                                 +task.getDescription()+"\">" + task.getTitle() + "</p> </a><br>");

                    }
                }
            }

        %>
    </td>
    <%
            if (date.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
                out.print("</tr>");
            }
        } %>
</table>
</div>
</div>

</body>
</html>

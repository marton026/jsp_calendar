/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.30
 * Generated at: 2019-07-19 23:17:53 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.todo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import pl.sda.todo.model.Task;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.time.temporal.TemporalAdjusters;
import java.time.DayOfWeek;
import java.time.Month;
import com.sun.tracing.dtrace.ModuleName;
import java.time.Year;

public final class calendar_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("jar:file:/C:/Users/Marcin/.m2/repository/jstl/jstl/1.2/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153377882000L));
    _jspx_dependants.put("file:/C:/Users/Marcin/.m2/repository/jstl/jstl/1.2/jstl-1.2.jar", Long.valueOf(1562488742775L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("pl.sda.todo.model.Task");
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("com.sun.tracing.dtrace.ModuleName");
    _jspx_imports_classes.add("java.time.Month");
    _jspx_imports_classes.add("java.time.Year");
    _jspx_imports_classes.add("java.time.LocalDate");
    _jspx_imports_classes.add("java.util.Map");
    _jspx_imports_classes.add("java.time.DayOfWeek");
    _jspx_imports_classes.add("java.time.temporal.TemporalAdjusters");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>Kalendarz</title>\r\n");
      out.write("    <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js\" integrity=\"sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("    <script>\r\n");
      out.write("        $(function () {\r\n");
      out.write("            $('[data-toggle=\"tooltip\"]').tooltip()\r\n");
      out.write("        })\r\n");
      out.write("    </script>\r\n");
      out.write("\r\n");
      out.write("    <script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        MonthName = new Array(12)\r\n");
      out.write("        MonthName[0] = \"&nbsp;&nbsp;&nbsp;styczeń&nbsp;&nbsp;&nbsp; \"                            //&nbsp;  twarda spacja\r\n");
      out.write("        MonthName[1] = \"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;luty&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\"\r\n");
      out.write("        MonthName[2] = \"&nbsp;&nbsp;&nbsp;marzec&nbsp;&nbsp;&nbsp; \"\r\n");
      out.write("        MonthName[3] = \"&nbsp;&nbsp;kwiecień&nbsp;&nbsp;&nbsp; \"\r\n");
      out.write("        MonthName[4] = \"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;maj&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\"\r\n");
      out.write("        MonthName[5] = \"&nbsp;&nbsp;czerwiec&nbsp;&nbsp;&nbsp; \"\r\n");
      out.write("        MonthName[6] = \"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;lipiec&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\"\r\n");
      out.write("        MonthName[7] = \"&nbsp;&nbsp;&nbsp;sierpień&nbsp;&nbsp;&nbsp;\"\r\n");
      out.write("        MonthName[8] = \"&nbsp;&nbsp;wrzesień&nbsp;&nbsp;&nbsp;\"\r\n");
      out.write("        MonthName[9] = \"październik\"\r\n");
      out.write("        MonthName[10] = \"&nbsp;&nbsp;&nbsp;listopad&nbsp;&nbsp;&nbsp; \"\r\n");
      out.write("        MonthName[11] = \"&nbsp;&nbsp;grudzień&nbsp;&nbsp;&nbsp; \"\r\n");
      out.write("\r\n");
      out.write("    </script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\"\r\n");
      out.write("          integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">\r\n");
      out.write("    <style>\r\n");
      out.write("\r\n");
      out.write("        .sunday {\r\n");
      out.write("            color: red;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .saturday {\r\n");
      out.write("            color: grey;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .now {\r\n");
      out.write("            color: blue;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .done {\r\n");
      out.write("            text-decoration: line-through;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        button {\r\n");
      out.write("            background-color: paleturquoise;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
 LocalDate now = LocalDate.now();
    LocalDate from = (LocalDate) request.getAttribute("from");
    LocalDate to = (LocalDate) request.getAttribute("to");
    Integer thisMonth = (Integer) request.getAttribute("thisMonth");
    Integer thisYear = (Integer) request.getAttribute("thisYear");

    LocalDate firstMonday = from.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
    LocalDate lastSunday = to.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
    Map<LocalDate, List<Task>> tasks = (Map<LocalDate, List<Task>>) request.getAttribute("tasks");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"card\" style=\"margin: 20px\">\r\n");
      out.write("    <div class=\"card-header\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div>\r\n");
      out.write("            Moje zadania na miesiąc :\r\n");
      out.write("            <input type=\"button\" value=\"<<\" id=\"decButton\" />\r\n");
      out.write("            <span style=\"color: blue;font-weight: bold\"  id =\"displayCount\" ></span>\r\n");
      out.write("\r\n");
      out.write("            <input type=\"button\" value=\">>\" id=\"incButton\" />\r\n");
      out.write("            <input style=\"margin-left: 10px\" type=\"button\" value=\"<<\" id=\"decYearButton\" />\r\n");
      out.write("            <span style=\"color: #ff8438;font-weight: bold\" id =\"displayYear\" ></span>\r\n");
      out.write("\r\n");
      out.write("            <input type=\"button\" value=\">>\" id=\"incYearButton\" />\r\n");
      out.write("            <input style=\"width: 100px;margin-left: 10px\" type=\"button\" value=\"Zatwierdź\" id=\"okButton\" />\r\n");
      out.write("            <a href=\"new\">\r\n");
      out.write("                <button style=\"margin-left: 30px\">Dodaj nowe zadanie</button>                       ");
      out.write("\r\n");
      out.write("            </a>\r\n");
      out.write("            <a href=\"list\">\r\n");
      out.write("                <button style=\"margin-left: 30px\">Lista zadań</button>\r\n");
      out.write("            </a>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        <script>document.write(\"");
      out.print(Month.of(thisMonth));
      out.write("\")</script>\r\n");
      out.write("        <script>document.write(\"");
      out.print(Year.of(thisYear));
      out.write("\")</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                const currentDate = new Date();\r\n");
      out.write("                 // var m = currentDate.getMonth();\r\n");
      out.write("\r\n");
      out.write("                var count = ");
      out.print(thisMonth-1);
      out.write(";\r\n");
      out.write("                var year = ");
      out.print(thisYear);
      out.write(";\r\n");
      out.write("                var incButton = document.getElementById(\"incButton\");\r\n");
      out.write("                var okButton = document.getElementById(\"okButton\");\r\n");
      out.write("                var displayCount = document.getElementById(\"displayCount\");\r\n");
      out.write("                var incYearButton = document.getElementById(\"incYearButton\");\r\n");
      out.write("                var displayYear = document.getElementById(\"displayYear\");\r\n");
      out.write("                displayCount.innerHTML = MonthName[");
      out.print(thisMonth-1);
      out.write("];\r\n");
      out.write("                ");
      out.write("\r\n");
      out.write("                displayYear.innerHTML = ");
      out.print(Year.of(thisYear));
      out.write(";\r\n");
      out.write("                incButton.onclick = function(){\r\n");
      out.write("                    if (count < 11) {\r\n");
      out.write("                        count++;\r\n");
      out.write("                        displayCount.innerHTML = MonthName[count];\r\n");
      out.write("                    }\r\n");
      out.write("                }\r\n");
      out.write("                decButton.onclick = function(){\r\n");
      out.write("                    if (count>0) {\r\n");
      out.write("                        count--;\r\n");
      out.write("                        displayCount.innerHTML = MonthName[count];\r\n");
      out.write("                    }\r\n");
      out.write("\r\n");
      out.write("                }\r\n");
      out.write("                okButton.onclick = function(){\r\n");
      out.write("\r\n");
      out.write("                    window.location.href=\"?month=\"+(count+1)+\"&year=\"+year;\r\n");
      out.write("                    displayCount.innerText = MonthName[count];\r\n");
      out.write("                    displayYear.innerText=year;\r\n");
      out.write("                }\r\n");
      out.write("\r\n");
      out.write("                incYearButton.onclick = function(){\r\n");
      out.write("                    if (year < 3000) {\r\n");
      out.write("                        year++;\r\n");
      out.write("                        displayYear.innerHTML = year;\r\n");
      out.write("                    }\r\n");
      out.write("                }\r\n");
      out.write("                decYearButton.onclick = function(){\r\n");
      out.write("                    if (year >");
      out.print(now.getYear());
      out.write(") {\r\n");
      out.write("                        year--;\r\n");
      out.write("                        displayYear.innerHTML = year;\r\n");
      out.write("                    }\r\n");
      out.write("                }\r\n");
      out.write("\r\n");
      out.write("            </script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"card-body\">\r\n");
      out.write("<table class=\"table table-striped table-light table-sm table-hover\">\r\n");
      out.write("    <thead class=\"thead-light\">\r\n");
      out.write("        <tr>\r\n");
      out.write("            <th>Poniedziałek</th>\r\n");
      out.write("            <th>Wtorek</th>\r\n");
      out.write("            <th>Środa</th>\r\n");
      out.write("            <th>Czwartek</th>\r\n");
      out.write("            <th>Piątek</th>\r\n");
      out.write("            <th>Sobota</th>\r\n");
      out.write("            <th>Niedziela</th>\r\n");
      out.write("        </tr>\r\n");
      out.write("    </thead>\r\n");
      out.write("\r\n");
      out.write("    ");
 for (LocalDate date = firstMonday; !date.isAfter(lastSunday); date = date.plusDays(1)) {
        String className = date.getDayOfWeek().toString().toLowerCase();
        if (date.equals(LocalDate.now())) {
            className = "now";
        }
        if (date.getDayOfWeek().equals(DayOfWeek.MONDAY)) {
            out.print("<tr>");
        }
    
      out.write("\r\n");
      out.write("    <td>\r\n");
      out.write("        <h2 class=\"");
      out.print(className);
      out.write('"');
      out.write('>');
      out.print(date.getDayOfMonth());
      out.write("\r\n");
      out.write("        </h2>\r\n");
      out.write("\r\n");
      out.write("        ");
 List<Task> taskByDay = tasks.get(date);
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

        
      out.write("\r\n");
      out.write("    </td>\r\n");
      out.write("    ");

            if (date.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
                out.print("</tr>");
            }
        } 
      out.write("\r\n");
      out.write("</table>\r\n");
      out.write("</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

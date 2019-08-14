package pl.sda.todo.controller;

import pl.sda.todo.model.Task;
import pl.sda.todo.repository.TaskHibernateRepository;
import pl.sda.todo.repository.TaskRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.List;

@WebServlet(name = "TodoList", urlPatterns = "/todo/list")
public class ListServlet extends HttpServlet {

    private TaskRepository repository = new TaskHibernateRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Task> tasks = repository.findAll();
        tasks.sort(Comparator.comparing(Task::getDate));  //sortowanie listy po dacie

        resp.setHeader("Content-Type","text/html; charset=utf-8");      //spolszczenie

        PrintWriter writer = resp.getWriter();


        writer.append("<html>");
        writer.append("<head>");
        writer.append("<title>Moje zadania</title>");
        writer.append("<meta charset=\"UTF-8\">");
        writer.append("<style>");
        writer.append("table, tr, th, td {border: solid 1px black;}");
        writer.append(" .done {text-decoration: line-through;}");
        writer.append("</style>");
        writer.append("</head>");

        writer.append("<body>");
        writer.append("<h1>Zadania</h1>");

        writer.append("<table style='width: 100%'>");

        writer.append("<tr>");
        writer.append("<td>l.p</td>");
        writer.append("<td>Tytuł</td>");
        writer.append("<td>Opis</td>");
        writer.append("<td>Data</td>");
        writer.append("<td></td>");
        writer.append("</tr>");

        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            if (task.getCompleted()) {
                writer.append("<tr class=\"done\">");
            } else {
                writer.append("<tr>");
            }

            int no = i + 1;
            writer.append("<td>" + no + "</td>");
            writer.append("<td>" + task.getTitle() + "</td>");
            writer.append("<td>" + task.getDescription() + "</td>");
            writer.append("<td>" + task.getDate() + "</td>");
            if (!task.getCompleted()) {
                writer.append("<td>" +
                        "<a href=\"/todo/done?id="+ task.getId()+"\">" +
                        "❌</a></td>");
            } else {
                writer.append("<td>✅</td>");
            }
            writer.append("</tr>");
        }

        writer.append("</table>");
        writer.append("<a href=\"/todo/new\" ><button>Dodaj nowe zadanie</button></a>\t\t\t");
        writer.append("<a href=\"/todo/calendar\" ><button>Kalendarz zadań</button></a>");

        writer.append("</body>");

        writer.append("</html>");
    }
}

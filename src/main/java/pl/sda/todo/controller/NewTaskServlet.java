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
import java.time.LocalDate;

@WebServlet(name = "NewTask", urlPatterns = "/todo/new")
public class NewTaskServlet extends HttpServlet {

    private TaskRepository taskRepository =
            new TaskHibernateRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Content-Type",
                "text/html; charset=utf-8");
        PrintWriter writer = resp.getWriter();

        writer.append("<html>");
        writer.append("<head>");
        writer.append("<title>Dodaj nowe zadanie</title>");
        writer.append("<meta charset=\"UTF-8\">");
        writer.append("</head>");
        writer.append("<body>");

        writer.append("<h1>Dodaj nowe zadanie</h1>");
        writer.append("<form method=\"post\">");
        writer.append("<h3>Tytuł</h3>");
        writer.append("<input name=\"title\">");
        writer.append("<h3>Opis</h3>");
        writer.append("<input name=\"description\">");
        writer.append("<h3>Data</h3>");
        writer.append("<input type=\"date\" name=\"date\">");
        writer.append("<br>");
        writer.append("<input type=\"submit\">");
        writer.append("</form>");

        writer.append("</body>");
        writer.append("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String title = req.getParameter("title");
        String description = req.getParameter("description");
        String date = req.getParameter("date");
        LocalDate parsedDate = LocalDate.parse(date);

        Task task = new Task();
        task.setTitle(title);
        task.setDescription(description);
        task.setDate(parsedDate);
        task.setCompleted(false);

        taskRepository.save(task);

        resp.sendRedirect("/todo/list");
    }
}

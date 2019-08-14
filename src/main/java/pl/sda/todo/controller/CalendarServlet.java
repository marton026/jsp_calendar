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
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = "/todo/calendar")
public class CalendarServlet extends HttpServlet {

    private TaskRepository repository =
            new TaskHibernateRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Content-Type",
                "text/html; charset=utf-8");

        Integer year = Optional.ofNullable(req.getParameter("year"))
                .map(Integer::parseInt)
                .orElse(LocalDate.now().getYear());
        Integer month = Optional.ofNullable(req.getParameter("month"))
                .map(Integer::parseInt)
                .orElse(LocalDate.now().getMonthValue());

        LocalDate from = LocalDate.of(year, month, 1);
        LocalDate to = from.with(TemporalAdjusters.lastDayOfMonth());

        req.setAttribute("from", from);
        req.setAttribute("to", to);
        req.setAttribute("thisMonth",month);
        req.setAttribute("thisYear",year);

        List<Task> tasks = repository.findByDates(from, to);
        Map<LocalDate, List<Task>> tasksByDate = tasks.stream().collect(
                Collectors.groupingBy(Task::getDate)
        );

        req.setAttribute("tasks", tasksByDate);

        req.getRequestDispatcher("/todo/calendar.jsp")
                .include(req, resp);
    }
}

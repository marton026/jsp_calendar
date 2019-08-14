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

@WebServlet(name = "TaskComplete", urlPatterns = "/todo/done")
public class TaskCompleteServlet extends HttpServlet {

    private TaskRepository taskRepository =
            new TaskHibernateRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Integer idInt = Integer.valueOf(id);

        Task task = taskRepository.findById(idInt);
        task.setCompleted(true);
        taskRepository.save(task);

        //resp.sendRedirect("/todo/list");
        resp.sendRedirect("/todo/calendar");
    }
}

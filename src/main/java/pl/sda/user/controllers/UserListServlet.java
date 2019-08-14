package pl.sda.user.controllers;

import pl.sda.user.model.User;
import pl.sda.user.repository.UserHibernateRepository;
import pl.sda.user.repository.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserList", urlPatterns = "/users/list")
public class UserListServlet extends HttpServlet {

    private UserRepository repository =
            new UserHibernateRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Content-Type",
                "text/html; charset=utf-8");
        List<User> users = repository.findAll();
        req.setAttribute("users", users);

        req.getRequestDispatcher("/users/list.jsp")
                .include(req, resp);
    }
}

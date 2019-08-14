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

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private UserRepository repository =
            new UserHibernateRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Content-Type",
                "text/html; charset=utf-8");
        req.getRequestDispatcher("/users/login.jsp")
                .include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Content-Type",
                "text/html; charset=utf-8");

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        User user = repository.findByLoginAndPassword(login, password);
        if (user != null) {
            req.getSession().setAttribute("user", user);
            resp.sendRedirect("/home");
        } else {
            req.setAttribute("errorMessage", "Błędne dane logowania");
            req.getRequestDispatcher("/users/login.jsp")
                    .include(req, resp);
        }
    }
}

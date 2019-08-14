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

@WebServlet(name = "CreateUser", urlPatterns = "/users/create")
public class CreateUserServlet extends HttpServlet {

    private UserRepository repository
            = new UserHibernateRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Content-Type",
                "text/html; charset=utf-8");
        req.getRequestDispatcher("/users/create.jsp")
                .include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Content-Type",
                "text/html; charset=utf-8");

        String login = req.getParameter("login");
        String password = req.getParameter("pass");
        String retypedPassword = req.getParameter("retype-pass");
        String name = req.getParameter("name");
        String email = req.getParameter("email");

        if(!password.equals(retypedPassword)){
            req.setAttribute("errorMessage",
                    "Hasła muszą być jednakowe");
            req.getRequestDispatcher("/users/create.jsp")
                    .include(req, resp);
            return;
        }

        User user = new User();
                user.setLogin(login);
                user.setEmail(email);
                user.setName(name);
                user.setPassword(password);

        repository.save(user);
        resp.sendRedirect("/users/list");
    }
}

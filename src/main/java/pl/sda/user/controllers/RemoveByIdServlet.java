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

@WebServlet(name = "RemoveByIdServlet",urlPatterns = "/users/del")
public class RemoveByIdServlet extends HttpServlet {

    private UserRepository userRepository = new UserHibernateRepository();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Integer idInt = Integer.valueOf(id);

        userRepository.remove(idInt);
        resp.sendRedirect("/users/list");
    }
}

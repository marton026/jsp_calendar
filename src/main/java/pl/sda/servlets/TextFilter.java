package pl.sda.servlets;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "Text Filter", urlPatterns = "/print")
public class TextFilter extends HttpFilter {

    @Override
    public void doFilter(HttpServletRequest req,
                         HttpServletResponse resp,
                         FilterChain chain) throws IOException, ServletException {
        String text = req.getParameter("text");
        if (text == null) {
            resp.sendError(400, "Missing text parameter");
        }
        req.setAttribute("text", text);
        chain.doFilter(req, resp);
    }
}

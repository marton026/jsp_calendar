package pl.sda.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

//http://localhost:9091/print?text=dfghdf&color=pink&times=22

@WebServlet(urlPatterns = "/print", name = "PrintName")
public class PrintServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp) throws ServletException, IOException {
        String text = (String) req.getAttribute("text");  //wyciągnięcie tekstu z url-a
        PrintWriter writer = resp.getWriter();
        String color = req.getParameter("color");  //przekazanie stylu przez parametr
        if (color == null && req.getCookies() != null) {  //jeżeli brak parametru "color" to czarny
            color = Arrays.stream(req.getCookies())
                    .filter(cookie -> "color".equals(cookie.getName()))
                    .findAny()
                    .map(cookie -> cookie.getValue())
                    .orElse("black");
        }
        resp.addCookie(new Cookie("color", color));

        String timesString = req.getParameter("times"); //wyciągnięcie liczby z url-a i zapisanie do zmiennej
        Integer times;
        HttpSession session = req.getSession();
        if (timesString == null) {
            times = (Integer) session.getAttribute("times");
            if(times == null){
                times = 1;
            }
        } else {
            times = Integer.valueOf(timesString);
            session.setAttribute("times", times);
        }

        writer.append("<html>");

        writer.append("<head>");
        writer.append("<title>Print</title>");
        writer.append("</head>");

        for (Integer i = 0; i < times; i++) {
            writer.append("<body>");
            writer.append("<h1 style='color: ").append(color).append("'>")
                    .append(text).append("</h1>");    //wyświetlenie "text"
            writer.append("</body>");
        }

        writer.append("</html>");
    }
}

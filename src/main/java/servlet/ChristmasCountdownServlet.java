package servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/xmas")
public class ChristmasCountdownServlet extends HttpServlet {

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		LocalDate today = LocalDate.now();
		LocalDate xmas = LocalDate.of(today.getYear(), Month.DECEMBER, 24);
		
		long daysBetween = ChronoUnit.DAYS.between(today, xmas);

        // servletiltä voidaan välittää Java-arvoja JSP-sivulle _attribuutteina_
        req.setAttribute("daysBetween", daysBetween);

        // välitetään pyyntö eteenpäin
        req.getRequestDispatcher("/WEB-INF/xmas/result.jsp").forward(req, resp);
    }
	
}

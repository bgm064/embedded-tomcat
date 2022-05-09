package servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/daysUntil")
public class DaysUntilServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// välitetään pyyntö edelleen
		req.getRequestDispatcher("/WEB-INF/daysUntil/daysUntilForm.html").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LocalDate today = LocalDate.now();
		int day = Integer.parseInt(req.getParameter("day"));
		int month = Integer.parseInt(req.getParameter("month"));
		int year = Integer.parseInt(req.getParameter("year"));

		long daysBetween = ChronoUnit.DAYS.between(today, LocalDate.of(year, month, day));

		String time = "until";
		String indicator = "th";
		String plural = "s";
		String[] monthNames = new String[] { "January", "February", "March", "April", "May", "June", "July", "August",
				"September", "October", "November", "December" };

		if (daysBetween < 0) {
			daysBetween = Math.abs(daysBetween);
			time = "since";
		}
		
		if (daysBetween == 1) {
			plural = null;
		}
		
		if (day == 1 || day == 21 || day == 31) {
			indicator = "st";
		} else if (day == 2 || day == 22) {
			indicator = "nd";
		} else if (day == 3 || day == 23) {
			indicator = "rd";
		}

		// välitetään java-arvoja jsp-sivulle attribuutteina
		req.setAttribute("daysBetween", daysBetween);
		req.setAttribute("plural", plural);
		req.setAttribute("time", time);
		req.setAttribute("day", day + indicator);
		req.setAttribute("monthName", monthNames[month - 1]);
		req.setAttribute("year", year);

		// välitetään pyyntö eteenpäin
		req.getRequestDispatcher("/WEB-INF/daysUntil/daysUntilResult.jsp").forward(req, resp);
	}

}

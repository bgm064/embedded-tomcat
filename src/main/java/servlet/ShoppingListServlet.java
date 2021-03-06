package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.JDBCShoppingListItemDao;
import database.ShoppingListItemDao;
import model.ShoppingListItem;

@SuppressWarnings("serial")
@WebServlet("/list")
public class ShoppingListServlet extends HttpServlet {
	private ShoppingListItemDao dao = new JDBCShoppingListItemDao();

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<ShoppingListItem> allItems = this.dao.getAllItems();

		req.setAttribute("items", allItems);
		req.getRequestDispatcher("/WEB-INF/shoppingList/list.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ShoppingListItem newItem = new ShoppingListItem(req.getParameter("title"));

		dao.addItem(newItem);
		resp.sendRedirect("/list");
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		long id = Long.parseLong(req.getParameter("id"));
		ShoppingListItem toDelete = this.dao.getItem(id);
		
		dao.removeItem(toDelete);
	}

}

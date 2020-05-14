package bobruisk.model.jdbc.dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "update", urlPatterns = { "/update.jsp" })
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		Connection connection = (Connection) getServletContext().getAttribute("connection");
		PrintWriter writer = response.getWriter();
		writer.append("<h2>Изменение данных.</h2>");
		writer.append("<form action='index.jsp' method='get'>");
		writer.append("<input type='submit' value='Вернуться к базе товаров'>");
		writer.append("</form>");

		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		String count = request.getParameter("count");
		int idParam = Integer.parseInt(id);
		int priceParam = 0;
		int countParam = 0;
		try {
			priceParam = Integer.parseInt(price);
			countParam = Integer.parseInt(count);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			System.out.println("Ошибка ввода данных! " + e);
			request.getRequestDispatcher("/add.jsp");
		}
		// System.out.println(idParam + " " + name + " " + priceParam + " " +
		// countParam);
		String searchQuery = "UPDATE goods SET name = ?, price = ?, count = ? where id = ?;";
		PreparedStatement statement = null;
		ResultSet result = null;
		if ((priceParam != 0) && (countParam != 0)) {
			try {
				statement = connection.prepareStatement(searchQuery);
				// устанавливаем параметры
				statement.setString(1, name);
				statement.setInt(2, priceParam);
				statement.setInt(3, countParam);
				statement.setInt(4, idParam);
				statement.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (statement != null) {
					try {
						statement.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
}

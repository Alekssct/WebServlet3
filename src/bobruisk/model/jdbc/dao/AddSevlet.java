package bobruisk.model.jdbc.dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "add", urlPatterns = { "/add" })
public class AddSevlet extends HttpServlet {
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

		String name = request.getParameter("name");
		String price = request.getParameter("price");
		String count = request.getParameter("count");
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
		String addQuery = "INSERT INTO goods (name, price, count) VALUES (?, ?, ?);";
		PreparedStatement statement = null;
		ResultSet result = null;
		if ((priceParam != 0) && (countParam != 0)) {
			try {
				statement = connection.prepareStatement(addQuery);
				// устанавливаем параметры
				statement.setString(1, name);
				statement.setInt(2, priceParam);
				statement.setInt(3, countParam);
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
}
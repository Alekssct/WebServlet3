package bobruisk.model.jdbc.dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(description = "delete", urlPatterns = { "/delete" })
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		
		Connection connection = (Connection) getServletContext().getAttribute("connection");
		PrintWriter writer = response.getWriter();
		writer.append("<h2>Данные удалены.</h2>");
		writer.append("<form action='index.jsp' method='get'>");
		writer.append("<input type='submit' value='Вернуться к базе товаров'>");
		writer.append("</form>");
		String name = request.getParameter("id");
		int param = Integer.parseInt(name);
		//System.out.println(param);
		String query = "delete from Goods where id = ?";
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(query);
			statement.setInt(1, param);
			statement.execute();
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
}

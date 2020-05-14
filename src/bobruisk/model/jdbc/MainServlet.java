package bobruisk.model.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "main", urlPatterns = { "/goods" })
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection connection = (Connection) getServletContext().getAttribute("connection");
		response.setContentType("text/html");
		
//		PrintWriter writer = response.getWriter();
//		Statement statement = null;
//		ResultSet results = null;
//		try {
//			String query = "SELECT * from Goods";
//			statement = connection.createStatement();
//			results = statement.executeQuery(query);
//			request.setAttribute("results", results);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
	}
}

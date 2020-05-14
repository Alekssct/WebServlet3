package bobruisk.model.jdbc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class InitListener implements ServletContextListener {

	public InitListener() {
	}

	public void contextDestroyed(ServletContextEvent event) {
		Connection connection = (Connection) event.getServletContext().getAttribute("connection");
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void contextInitialized(ServletContextEvent event) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Драйвер загружен успешно.");
			System.out.println("Соединение с БД установлено.");
		} catch (ClassNotFoundException e) {
			System.out.println("Соединение прервано...");
			e.printStackTrace();
		}

		String[] data = null;
		// Создаю таблицу, если не существует
//		String query = "CREATE TABLE if not exists Goods (id integer PRIMARY KEY AUTO_INCREMENT, name character(50), "
//				+ "count integer, price integer);";
//		System.out.println(query);
//		String queryAdd1 = String.format("INSERT INTO Goods (name, count, price) VALUES ('Notebook', '3', '585')");
//		String queryAdd2 = String.format("INSERT INTO Goods (name, count, price) VALUES ('Telephone', '25', '200')");
//		String queryAdd3 = String.format("INSERT INTO Goods (name, count, price) VALUES ('Videocard', '16', '190')");
		System.out.println("Сохранено");
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/goods", "root", "1111");
//			connection.createStatement().execute(query);
//			connection.createStatement().execute(queryAdd1);
//			connection.createStatement().execute(queryAdd2);
//			connection.createStatement().execute(queryAdd3);
			// сохранения ссылки на объект соединения c базой в контексте сервлетов
			event.getServletContext().setAttribute("connection", connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

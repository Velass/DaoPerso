package petFoodShop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcSingleton {
	private Connection connection = null;

	private final static JdbcSingleton INSTANCE = new JdbcSingleton();

	private JdbcSingleton() {

	}

	public static JdbcSingleton getInstance() {
		return INSTANCE;
	}

	public Connection getConnection() {
		if (connection == null) {
			try {
				Class.forName("org.mariadb.jdbc.Driver");
				connection = DriverManager.getConnection(
						"jdbc:mariadb://localhost:3307/petshop?user=admin&password=admin&allowPublicKeyRetrieval=true");
				System.out.println("test");
			} catch (SQLException e) {

				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return connection;

	}

	public void close() {
		if (connection != null) {
			try {
				connection.close();
				System.out.println("Connexion close.");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}

package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private String url = "jdbc:mysql://86.57.161.116:13306/danco_rmt_vacation";
	private String name = "aqa";
	private String password = "qwe123";

	private Connection con;

	public DBConnection() {
		try {
			con = DriverManager.getConnection(url, name, password);
			System.out.println("-----Подключение к БД прошло успешно------");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("-----Подключение к БД НЕ прошло------");
		}
	}

	public Connection getConnection() {
		return con;
	}

}

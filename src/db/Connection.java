package db;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {

	private static Connection instance = null;

	private String driverName = "com.mysql.jdbc.Driver";

	private static String USERNAME = "root"; // nome de um usuário de seu BD
	private static String PASSWORD = "123456"; // sua senha de acesso

	private java.sql.Connection conn;

	private Connection() {
		try {
			createConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public static Connection getInstance() {
		if (instance == null) {
			instance = new Connection();
		}
		return instance;
	}

	private void createConnection() throws ClassNotFoundException, SQLException {
		Class.forName(driverName);
		String serverName = "localhost"; // caminho do servidor do BD
		String mydatabase = "mysql"; // nome do seu banco de dados
		String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
		this.conn = DriverManager.getConnection(url, USERNAME, PASSWORD);
		if (this.conn != null) {
			System.out.println("Conectado!");
		} else {
			System.out.println("Não conectado!");
		}
	}

	@SuppressWarnings("unused")
	private boolean closeConnection() {
		try {
			conn.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}

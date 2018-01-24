package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnection {

	private static GetConnection instance = null;

	private String driverName = "com.mysql.jdbc.Driver";

	private static String USERNAME = "root"; // nome de um usuário de seu BD
	private static String PASSWORD = ""; // sua senha de acesso

	private static Connection conn;

	private GetConnection() {
		try {
			createConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public static Connection getInstance() {
		if (instance == null) {
			instance = new GetConnection();
		}
		return conn;
	}

	private void createConnection() throws ClassNotFoundException, SQLException {
		Class.forName(driverName);
		String serverName = "localhost"; // caminho do servidor do BD
		String mydatabase = "db"; // nome do seu banco de dados
		String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
		conn = DriverManager.getConnection(url, USERNAME, PASSWORD);
		if (conn != null) {
			System.out.println("Conectado!");
		} else {
			System.out.println("Falha ao conectar ao banco!");
			System.exit(0);
		}
	}

}

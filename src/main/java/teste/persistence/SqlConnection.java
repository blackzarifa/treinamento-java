package teste.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlConnection {
	
	private static final String URL = "jdbc:mysql://localhost:3306/treinamento";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "passwd";
	
	public static Connection getConnection() throws SQLException {
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (ClassNotFoundException e) {
			System.err.println("Driver do banco de dados não encontrado.");
			e.printStackTrace();
		}
		
		return conn;
	}
	
	
	/*
	// main para testes
	public static void main(String[] args) {
		try {
			Connection conn = getConnection();
			if (conn != null) 
				System.out.println("Sucesso!");
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}
	*/
}

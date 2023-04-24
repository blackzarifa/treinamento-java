package teste.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlConnection {
	
	private static final String URL = "jdbc:mysql://localhost:3306/treinamento";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "passwd";
	private static final String DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";
	
	private static SqlConnection sqlConnection = null; 
	
	
	// Sets driver
	private SqlConnection() {
		try {
			Class.forName(DRIVER_CLASS_NAME);
		} catch (ClassNotFoundException e) {
			System.err.println("Driver do banco de dados não encontrado.");
			e.printStackTrace();
		}
	}
	
	// Creates and stores the instance of sqlConnection
	public static SqlConnection getInstance() {
		if (sqlConnection == null)
			sqlConnection = new SqlConnection();
		
		return sqlConnection;
	}
	
	// Connects to database with URL, USERNAME and PASSWORD variables
	public Connection getConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		return conn;
	}
	
	// Closes connection
	public void closeConnection(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
				System.out.println("Conexão encerrada.");
			}
		} catch (SQLException e) {
			System.err.println("Erro ao fechar a conexão.");
			e.printStackTrace();
		}
	}
		
	
	// main for testing
	/*
	 * public static void main(String[] args) { SqlConnection sqlConn =
	 * SqlConnection.getInstance(); Connection conn = null;
	 * 
	 * try { conn = sqlConn.getConnection();
	 * System.out.println("Conexão estabelecida com sucesso."); } catch
	 * (SQLException e) {
	 * System.err.println("Erro ao conectar com o banco de dados.");
	 * e.printStackTrace(); } finally { sqlConn.closeConnection(conn); } }
	 */
	 
}

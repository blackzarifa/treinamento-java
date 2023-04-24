package teste.persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class EstudanteDAO {
	
	Connection conn = null;
	PreparedStatement pstm = null;
	
	
	// Connect to database
	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = SqlConnection.getInstance().getConnection();
		return conn;
	}
	
	
	
	
	
	/*
	public static void setConnection(Connection connection) {
		conn = connection;
		
		try {
			pstm = conn.createStatement();
		} catch (SQLException e) {
			System.err.println("Erro criando a declaração.");
			e.printStackTrace();
		}
	}
	
	public static void execute(String query) {
		try {
			pstm.execute(query);
		} catch (SQLException e) {
			System.err.println("Erro executando a query.");
			e.printStackTrace();
		}
		System.out.println("Query executada.");
	}
	*/
	
	
	
	// main para testes
	/*
	 * public static void main(String[] args) { Connection conn = null; try { conn =
	 * SqlConnection.getConnection(); } catch (SQLException e) {
	 * System.err.println(e.getMessage()); e.printStackTrace(); }
	 * 
	 * setConnection(conn); String query = "select * from curso"; execute(query); }
	 */
	
}

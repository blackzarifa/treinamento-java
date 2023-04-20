package teste.persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlStatement {
	
	private static Connection conn = null;
	private static Statement stmt = null;
	
	public static void setConnection(Connection connection) {
		conn = connection;
		
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			System.err.println("Erro criando a declaração.");
			e.printStackTrace();
		}
	}
	
	public static void execute(String query) {
		try {
			stmt.execute(query);
		} catch (SQLException e) {
			System.err.println("Erro executando a query.");
			e.printStackTrace();
		}
		System.out.println("Query executada.");
	}
	
	
	
	// main para testes
	public static void main(String[] args) {
		Connection conn = null;
		try {
			conn = SqlConnection.getConnection();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		
		setConnection(conn);
		String query = "select * from curso";
		execute(query);
	}
	
}

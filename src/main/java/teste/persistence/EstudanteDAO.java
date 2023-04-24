package teste.persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class EstudanteDAO {
	
	Connection conn = null;
	PreparedStatement pstm = null;
	
	
	// Connect to database
	private Connection getConnection() throws SQLException {
		return SqlConnection.getInstance().getConnection();
	}
	
	
	// Add to database
	public void add(EstudanteBean estudanteBean) {		
		try {
			String queryString = "INSERT INTO estudente(id, nome, matricula, aniversario, FK_curso) VALUES(?,?,?,?,?)";
			
			conn = getConnection();
			pstm = conn.prepareStatement(queryString);
			
			pstm.setInt(1, estudanteBean.getId());
			pstm.setString(2, estudanteBean.getNome());
			pstm.setString(3, estudanteBean.getMatricula());
			pstm.setDate(4, estudanteBean.getAniversario());
			pstm.setInt(5, estudanteBean.getFK_curso());
			
			pstm.executeUpdate();
			System.out.println("Estudante adicionado com sucesso.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
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

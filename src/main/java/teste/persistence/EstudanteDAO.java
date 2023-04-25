package teste.persistence;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class EstudanteDAO {
	
	Connection conn = null;
	PreparedStatement pstm = null;
	
	
	// Connect to database
	private Connection getConnection() throws SQLException {
		return SqlConnection.getInstance().getConnection();
	}
	
	// Close connection
	private void closeConnection(Connection conn, PreparedStatement pstm) {
		try {
	        if (pstm != null)
	            pstm.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    try {
	        if (conn != null)
	            conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	
	// Add to database
	public void add(EstudanteBean estudanteBean) {		
		try {
			String queryString = "INSERT INTO estudante(id, nome, matricula, aniversario, FK_curso) VALUES(?,?,?,?,?)";
			
			conn = getConnection();
			pstm = conn.prepareStatement(queryString);
			
			pstm.setInt(1, estudanteBean.getId());
			pstm.setString(2, estudanteBean.getNome());
			pstm.setString(3, estudanteBean.getMatricula());
			pstm.setDate(4, estudanteBean.getAniversario());
			pstm.setInt(5, estudanteBean.getFK_curso());
			
			pstm.executeUpdate();
			System.out.println("Estudante adicionado.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(conn, pstm);
		}
	}
	
	// Update database
	public void update(EstudanteBean estudanteBean) {
		try {
			String queryString = "UPDATE estudante SET nome=?, matricula=?, aniversario=?, FK_curso=? WHERE id=?";
			
			conn = getConnection();
			pstm = conn.prepareStatement(queryString);
			
			pstm.setString(1, estudanteBean.getNome());
			pstm.setString(2, estudanteBean.getMatricula());
			pstm.setDate(3, estudanteBean.getAniversario());
			pstm.setInt(4, estudanteBean.getFK_curso());
			pstm.setInt(5, estudanteBean.getId());
			
			pstm.executeUpdate();
			System.out.println("Estudante atualizado.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(conn, pstm);
		}
	}
	
	// Delete from database
	public void delete(EstudanteBean estudanteBean) {
		try {
			String queryString = "DELETE FROM estudante WHERE id=?";
			
			conn = getConnection();
			pstm = conn.prepareStatement(queryString);
			
			pstm.setInt(1, estudanteBean.getId());
			
			pstm.executeUpdate();
			System.out.println("Dados deletados.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(conn, pstm);
		}
	}
	
	// Find all from table
	public void findAll() {
		ResultSet resultSet = null;
		
		try {
			String queryString = "SELECT * FROM estudante";
			
			conn = getConnection();
			pstm = conn.prepareStatement(queryString);
			
			resultSet = pstm.executeQuery();
			
			while (resultSet.next()) {
				System.out.println("ID: " + resultSet.getInt("id")
								+ ", Nome: " + resultSet.getString("nome")
								+ ", Matricula: " + resultSet.getString("matricula")
								+ ", Aniversario: " + resultSet.getDate("aniversario")
								+ ", ID-Curso: " + resultSet.getInt("FK_curso"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(conn, pstm);
		}
	}
	
	
	
	// main for testing
	 public static void main(String[] args) {
		 EstudanteDAO dao = new EstudanteDAO();
		 dao.findAll();
		 System.out.println("-------------------------------------------------");
		 EstudanteBean estudante1 = new EstudanteBean(10, "Test", "123456", Date.valueOf("2000-01-01"), 1);
		 dao.add(estudante1);
		 dao.findAll();
		 System.out.println("-------------------------------------------------");
		 dao.delete(estudante1);
		 dao.findAll();
	 } 
	 
	
}

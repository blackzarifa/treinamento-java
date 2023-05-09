package teste.persistence;

import teste.entity.EstudanteBean;

import java.sql.Connection;
//import java.sql.Date;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;


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
			String queryString = "INSERT INTO estudante"
					+ "(nome, matricula, aniversario, FK_curso, semestre, presencial) "
					+ "VALUES(?,?,?,?)";
			
			conn = getConnection();
			pstm = conn.prepareStatement(queryString);
			
			pstm.setString(1, estudanteBean.getNome());
			pstm.setString(2, estudanteBean.getMatricula());
			pstm.setDate(3, estudanteBean.getAniversario());
			pstm.setInt(4, estudanteBean.getFK_curso());
			pstm.setInt(5, estudanteBean.getSemestre());
			pstm.setBoolean(6, estudanteBean.isPresencial());
			
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
			String queryString = "UPDATE estudante "
					+ "SET nome=?, matricula=?, aniversario=?, FK_curso=?, semestre=?, presencial=? "
					+ "WHERE id=?";
			
			conn = getConnection();
			pstm = conn.prepareStatement(queryString);
			
			pstm.setString(1, estudanteBean.getNome());
			pstm.setString(2, estudanteBean.getMatricula());
			pstm.setDate(3, estudanteBean.getAniversario());
			pstm.setInt(4, estudanteBean.getFK_curso());
			pstm.setInt(5, estudanteBean.getSemestre());
			pstm.setBoolean(6, estudanteBean.isPresencial());
			pstm.setInt(7, estudanteBean.getId());
			
			pstm.executeUpdate();
			System.out.println("Estudante atualizado.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(conn, pstm);
		}
	}
	
	// Delete from database
	public void delete(int id) {
		try {
			String queryString = "DELETE FROM estudante WHERE id=?";
			
			conn = getConnection();
			pstm = conn.prepareStatement(queryString);
			
			pstm.setInt(1, id);
			
			pstm.executeUpdate();
			System.out.println("Dados deletados.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(conn, pstm);
		}
	}
	
	// Find all from table
	public List<EstudanteBean> findAll() {
		ResultSet resultSet = null;
		List<EstudanteBean> estudantes = new ArrayList<>();
		
		try {
			String queryString = "SELECT * FROM estudante";
			
			conn = getConnection();
			pstm = conn.prepareStatement(queryString);
			
			resultSet = pstm.executeQuery();
			
			while (resultSet.next()) {
				EstudanteBean estudante = new EstudanteBean();
				estudante.setId(resultSet.getInt("id"));
				estudante.setNome(resultSet.getString("nome"));
	            estudante.setMatricula(resultSet.getString("matricula"));
	            estudante.setAniversario(resultSet.getDate("aniversario"));
	            estudante.setFK_curso(resultSet.getInt("FK_curso"));
	            estudante.setSemestre(resultSet.getInt("semestre"));
	            estudante.setPresencial(resultSet.getBoolean("presencial"));
	            
	            estudantes.add(estudante);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(conn, pstm);
		}
		
		return estudantes;
	}
	 
}

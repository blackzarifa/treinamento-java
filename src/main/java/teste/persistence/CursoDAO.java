package teste.persistence;

import teste.entity.CursoBean;
import teste.entity.EstudanteBean;

import java.sql.Connection;
//import java.sql.Date;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;


public class CursoDAO {
	
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
	public void add(CursoBean cursoBean) {
		try {
			String queryString = "INSERT INTO curso(id, nome) VALUES(?,?)";
			
			conn = getConnection();
			pstm = conn.prepareStatement(queryString);
			
			pstm.setInt(1, cursoBean.getId());
			pstm.setString(2, cursoBean.getNome());
			
			pstm.executeUpdate();
			System.out.println("Curso adicionado.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(conn, pstm);
		}
	}
	
	// Update database
	public void update(CursoBean cursoBean) {
		try {
			String queryString = "UPDATE curso SET nome=? WHERE id=?";
			
			conn = getConnection();
			pstm = conn.prepareStatement(queryString);
			
			pstm.setString(1, cursoBean.getNome());
			
			pstm.executeUpdate();
			System.out.println("Curso atualizado.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(conn, pstm);
		}
	}
	
	// Delete from database
	public void delete(CursoBean cursoBean) {
		try {
			String queryString = "DELETE FROM curso WHERE id=?";
			
			conn = getConnection();
			pstm = conn.prepareStatement(queryString);
			
			pstm.setInt(1, cursoBean.getId());
			
			pstm.executeUpdate();
			System.out.println("Dados deletados.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(conn, pstm);
		}
	}
	
	// Find all from table
	public List<CursoBean> findAll() {
		ResultSet resultSet = null;
		List<CursoBean> cursos = new ArrayList<>();
		
		try {
			String queryString = "SELECT * FROM curso";
			
			conn = getConnection();
			pstm = conn.prepareStatement(queryString);
			
			resultSet = pstm.executeQuery();
			
			while (resultSet.next()) {
				CursoBean curso = new CursoBean();
				curso.setId(resultSet.getInt("id"));
				curso.setNome(resultSet.getString("nome"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(conn, pstm);
		}
		
		return cursos;
	}

}

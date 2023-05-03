package teste.rest;

import teste.persistence.CursoDAO;
import teste.entity.CursoBean;

import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.PathParam;

import java.util.List;


@Path("/cursos")
public class CursoService extends superRest {
	
	private CursoDAO dao;
	
	public CursoService() {
		dao = new CursoDAO();
	}
	
	
	@Path("/getall")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<CursoBean> getAll() {
		List<CursoBean> cursos = dao.findAll();
		return cursos;
	}
	
	@Path("/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public CursoBean getById(@PathParam("id") int id) {
		CursoBean curso = dao.findById(id);
		return curso;
	}
	
}
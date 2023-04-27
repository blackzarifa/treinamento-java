package teste.rest;

import teste.persistence.EstudanteDAO;
import teste.entity.EstudanteBean;

import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.List;


@Path("/estudantes")
public class EstudanteService extends superRest {
	
	private EstudanteDAO dao;
	
	public EstudanteService() {
		dao = new EstudanteDAO();
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<EstudanteBean> getAll() {
		List<EstudanteBean> estudantes = dao.findAll();
		return estudantes;
	}
}

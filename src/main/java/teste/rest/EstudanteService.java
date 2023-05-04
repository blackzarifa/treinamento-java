package teste.rest;

import teste.persistence.EstudanteDAO;
import teste.entity.EstudanteBean;

import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.List;
import java.sql.Date;


@Path("/estudantes")
public class EstudanteService extends superRest {
	
	private EstudanteDAO dao;
	
	public EstudanteService() {
		dao = new EstudanteDAO();
	}
	
	
	@Path("/getall")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<EstudanteBean> getAll() {
		List<EstudanteBean> estudantes = dao.findAll();
		return estudantes;
	}
	
	@Path("/add")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response add(EstudanteBean estudante) {		
		EstudanteDAO dao = new EstudanteDAO();
		dao.add(estudante);
		
		return Response.ok().build();
	}
	
	@Path("/update")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(EstudanteBean estudante) {
		EstudanteDAO dao = new EstudanteDAO();
		dao.update(estudante);
		
		return Response.ok().build();
	}
	
	@Path("/delete")
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public Response delete(EstudanteBean estudante) {
		EstudanteDAO dao = new EstudanteDAO();
		dao.delete(estudante);
		
		return Response.ok().build();
	}
	
}

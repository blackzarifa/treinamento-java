package teste.rest;

import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import teste.persistence.EstudanteDAO;

@Path("/estudantes")
public class EstudanteService {
	
	private EstudanteDAO dao;
	
	public EstudanteService() {
		dao = new EstudanteDAO();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String test() {
		return "TESTTESTTESTTESTTESTTESTTESTTESTTESTTESTTESTTESTTESTTESTTEST";
	}
	
}

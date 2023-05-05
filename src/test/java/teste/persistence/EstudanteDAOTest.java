package teste.persistence;

import teste.entity.EstudanteBean;
import teste.rest.EstudanteService;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class EstudanteDAOTest {

	EstudanteDAO dao;
	EstudanteBean estudante;
	
	@BeforeAll 
	static void setUp() {
		System.out.println("Starting tests.");
	}
	
	@BeforeEach
	void init() {
		dao = new EstudanteDAO();
	}
	
}

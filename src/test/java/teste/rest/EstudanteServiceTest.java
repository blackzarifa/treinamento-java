package teste.rest;

import teste.entity.EstudanteBean;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.util.List;
import java.util.ArrayList;

class EstudanteServiceTest {
	
	EstudanteService estudanteService;
	
	@BeforeAll
	static void setUp() {
		System.out.println("Starting tests.");
	}
	
	@BeforeEach
	void init() {
		estudanteService = new EstudanteService();
	}
	
	@Test
	void testGetAll() {
		EstudanteBean expectedEstudante = new EstudanteBean(1, "João", "01234567", Date.valueOf("2000-01-01"), 1);
		
		List<EstudanteBean> actualEstudantes = estudanteService.getAll();
		System.out.println(actualEstudantes.get(0));
		System.out.println(expectedEstudante);
		
		Assertions.assertEquals(expectedEstudante, actualEstudantes.get(0));
	}
	
	@AfterAll
	static void tearDown() {
		System.out.println("Finished tests.");
	}

}

package teste.rest;

import teste.entity.EstudanteBean;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Date;


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
		EstudanteBean expectedEstudante = new EstudanteBean(
				1, "João", "01234567", Date.valueOf("2000-01-01"), 1, 3, true);
		EstudanteBean actualEstudante = estudanteService.getAll().get(0);
		
		Assertions.assertAll(
				() -> assertEquals(expectedEstudante.getId(), actualEstudante.getId(), "'ID' is not equal."),
				() -> assertEquals(expectedEstudante.getNome(), actualEstudante.getNome(), "'Nome' is not equal."), 
				() -> assertEquals(expectedEstudante.getMatricula(), actualEstudante.getMatricula(), "'Matricula' is not equal."),
				() -> assertEquals(expectedEstudante.getAniversario(), actualEstudante.getAniversario(), "'Aniversario' is not equal."),
				() -> assertEquals(expectedEstudante.getFK_curso(), actualEstudante.getFK_curso(), "'FK_curso' is not equal."),
				() -> assertEquals(expectedEstudante.getSemestre(), actualEstudante.getSemestre(), "'Semestre' is not equal."),
				() -> assertEquals(expectedEstudante.isPresencial(), actualEstudante.isPresencial(), "'Presencial' is not equal.")
			);
	}
	
	@AfterAll
	static void tearDown() {
		System.out.println("Finished tests.");
	}

}

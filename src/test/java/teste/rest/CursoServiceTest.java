package teste.rest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import teste.entity.CursoBean;


class CursoServiceTest {

CursoService cursoService;
	
	@BeforeAll
	static void setUp() {
		System.out.println("Starting tests.");
	}
	
	@BeforeEach
	void init() {
		cursoService = new CursoService();
	}
	
	@Test
	void testGetAll() {
		CursoBean expectedCurso = new CursoBean(1, "Ciência da Computação");
		CursoBean actualCurso = cursoService.getAll().get(0);
		
		Assertions.assertAll(
				() -> assertEquals(expectedCurso.getId(), actualCurso.getId(), "'ID' is not equal."),
				() -> assertEquals(expectedCurso.getNome(), actualCurso.getNome(), "'Nome' is not equal.")
			);
	}
	
	@Test
	void testGetById() {
		CursoBean expectedCurso = new CursoBean(1, "Ciência da Computação");
		CursoBean actualCurso = cursoService.getById(1);
		
		Assertions.assertAll(
				() -> assertEquals(expectedCurso.getId(), actualCurso.getId(), "'ID' is not equal."),
				() -> assertEquals(expectedCurso.getNome(), actualCurso.getNome(), "'Nome' is not equal.")
			);
	}
	
	@AfterAll
	static void tearDown() {
		System.out.println("Finished tests.");
	}

}

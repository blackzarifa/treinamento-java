package teste.entity;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class EstudanteBeanTest {
	
	@BeforeAll
	static void setUp() {
		System.out.println("Starting tests.");
	}

	@Test
	void testGettersAndSetters() {
		EstudanteBean estudante = new EstudanteBean();
		estudante.setId(100);
		estudante.setNome("test");
		estudante.setMatricula("000");
		estudante.setAniversario(Date.valueOf("2000-01-01"));
		estudante.setFK_curso(1);
		estudante.setSemestre(3);
		estudante.setPresencial(true);
		
		Assertions.assertAll(
				"GettersAndSetters",
				() -> assertEquals(100, estudante.getId()),
				() -> assertEquals("test", estudante.getNome()),
				() -> assertEquals("000", estudante.getMatricula()),
				() -> assertEquals(Date.valueOf("2000-01-01"), estudante.getAniversario()),
				() -> assertEquals(1, estudante.getFK_curso()),
				() -> assertEquals(3, estudante.getSemestre()),
				() -> assertEquals(true, estudante.isPresencial())
			);
	}
	
	@Test
	void testConstructor_4() {
		EstudanteBean estudante = new EstudanteBean("test", "000", Date.valueOf("2000-01-01"), 1, 3, true);
		
		Assertions.assertAll(
				"Constructor_4",
				() -> assertEquals(0, estudante.getId()),
				() -> assertEquals("test", estudante.getNome()),
				() -> assertEquals("000", estudante.getMatricula()),
				() -> assertEquals(Date.valueOf("2000-01-01"), estudante.getAniversario()),
				() -> assertEquals(1, estudante.getFK_curso()),
				() -> assertEquals(3, estudante.getSemestre()),
				() -> assertEquals(true, estudante.isPresencial())
			);
	}
	
	@Test
	void testConstructor_5() {
		EstudanteBean estudante = new EstudanteBean(100, "test", "000", Date.valueOf("2000-01-01"), 1, 3, true);
		
		Assertions.assertAll(
				"Constructor_5",
				() -> assertEquals(100, estudante.getId()),
				() -> assertEquals("test", estudante.getNome()),
				() -> assertEquals("000", estudante.getMatricula()),
				() -> assertEquals(Date.valueOf("2000-01-01"), estudante.getAniversario()),
				() -> assertEquals(1, estudante.getFK_curso()),
				() -> assertEquals(3, estudante.getSemestre()),
				() -> assertEquals(true, estudante.isPresencial())
			);
	}
	
	@AfterAll
	static void tearDown() {
		System.out.println("Finished tests.");
	}

}

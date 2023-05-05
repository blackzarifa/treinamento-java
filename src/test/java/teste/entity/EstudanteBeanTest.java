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
		estudante.setId(0);
		estudante.setNome("test");
		estudante.setMatricula("000");
		estudante.setAniversario(Date.valueOf("2000-01-01"));
		estudante.setFK_curso(1);
		
		Assertions.assertAll(
				"EstudanteBean",
				() -> assertEquals(0, estudante.getId()),
				() -> assertEquals("test", estudante.getNome()),
				() -> assertEquals("000", estudante.getMatricula()),
				() -> assertEquals(Date.valueOf("2000-01-01"), estudante.getAniversario()),
				() -> assertEquals(1, estudante.getFK_curso())
			);
	}
	
	@AfterAll
	static void tearDown() {
		System.out.println("Finished tests.");
	}

}

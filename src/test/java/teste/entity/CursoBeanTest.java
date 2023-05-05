package teste.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CursoBeanTest {

	@BeforeAll
	static void setUp() {
		System.out.println("Starting tests.");
	}
	
	@Test
	void testGettersAndSetters() {
		CursoBean curso = new CursoBean();
		curso.setId(100);
		curso.setNome("test");
		
		Assertions.assertAll(
				"GettersAndSetters",
				() -> assertEquals(100, curso.getId()),
				() -> assertEquals("test", curso.getNome())
			);
	}
	
	@Test
	void testConstructor() {
		CursoBean curso = new CursoBean(100, "test");
		
		Assertions.assertAll(
				"Constructor",
				() -> assertEquals(100, curso.getId()),
				() -> assertEquals("test", curso.getNome())
			);
	}
	
	@AfterAll
	static void tearDown() {
		System.out.println("Finished tests.");
	}

}

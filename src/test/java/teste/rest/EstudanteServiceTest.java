package teste.rest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
	
	@AfterAll
	static void tearDown() {
		System.out.println("Finished tests.");
	}

}

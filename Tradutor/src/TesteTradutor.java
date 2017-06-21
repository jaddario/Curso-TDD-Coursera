import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TesteTradutor {
	private Tradutor tradutor;
	
	@Before
	public void criaTradutor(){
		 tradutor = new Tradutor();
	}

	@Test
	public void tradutorSemPalavras() {
		assertTrue(tradutor.estaVazio());
	}
	
	@Test
	public void tradutorUmaPalavra() {
		tradutor.adicionaTraducao("Bom","Good");
		assertFalse(tradutor.estaVazio());
		assertEquals("Good", tradutor.traduzir("Bom"));
	}
	
	@Test
	public void tradutorDuasTraducoes() {
		tradutor.adicionaTraducao("Bom","Good");
		tradutor.adicionaTraducao("Mau","Bad");
		assertEquals("Good", tradutor.traduzir("Bom"));
		assertEquals("Bad", tradutor.traduzir("Mau"));
	}
	
	@Test
	public void tradutorDuasTraducoesMesmaPalavra() {
		tradutor.adicionaTraducao("Bom","Good");
		tradutor.adicionaTraducao("Bom","Nice");
		assertEquals("Good, Nice", tradutor.traduzir("Bom"));
	}

}

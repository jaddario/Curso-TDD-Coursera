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
	
	@Test
	public void traduzirFrase(){
		tradutor.adicionaTraducao("Guerra","War");
		tradutor.adicionaTraducao("é","is");
		tradutor.adicionaTraducao("ruim", "bad");
		assertEquals("War is bad", tradutor.traduzirFrase("Guerra é ruim"));
	}
	
	@Test
	public void traduzirFraseComDuasTraducoesMesmaPalavra(){
		tradutor.adicionaTraducao("Paz","Peace");
		tradutor.adicionaTraducao("é","is");
		tradutor.adicionaTraducao("bom", "good");
		tradutor.adicionaTraducao("bom", "nice");
		assertEquals("Peace is good", tradutor.traduzirFrase("Paz é bom"));
	}
	

}

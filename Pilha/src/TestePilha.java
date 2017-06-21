import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestePilha {
	private Pilha pilha;
	
	
	@Before
	public void inicializaPilha(){
		pilha = new Pilha(10);
	}

	@Test
	public void pilhaVazia() {
		assertTrue(pilha.estaVazia());
		assertEquals(0, pilha.tamanho());
	}
	
	@Test
	public void empilhaUmElemento() {
		pilha.empilha("Primeiro");
		assertFalse(pilha.estaVazia());
		assertEquals(1, pilha.tamanho());
		assertEquals("Primeiro", pilha.topo());
	}
	
	@Test
	public void empilhaEDesempilha() {
		pilha.empilha("Primeiro");
		pilha.empilha("Segundo");
		assertEquals(2, pilha.tamanho());
		assertEquals("Segundo", pilha.topo());
		Object desempilhado = pilha.desempilha();
		assertEquals(1, pilha.tamanho());
		assertEquals("Primeiro", pilha.topo());
		assertEquals("Segundo", desempilhado);
	}
	
	@Test(expected=PilhaVaziaException.class)
	public void desempilhaDaPilhaVazia(){
		pilha.desempilha();
	}
	
	@Test
	public void empilhaComPilhaCheia(){
		for (int i = 0; i < 10; i++) {
			pilha.empilha("elemento"+ i);
		}
		try {
			pilha.empilha("boom");
			fail();
		} catch (PilhaCheiaException e) {}
	}

}

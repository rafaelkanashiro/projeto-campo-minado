package br.com.rafaelkanashiro.cm.modelo;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.rafaelkanashiro.cm.excecao.ExplosaoException;

class TabuleiroTeste {
	Tabuleiro tabuleiro, tabuleiro2, tabuleiro3, tabuleiro4;

	@BeforeEach
	void inicializarTabuleiro() {
		tabuleiro = new Tabuleiro(6, 6, 3);
	}

	@Test
	void testeTabuleiro() {
		assertEquals(36, tabuleiro.getCampos().size());
	}

	@Test
	void testarAbrirCampo() {
		tabuleiro.abrir(0, 0);
		assertTrue(tabuleiro.isAberto(0, 0));
	}

	@Test
	void testarAbrirCampoMinado() {
		tabuleiro2 = new Tabuleiro(1, 1, 1);
		
		ExplosaoException excecao = assertThrows(ExplosaoException.class, () -> tabuleiro2.abrir(0, 0));
		
		assertNotNull(excecao);
		assertTrue(tabuleiro2.todosOsCamposEstaoAbertos());
	}
	
	@Test
	void testarObjetivoAlcancado() {
		tabuleiro3 = new Tabuleiro(1,1,0);
		tabuleiro3.abrir(0, 0);
		assertTrue(tabuleiro3.objetivoAlcancado());
	}
	
	@Test
	void testarAlternarMarcacao() {
		//Quando é marcado um campo não existente
		assertDoesNotThrow(() -> {
	        tabuleiro.alternarMarcacao(100, 100);
	    });
		
		tabuleiro.alternarMarcacao(5, 5); 
	    assertTrue(tabuleiro.isMarcado(5, 5));
	}
	
	@Test
	void testarReiniciar() {
		tabuleiro.abrir(0, 0);
		tabuleiro.reiniciar();
		assertFalse(tabuleiro.isAberto(0, 0));
		
		tabuleiro.alternarMarcacao(0, 0);
		tabuleiro.reiniciar();
		assertFalse(tabuleiro.isMarcado(0, 0));
	}
	
	@Test
	void testarMetodosGet() {
		assertEquals(6, tabuleiro.getColunas());
		assertEquals(6, tabuleiro.getLinhas());
		assertEquals(3, tabuleiro.getMinas());
	}
	
	@Test
	void testarToString() {
		tabuleiro4 = new Tabuleiro(1,2,1);
		Tabuleiro tabuleiro4 = new Tabuleiro(1, 2, 1); 
	    String esperado = "0 \n? 0\n? 1\n";
	    assertEquals(esperado, tabuleiro4.toString());
	}
	
}

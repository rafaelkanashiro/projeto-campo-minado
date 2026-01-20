package br.com.rafaelkanashiro.cm.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.rafaelkanashiro.cm.excecao.ExplosaoException;

class CampoTeste {

	private Campo campo;
	
	@BeforeEach
	void inicializarCampo() {
		campo = new Campo(3,3);
	}
	
	@Test
	void testeValidarCampoVizinho() {
		Campo vizinho = new Campo(3,4);
		boolean campoVizinhoVerdadeiro = campo.adicionarVizinho(vizinho);
		assertTrue(campoVizinhoVerdadeiro);
	}
	
	@Test
	void testeValidarCampoVizinhoDiagonal() {
		Campo vizinho = new Campo(4,4);
		boolean campoVizinhoVerdadeiro = campo.adicionarVizinho(vizinho);
		assertTrue(campoVizinhoVerdadeiro);
	}
	
	@Test
	void testeValidarNaoVizinho() {
		Campo vizinho = new Campo(5,5);
		boolean campoVizinhoVerdadeiro = campo.adicionarVizinho(vizinho);
		assertFalse(campoVizinhoVerdadeiro);
	}
	
	@Test
	void testeValorPadraoMarcacao() {
		assertFalse(campo.isMarcado());
	}
	
	@Test
	void testeAlternarMarcacao() {
		campo.alternarMarcacao();
		assertTrue(campo.isMarcado());
	}
	
	@Test
	void testeAlternarMarcacaoValorPadrao() {
		campo.alternarMarcacao();
		campo.alternarMarcacao();
		assertFalse(campo.isMarcado());
	}
	
	@Test
	void testeNaoMarcadoNaoMinado() {
		assertTrue(campo.abrir());
	}
	
	@Test
	void testeMarcadoNaoMinado() {
		campo.alternarMarcacao();
		assertFalse(campo.abrir());
	}
	
	@Test
	void testeMarcadoMinado() {
		campo.minar();
		campo.alternarMarcacao();
		assertFalse(campo.abrir());
	}
	
	@Test
	void testeNaoMarcadoMinado() {
		campo.minar();
		
		assertThrows(ExplosaoException.class, () -> campo.abrir());
	}
	
	@Test
	void testeAbrirVizinhos() {
		Campo campo1 = new Campo(1,1);
		Campo campo2 = new Campo(2,2);
		
		campo2.adicionarVizinho(campo1);
		campo.adicionarVizinho(campo2);
		
		campo.abrir();
		
		assertTrue(campo1.isAberto() && campo2.isAberto());
	}
	
	@Test
	void testeAbrirVizinhosUmMinado() {
		Campo campo1 = new Campo(1,1);
		Campo campo2 = new Campo(2,2);
		campo1.minar();
		
		campo2.adicionarVizinho(campo1);
		campo.adicionarVizinho(campo2);
		
		campo.abrir();
		
		assertTrue(campo1.isFechado() && campo2.isAberto());
	}
	
	@Test
	void testarLinha() {
		assertEquals(3, campo.getLinha());
	}
	
	@Test
	void testarColuna() {
		assertEquals(3, campo.getColuna());
	}
	
	@Test
	void validarFechado() {
		assertTrue(campo.isFechado());
	}
	
	@Test
	void validarObjetivoAlcancadoDesvendado() {
		campo.abrir();
		assertTrue(campo.objetivoAlcancado());
	}
	
	@Test
	void validarObjetivoAlcancadoProtegido() {
		campo.minar();
		campo.alternarMarcacao();
		assertTrue(campo.objetivoAlcancado());
	}
	
	@Test
	void validarObjetivoNaoAlcancado() {
	    assertFalse(campo.objetivoAlcancado());
	}
	
	@Test
	void validarCampoMinadoNaoProtegido() {
	    campo.minar();
	    assertFalse(campo.objetivoAlcancado());
	}
	
	@Test
	void validarVizinhosMinados() {
		Campo campo1 = new Campo(3,4);
		Campo campo2 = new Campo(3,5);
		
		campo.adicionarVizinho(campo1);
		campo1.adicionarVizinho(campo2);
		
		campo2.minar();
		
		assertEquals(1, campo1.minasNaVizinhanca());
	}
	
	@Test
	void validarReiniciar() {
		campo.abrir();
		campo.reiniciar();
		assertFalse(campo.isAberto());
		
		campo.minar();
		campo.alternarMarcacao();
		campo.reiniciar();
		assertFalse(campo.isMinado());
		assertFalse(campo.isAberto());
	}
	
	@Test
	void validarStringCampoMarcado() {
		campo.alternarMarcacao();
		assertEquals("x", campo.toString());
	}
	
	@Test
	void validarStringVizinhoMinado() {
		Campo campo1 = new Campo(3,4);
		campo1.minar();
		campo.adicionarVizinho(campo1);
		assertEquals(1, campo.minasNaVizinhanca());
	}
	
	@Test
	void validarStringCampoAberto() {
		campo.abrir();
		assertEquals(" ", campo.toString());
	}
	
	@Test
	void validarCampoInicial() {
		assertEquals("?", campo.toString());
	}
}

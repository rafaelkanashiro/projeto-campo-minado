package br.com.rafaelkanashiro.cm.modelo;

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
}

package br.com.rafaelkanashiro.cm.modelo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

}

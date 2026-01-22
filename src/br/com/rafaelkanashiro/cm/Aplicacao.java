package br.com.rafaelkanashiro.cm;

import br.com.rafaelkanashiro.cm.modelo.Tabuleiro;
import br.com.rafaelkanashiro.cm.visao.TabuleiroConsole;

public class Aplicacao {

	public static void main(String[] args) {
		
		Tabuleiro tabuleiro = new Tabuleiro(6, 6, 6);
		new TabuleiroConsole(tabuleiro);
	}
}

package br.com.rafaelkanashiro.cm;

import br.com.rafaelkanashiro.cm.modelo.Tabuleiro;
import br.com.rafaelkanashiro.cm.visao.TabuleiroConsole;

public class Aplicacao {

	public static void main(String[] args) {
		
		Tabuleiro tabuleiro = new Tabuleiro(12, 12, 25);
		new TabuleiroConsole(tabuleiro);
	}
}

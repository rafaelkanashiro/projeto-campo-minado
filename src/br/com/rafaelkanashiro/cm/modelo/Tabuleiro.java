package br.com.rafaelkanashiro.cm.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import br.com.rafaelkanashiro.cm.excecao.ExplosaoException;

public class Tabuleiro {
	private int colunas;
	private int linhas;
	private int minas;

	private final List<Campo> campos = new ArrayList<>();

	public Tabuleiro(int colunas, int linhas, int minas) {
		this.colunas = colunas;
		this.linhas = linhas;
		this.minas = minas;

		gerarCampos();
		associarVizinhos();
		sortearMinas();
	}
	
	public int getColunas() {
		return colunas;
	}

	public int getLinhas() {
		return linhas;
	}

	public int getMinas() {
		return minas;
	}

	public List<Campo> getCampos() {
		return campos;
	}
	
	public boolean isAberto(int linha, int coluna) {
	    return campos.stream()
	        .anyMatch(c ->
	            c.getLinha() == linha &&
	            c.getColuna() == coluna &&
	            c.isAberto()
	        );
	}
	
	public boolean isMarcado(int linha, int coluna) {
	    return campos.stream()
	        .anyMatch(c ->
	            c.getLinha() == linha &&
	            c.getColuna() == coluna &&
	            c.isMarcado()
	        );
	}
	
	public boolean todosOsCamposEstaoAbertos() {
		return campos.stream().allMatch(c -> c.isAberto());
	}

	public void abrir(int linha, int coluna) {
		try {
			campos.stream().filter(c -> c.getLinha() == linha && c.getColuna() == coluna).findFirst()
			.ifPresent(Campo::abrir);
		} catch (ExplosaoException e) {
			campos.forEach(c -> c.setAberto(true));
			throw e;
		}

	}

	public void alternarMarcacao(int linha, int coluna) {
		campos.stream().filter(c -> c.getLinha() == linha && c.getColuna() == coluna).findFirst()
				.ifPresent(Campo::alternarMarcacao);
	}

	private void gerarCampos() {
		for (int linha = 0; linha < linhas; linha++) {
			for (int coluna = 0; coluna < colunas; coluna++) {
				campos.add(new Campo(linha, coluna));
			}
		}
	}

	private void associarVizinhos() {
		for (Campo campo1 : campos) {
			for (Campo campo2 : campos) {
				campo1.adicionarVizinho(campo2);
			}
		}
	}

	private void sortearMinas() {
		long minasArmadas = 0;
		Predicate<Campo> minado = c -> c.isMinado();

		while (minasArmadas < minas){
			int aleatorio = (int) (Math.random() * campos.size());
			campos.get(aleatorio).minar();
			minasArmadas = campos.stream().filter(minado).count();
		} ;
	}

	public boolean objetivoAlcancado() {
		return campos.stream().allMatch(c -> c.objetivoAlcancado());
	}

	public void reiniciar() {
		campos.stream().forEach(c -> c.reiniciar());
		sortearMinas();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		int i = 0;
		
		for (int c = 0; c < colunas; c++) {
			sb.append(c);
			sb.append(" ");
		}
		
		sb.append("\n");
		
		for (int l = 0; l < linhas; l++) {
			for (int c = 0; c < colunas; c++) {
				sb.append(campos.get(i));
				sb.append(" ");
				i++;
			}
			sb.append(l);
			sb.append("\n");
		}
		return sb.toString();
	}
}

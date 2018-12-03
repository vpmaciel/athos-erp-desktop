package arquitetura.util;

import java.util.LinkedList;
import java.util.List;

public class TabelaModelo {

	private List<TabelaMatriz> matrizList = new LinkedList<>();

	public TabelaModelo() {

	}

	public void adicionar(String nomeColuna, int numeroColuna, int larguraColuna) {
		matrizList.add(new TabelaMatriz(nomeColuna, numeroColuna, larguraColuna));
	}

	public int getLargura(String nomeColuna) {
		for (TabelaMatriz tabelaMatriz : matrizList) {
			if (tabelaMatriz.nomeColuna.equals(nomeColuna)) {
				return tabelaMatriz.larguraColuna;
			}
		}
		return -1;
	}
	
	public int getLargura(int numeroColuna) {
		for (TabelaMatriz tabelaMatriz : matrizList) {
			if (tabelaMatriz.numeroColuna == numeroColuna) {
				return tabelaMatriz.larguraColuna;
			}
		}
		return 0;
	}
	
	public String getNome(int numeroColuna) {
		for (TabelaMatriz tabelaMatriz : matrizList) {
			if (tabelaMatriz.numeroColuna == numeroColuna) {
				return tabelaMatriz.nomeColuna;
			}
		}
		return null;
	}

	public int getTotalColunas() {
		return matrizList.size();
	}
}
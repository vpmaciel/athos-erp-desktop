package erp.curriculo.idioma;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import arquitetura.util.TabelaModelo;
import erp.funcionario.Funcionario;

@SuppressWarnings("serial")
public class IdiomaTm extends AbstractTableModel {

	public static final int ID = 0;
	public static int[] largura;
	private static boolean[] podeEditar;
	private static TabelaModelo tabelaModelo = new TabelaModelo();
	static {
		tabelaModelo.adicionar("ID", 0, 100);
		tabelaModelo.adicionar("FUNCIONÁRIO", 1, 500);
		tabelaModelo.adicionar("CONHECIMENTO", 2, 500);
		tabelaModelo.adicionar("NÍVEL DE CONHECIMENTO", 3, 500);

		largura = new int[tabelaModelo.getTotalColunas()];
		podeEditar = new boolean[tabelaModelo.getTotalColunas()];
		for (int i = 0; i < tabelaModelo.getTotalColunas(); i++) {
			largura[i] = tabelaModelo.getLargura(i);
			podeEditar[i] = false;
		}
	}
	private Idioma idioma;

	private List<Idioma> IdiomaList = new LinkedList<>();

	public IdiomaTm() {

	}

	public IdiomaTm(List<Idioma> lista) {
		IdiomaList.addAll(lista);
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {

		if (tabelaModelo.getNome(columnIndex).equals("ID")) {
			return Long.class;
		}
		if (tabelaModelo.getNome(columnIndex).equals("FUNCIONÁRIO")) {
			return Funcionario.class;
		}
		return String.class;
	}

	@Override
	public int getColumnCount() {
		return largura.length;
	}

	@Override
	public String getColumnName(int column) {
		return tabelaModelo.getNome(column);
	}

	public Idioma getIdioma(int linha) {
		if (IdiomaList.size() > 0) {
			return IdiomaList.get(linha);
		}
		return null;
	}

	public List<Idioma> getIdiomaList() {
		return IdiomaList;
	}

	@Override
	public int getRowCount() {
		return IdiomaList.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Idioma Idioma = IdiomaList.get(rowIndex);

		if (tabelaModelo.getNome(columnIndex).equals("ID")) {
			return Idioma.getId();
		}
		if (tabelaModelo.getNome(columnIndex).equals("FUNCIONÁRIO")) {
			return Idioma.getFuncionario();
		}
		if (tabelaModelo.getNome(columnIndex).equals("CONHECIMENTO")) {
			return Idioma.getConhecimento();
		}
		if (tabelaModelo.getNome(columnIndex).equals("NÍVEL DE CONHECIMENTO")) {
			return Idioma.getNivelConhecimento();
		}
		return Idioma;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return podeEditar[columnIndex];
	}

	public void setIdiomaList(List<Idioma> Idioma) {
		IdiomaList = Idioma;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		idioma = IdiomaList.get(rowIndex);

		if (tabelaModelo.getNome(columnIndex).equals("ID")) {
			idioma.setId(Long.parseLong(aValue.toString()));
		}
		if (tabelaModelo.getNome(columnIndex).equals("FUNCINÁRIO")) {
			idioma.setFuncionario((Funcionario) aValue);
		}
		if (tabelaModelo.getNome(columnIndex).equals("CONHECIMENTO")) {
			idioma.setConhecimento(aValue.toString());
		}
		if (tabelaModelo.getNome(columnIndex).equals("NÍVEL DE CONHECIMENTO")) {
			idioma.setNivelConhecimento(aValue.toString());
		}

		fireTableDataChanged();
	}
}
package erp.curriculo.testepersonalidade.c;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import arquitetura.util.TabelaModelo;
import erp.funcionario.Funcionario;

@SuppressWarnings("serial")
public class TesteCTm extends AbstractTableModel {

	public static final int ID = 0;
	public static int[] largura;
	private static boolean[] podeEditar;
	private static TabelaModelo tabelaModelo = new TabelaModelo();
	static {
		tabelaModelo.adicionar("ID", 0, 100);
		tabelaModelo.adicionar("FUNCIONÁRIO", 1, 400);

		largura = new int[tabelaModelo.getTotalColunas()];
		podeEditar = new boolean[tabelaModelo.getTotalColunas()];
		for (int i = 0; i < tabelaModelo.getTotalColunas(); i++) {
			largura[i] = tabelaModelo.getLargura(i);
			podeEditar[i] = false;
		}
	}
	private TesteC testeC;

	private List<TesteC> testeCList = new LinkedList<>();

	public TesteCTm() {

	}

	public TesteCTm(List<TesteC> lista) {
		testeCList.addAll(lista);
	}

	public TesteC getTesteC(int linha) {
		if (testeCList.size() > 0) {
			return testeCList.get(linha);
		}
		return null;
	}

	public List<TesteC> gettesteCList() {
		return testeCList;
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

	@Override
	public int getRowCount() {
		return testeCList.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		TesteC testeC = testeCList.get(rowIndex);

		if (tabelaModelo.getNome(columnIndex).equals("ID")) {
			return testeC.getId();
		}
		if (tabelaModelo.getNome(columnIndex).equals("FUNCIONÁRIO")) {
			return testeC.getFuncionario();
		}
		return testeC;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return podeEditar[columnIndex];
	}

	public void settesteCList(List<TesteC> testeC) {
		testeCList = testeC;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		testeC = testeCList.get(rowIndex);

		if (tabelaModelo.getNome(columnIndex).equals("ID")) {
			testeC.setId(Long.parseLong(aValue.toString()));
		}

		if (tabelaModelo.getNome(columnIndex).equals("FUNCINÁRIO")) {
			testeC.setFuncionario((Funcionario) aValue);
		}

		fireTableDataChanged();
	}
}
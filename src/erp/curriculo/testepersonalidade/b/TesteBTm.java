package erp.curriculo.testepersonalidade.b;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import arquitetura.util.TabelaModelo;
import erp.funcionario.Funcionario;

@SuppressWarnings("serial")
public class TesteBTm extends AbstractTableModel {

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
	private TesteB testeB;

	private List<TesteB> testeBList = new LinkedList<>();

	public TesteBTm() {

	}

	public TesteBTm(List<TesteB> lista) {
		testeBList.addAll(lista);
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
		return testeBList.size();
	}

	public TesteB getTesteB(int linha) {
		if (testeBList.size() > 0) {
			return testeBList.get(linha);
		}
		return null;
	}

	public List<TesteB> gettesteBList() {
		return testeBList;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		TesteB testeB = testeBList.get(rowIndex);

		if (tabelaModelo.getNome(columnIndex).equals("ID")) {
			return testeB.getId();
		}
		if (tabelaModelo.getNome(columnIndex).equals("FUNCIONÁRIO")) {
			return testeB.getFuncionario();
		}
		return testeB;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return podeEditar[columnIndex];
	}

	public void settesteBList(List<TesteB> testeB) {
		testeBList = testeB;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		testeB = testeBList.get(rowIndex);

		if (tabelaModelo.getNome(columnIndex).equals("ID")) {
			testeB.setId(Long.parseLong(aValue.toString()));
		}

		if (tabelaModelo.getNome(columnIndex).equals("FUNCINÁRIO")) {
			testeB.setFuncionario((Funcionario) aValue);
		}

		fireTableDataChanged();
	}
}
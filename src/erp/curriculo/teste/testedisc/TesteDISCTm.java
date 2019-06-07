package erp.curriculo.teste.testedisc;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import arquitetura.util.TabelaModelo;
import erp.funcionario.Funcionario;

@SuppressWarnings("serial")
public class TesteDISCTm extends AbstractTableModel {

	public static final int ID = 0;
	public static int[] largura;
	private static boolean[] podeEditar;
	private static TabelaModelo tabelaModelo = new TabelaModelo();
	static {
		tabelaModelo.adicionar("ID", 0, 100);
		tabelaModelo.adicionar("FUNCIONÁRIO", 1, 500);

		largura = new int[tabelaModelo.getTotalColunas()];
		podeEditar = new boolean[tabelaModelo.getTotalColunas()];
		for (int i = 0; i < tabelaModelo.getTotalColunas(); i++) {
			largura[i] = tabelaModelo.getLargura(i);
			podeEditar[i] = false;
		}
	}
	private TesteDISC testeDISC;

	private List<TesteDISC> testeDISCList = new LinkedList<>();

	public TesteDISCTm() {

	}

	public TesteDISCTm(List<TesteDISC> lista) {
		testeDISCList.addAll(lista);
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
		return testeDISCList.size();
	}

	public TesteDISC getTesteDISC(int linha) {
		if (testeDISCList.size() > 0) {
			return testeDISCList.get(linha);
		}
		return null;
	}

	public List<TesteDISC> gettesteDISCList() {
		return testeDISCList;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		TesteDISC testeDISC = testeDISCList.get(rowIndex);

		if (tabelaModelo.getNome(columnIndex).equals("ID")) {
			return testeDISC.getId();
		}
		if (tabelaModelo.getNome(columnIndex).equals("FUNCIONÁRIO")) {
			return testeDISC.getFuncionario();
		}
		return testeDISC;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return podeEditar[columnIndex];
	}

	public void settesteDISCList(List<TesteDISC> testeDISC) {
		testeDISCList = testeDISC;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		testeDISC = testeDISCList.get(rowIndex);

		if (tabelaModelo.getNome(columnIndex).equals("ID")) {
			testeDISC.setId(Long.parseLong(aValue.toString()));
		}

		if (tabelaModelo.getNome(columnIndex).equals("FUNCINÁRIO")) {
			testeDISC.setFuncionario((Funcionario) aValue);
		}

		fireTableDataChanged();
	}
}
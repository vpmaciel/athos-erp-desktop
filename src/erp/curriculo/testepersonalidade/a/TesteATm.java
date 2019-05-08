package erp.curriculo.testepersonalidade.a;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import arquitetura.util.TabelaModelo;
import erp.funcionario.Funcionario;

@SuppressWarnings("serial")
public class TesteATm extends AbstractTableModel {

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
	private TesteA testeA;

	private List<TesteA> testeAList = new LinkedList<>();

	public TesteATm() {

	}

	public TesteATm(List<TesteA> lista) {
		testeAList.addAll(lista);
	}

	public TesteA getTesteA(int linha) {
		if (testeAList.size() > 0) {
			return testeAList.get(linha);
		}
		return null;
	}

	public List<TesteA> gettesteAList() {
		return testeAList;
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
		return testeAList.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		TesteA testeA = testeAList.get(rowIndex);

		if (tabelaModelo.getNome(columnIndex).equals("ID")) {
			return testeA.getId();
		}
		if (tabelaModelo.getNome(columnIndex).equals("FUNCIONÁRIO")) {
			return testeA.getFuncionario();
		}
		return testeA;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return podeEditar[columnIndex];
	}

	public void settesteAList(List<TesteA> testeA) {
		testeAList = testeA;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		testeA = testeAList.get(rowIndex);

		if (tabelaModelo.getNome(columnIndex).equals("ID")) {
			testeA.setId(Long.parseLong(aValue.toString()));
		}

		if (tabelaModelo.getNome(columnIndex).equals("FUNCINÁRIO")) {
			testeA.setFuncionario((Funcionario) aValue);
		}

		fireTableDataChanged();
	}
}
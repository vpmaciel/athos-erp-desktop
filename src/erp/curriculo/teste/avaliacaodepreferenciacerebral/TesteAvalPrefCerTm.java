package erp.curriculo.teste.avaliacaodepreferenciacerebral;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import arquitetura.util.TabelaModelo;
import erp.funcionario.Funcionario;

@SuppressWarnings("serial")
public class TesteAvalPrefCerTm extends AbstractTableModel {

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
	private TesteAvalPrefCer testeAvalPrefCer;

	private List<TesteAvalPrefCer> testeAvalPrefCerList = new LinkedList<>();

	public TesteAvalPrefCerTm() {

	}

	public TesteAvalPrefCerTm(List<TesteAvalPrefCer> lista) {
		testeAvalPrefCerList.addAll(lista);
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
		return testeAvalPrefCerList.size();
	}

	public TesteAvalPrefCer getTesteAvalPrefCer(int linha) {
		if (testeAvalPrefCerList.size() > 0) {
			return testeAvalPrefCerList.get(linha);
		}
		return null;
	}

	public List<TesteAvalPrefCer> gettesteAvalPrefCerList() {
		return testeAvalPrefCerList;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		TesteAvalPrefCer testeAvalPrefCer = testeAvalPrefCerList.get(rowIndex);

		if (tabelaModelo.getNome(columnIndex).equals("ID")) {
			return testeAvalPrefCer.getId();
		}
		if (tabelaModelo.getNome(columnIndex).equals("FUNCIONÁRIO")) {
			return testeAvalPrefCer.getFuncionario();
		}
		return testeAvalPrefCer;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return podeEditar[columnIndex];
	}

	public void settesteAvalPrefCerList(List<TesteAvalPrefCer> testeAvalPrefCer) {
		testeAvalPrefCerList = testeAvalPrefCer;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		testeAvalPrefCer = testeAvalPrefCerList.get(rowIndex);

		if (tabelaModelo.getNome(columnIndex).equals("ID")) {
			testeAvalPrefCer.setId(Long.parseLong(aValue.toString()));
		}

		if (tabelaModelo.getNome(columnIndex).equals("FUNCINÁRIO")) {
			testeAvalPrefCer.setFuncionario((Funcionario) aValue);
		}

		fireTableDataChanged();
	}
}
package erp.centrocusto;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import arquitetura.util.TabelaModelo;

@SuppressWarnings("serial")
public class CentroCustoTm extends AbstractTableModel {

	public static final int ID = 0;
	public static int[] largura;
	private static boolean[] podeEditar;
	private List<CentroCusto> centroCustoList = new LinkedList<>();
	private CentroCusto centroCusto;
	private static TabelaModelo tabelaModelo = new TabelaModelo();

	public CentroCustoTm() {

	}

	static {
		tabelaModelo.adicionar("ID", 0, 100);
		tabelaModelo.adicionar("NOME", 1, 500);
		
		largura = new int[tabelaModelo.getTotalColunas()];
		podeEditar = new boolean[tabelaModelo.getTotalColunas()];
		for (int i = 0; i < tabelaModelo.getTotalColunas(); i++) {
			largura[i] = tabelaModelo.getLargura(i);
			podeEditar[i] = false;
		}
	}

	public CentroCustoTm(List<CentroCusto> lista) {
		centroCustoList.addAll(lista);
	}

	public CentroCusto getCentroCusto(int linha) {
		if (centroCustoList.size() > 0) {
			return centroCustoList.get(linha);
		}
		return null;
	}

	public List<CentroCusto> getCentroCustoList() {
		return centroCustoList;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {

		if (tabelaModelo.getNome(columnIndex).equals("ID")) {
			return Long.class;
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
		return centroCustoList.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		CentroCusto centroCusto = centroCustoList.get(rowIndex);

		if (tabelaModelo.getNome(columnIndex).equals("ID")) {
			return centroCusto.getId();
		}
		if (tabelaModelo.getNome(columnIndex).equals("NOME")) {
			return centroCusto.getNome();
		}
		return centroCusto;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return podeEditar[columnIndex];
	}

	public void setCentroCustoList(List<CentroCusto> centroCusto) {
		centroCustoList = centroCusto;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		centroCusto = centroCustoList.get(rowIndex);

		if (tabelaModelo.getNome(columnIndex).equals("ID")) {
			centroCusto.setId(Long.parseLong(aValue.toString()));
		}
		if (tabelaModelo.getNome(columnIndex).equals("NOME")) {
			centroCusto.setNome(aValue.toString());
		}

		fireTableDataChanged();
	}
}
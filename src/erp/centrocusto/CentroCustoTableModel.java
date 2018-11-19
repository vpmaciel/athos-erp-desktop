package erp.centrocusto;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class CentroCustoTableModel extends AbstractTableModel {

	public static final int ID = 0;
	public static final int NOME = 1;
	public static final int[] WIDTH = new int[] { 100, 400 };
	private final boolean[] podeEditar = new boolean[] { false, false };
	private List<CentroCusto> centroCustoList = new LinkedList<>();
	private CentroCusto centroCusto;

	public CentroCustoTableModel() {

	}

	public CentroCustoTableModel(List<CentroCusto> lista) {
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
		if (columnIndex == ID) {
			return Long.class;
		}
		if (columnIndex == NOME) {
			return String.class;
		}
		return null;
	}

	@Override
	public int getColumnCount() {
		return WIDTH.length;
	}

	@Override
	public String getColumnName(int columnIndex) {
		if (columnIndex == ID) {
			return "REGISTRO";
		}
		if (columnIndex == NOME) {
			return "NOME";
		}
		return null;
	}

	@Override
	public int getRowCount() {
		return centroCustoList.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		CentroCusto centroCusto = centroCustoList.get(rowIndex);
		if (columnIndex == ID) {
			return centroCusto.getId();
		}
		if (columnIndex == NOME) {
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
		if (columnIndex == ID) {
			centroCusto.setId(Long.parseLong(aValue.toString()));
		}
		if (columnIndex == NOME) {
			centroCusto.setNome(aValue.toString());
		}
		fireTableDataChanged();
	}
}

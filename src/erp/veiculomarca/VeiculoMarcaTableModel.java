package erp.veiculomarca;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class VeiculoMarcaTableModel extends AbstractTableModel {

	public static final int ID = 0;
	public static final int COL_MARCA = 1;
	public static final int[] WIDTH = new int[] { 100, 300 };
	private final boolean[] podeEditar = new boolean[] { false, false, false };
	private List<VeiculoMarca> veiculoMarcaList = new LinkedList<>();
	private VeiculoMarca veiculoMarca;

	public VeiculoMarcaTableModel() {

	}

	public VeiculoMarcaTableModel(List<VeiculoMarca> lista) {
		veiculoMarcaList.addAll(lista);
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case ID:
			return Long.class;
		case COL_MARCA:
			return String.class;
		default:
			return String.class;
		}
	}

	@Override
	public int getColumnCount() {
		return WIDTH.length;
	}

	@Override
	public String getColumnName(int column) {
		switch (column) {
		case ID:
			return "REGISTRO";
		case COL_MARCA:
			return "MARCA";
		default:
			return "";
		}
	}

	@Override
	public int getRowCount() {
		return veiculoMarcaList.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		VeiculoMarca veiculoMarca = veiculoMarcaList.get(rowIndex);
		switch (columnIndex) {
		case ID:
			return veiculoMarca.getId();
		case COL_MARCA:
			return veiculoMarca.getMarca();
		default:
			return veiculoMarca;
		}
	}

	public VeiculoMarca getVeiculoMarca(int linha) {
		if (veiculoMarcaList.size() > 0) {
			return veiculoMarcaList.get(linha);
		}
		return null;
	}

	public List<VeiculoMarca> getVeiculoMarcaList() {
		return veiculoMarcaList;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return podeEditar[columnIndex];
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		veiculoMarca = veiculoMarcaList.get(rowIndex);
		switch (columnIndex) {
		case ID:
			veiculoMarca.setId(Long.parseLong(aValue.toString()));
			break;
		case COL_MARCA:
			veiculoMarca.setMarca(aValue.toString());
			break;
		}
		fireTableDataChanged();
	}

	public void setVeiculoMarcaList(List<VeiculoMarca> veiculoMarca) {
		veiculoMarcaList = veiculoMarca;
	}
}

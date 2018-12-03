package erp.veiculomodelo;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class VeiculoModeloTableModel extends AbstractTableModel {

	public static final int ID = 0;
	public final int COL_MARCA = 1;
	public static final int[] WIDTH = new int[] { 100, 300 };
	private final boolean[] podeEditar = new boolean[] { false, false, false };
	private List<VeiculoModelo> veiculoModeloList = new LinkedList<>();
	private VeiculoModelo veiculoModelo;

	public VeiculoModeloTableModel() {

	}

	public VeiculoModeloTableModel(List<VeiculoModelo> lista) {
		veiculoModeloList.addAll(lista);
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
		return veiculoModeloList.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		VeiculoModelo veiculoModelo = veiculoModeloList.get(rowIndex);
		switch (columnIndex) {
		case ID:
			return veiculoModelo.getId();
		case COL_MARCA:
			return veiculoModelo.getModelo();
		default:
			return veiculoModelo;
		}
	}

	public VeiculoModelo getVeiculoModelo(int linha) {
		if (veiculoModeloList.size() > 0) {
			return veiculoModeloList.get(linha);
		}
		return null;
	}

	public List<VeiculoModelo> getVeiculoModeloList() {
		return veiculoModeloList;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return podeEditar[columnIndex];
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		veiculoModelo = veiculoModeloList.get(rowIndex);
		switch (columnIndex) {
		case ID:
			veiculoModelo.setId(Long.parseLong(aValue.toString()));
			break;
		case COL_MARCA:
			veiculoModelo.setModelo(aValue.toString());
			break;
		}
		fireTableDataChanged();
	}

	public void setVeiculoModeloList(List<VeiculoModelo> veiculoModelo) {
		veiculoModeloList = veiculoModelo;
	}
}

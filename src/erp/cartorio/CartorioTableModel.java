package erp.cartorio;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class CartorioTableModel extends AbstractTableModel {

	public static final int ID = 0;
	public static final int NOME_FANTASIA = 1;
	public static final int RAZAO_SOCIAL = 2;
	public static final int COMARCA = 3;

	public static final int[] WIDTH = new int[] { 100, 400, 400, 400 };
	private final boolean[] podeEditar = new boolean[] { false, false, false, false };
	private List<Cartorio> cartoriosList = new LinkedList<>();
	private Cartorio cartorio;

	public CartorioTableModel() {
	}

	public CartorioTableModel(List<Cartorio> lista) {
		cartoriosList.addAll(lista);
	}

	public Cartorio getCartorio(int linha) {
		if (cartoriosList.size() > 0) {
			return cartoriosList.get(linha);
		}
		return new Cartorio();
	}

	public List<Cartorio> getCartorioList() {
		return cartoriosList;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		if (columnIndex == ID) {
			return Long.class;
		}
		if (columnIndex == NOME_FANTASIA) {
			return String.class;
		}
		if (columnIndex == RAZAO_SOCIAL) {
			return String.class;
		}
		if (columnIndex == COMARCA) {
			return String.class;
		}
		return String.class;
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
		if (columnIndex == NOME_FANTASIA) {
			return "NOME FANTASIA";
		}
		if (columnIndex == RAZAO_SOCIAL) {
			return "RAZÃO SOCIAL";
		}
		if (columnIndex == COMARCA) {
			return "COMARCA";
		}
		return "";
	}

	@Override
	public int getRowCount() {
		return cartoriosList.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Cartorio cartorio = cartoriosList.get(rowIndex);
		if (columnIndex == ID) {
			return cartorio.getId();
		}
		if (columnIndex == NOME_FANTASIA) {
			return cartorio.getNomeFantasia();
		}
		if (columnIndex == RAZAO_SOCIAL) {
			return cartorio.getRazaoSocial();
		}
		if (columnIndex == COMARCA) {
			return cartorio.getComarca();
		}
		return cartorio;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return podeEditar[columnIndex];
	}

	public void setCartorioList(List<Cartorio> banco) {
		cartoriosList = banco;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		cartorio = cartoriosList.get(rowIndex);
		if (columnIndex == ID) {
			cartorio.setId(Long.parseLong(aValue.toString()));
		}
		if (columnIndex == NOME_FANTASIA) {
			cartorio.setNomeFantasia(aValue.toString());
		}
		if (columnIndex == RAZAO_SOCIAL) {
			cartorio.setRazaoSocial(aValue.toString());
		}
		if (columnIndex == COMARCA) {
			cartorio.setComarca(aValue.toString());
		}
		fireTableDataChanged();
	}
}

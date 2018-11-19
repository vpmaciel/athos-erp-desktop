package erp.banco;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
final class BancoTableModel extends AbstractTableModel {

	public static final int ID = 0;
	public static final int NOME = 1;
	public static final int CODIGO = 2;
	public static final int[] WIDTH = new int[] { 100, 400, 200 };
	private final boolean[] podeEditar = new boolean[] { false, false, false };
	private List<Banco> bancoList = new LinkedList<>();
	private Banco banco;

	public BancoTableModel() {

	}

	public BancoTableModel(List<Banco> lista) {
		bancoList.addAll(lista);
	}

	public Banco getBanco(int linha) {
		if (bancoList.size() > 0) {
			return bancoList.get(linha);
		}
		return null;
	}

	public List<Banco> getBancoList() {
		return bancoList;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		if (columnIndex == ID) {
			return Long.class;
		}
		if (columnIndex == NOME) {
			return String.class;
		}
		if (columnIndex == CODIGO) {
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
		if (columnIndex == CODIGO) {
			return "CÓDIGO DO BANCO";
		}
		return null;
	}

	@Override
	public int getRowCount() {
		return bancoList.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Banco banco = bancoList.get(rowIndex);
		if (columnIndex == ID) {
			return banco.getId();
		}
		if (columnIndex == NOME) {
			return banco.getNome();
		}
		if (columnIndex == CODIGO) {
			return banco.getCodigo();
		}
		return banco;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return podeEditar[columnIndex];
	}

	public void setBancoList(List<Banco> banco) {
		bancoList = banco;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		banco = bancoList.get(rowIndex);
		if (columnIndex == ID) {
			banco.setId(Long.parseLong(aValue.toString()));
		}
		if (columnIndex == NOME) {
			banco.setNome(aValue.toString());
		}
		if (columnIndex == CODIGO) {
			banco.setCodigo(aValue.toString());
		}
		fireTableDataChanged();
	}
}

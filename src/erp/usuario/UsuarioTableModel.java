package erp.usuario;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class UsuarioTableModel extends AbstractTableModel {

	public static final int COL_ID = 0;
	public static final int COL_NOME = 1;

	public static final int[] WIDTH = new int[] { 100, 500 };
	private final boolean[] podeEditar = new boolean[] { false, false };
	private List<Usuario> usuarioList = new LinkedList<>();
	private Usuario usuario;

	public UsuarioTableModel() {
	}

	public UsuarioTableModel(List<Usuario> lista) {
		usuarioList.addAll(lista);
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case COL_ID:
			return Long.class;
		case COL_NOME:
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
		case COL_ID:
			return "REGISTRO";
		case COL_NOME:
			return "NOME";
		default:
			return "";
		}
	}

	@Override
	public int getRowCount() {
		return usuarioList.size();
	}

	public Usuario getUsuario(int linha) {
		if (usuarioList.size() > 0) {
			return usuarioList.get(linha);
		}
		return null;
	}

	public List<Usuario> getUsuarioList() {
		return usuarioList;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Usuario usuario = usuarioList.get(rowIndex);
		switch (columnIndex) {
		case COL_ID:
			return usuario.getId();
		case COL_NOME:
			return usuario.getNome();
		default:
			return usuario;
		}
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return podeEditar[columnIndex];
	}

	public void setUsuarioList(List<Usuario> usuario) {
		usuarioList = usuario;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		usuario = usuarioList.get(rowIndex);
		switch (columnIndex) {
		case COL_ID:
			usuario.setId(Long.parseLong(aValue.toString()));
			break;
		case COL_NOME:
			usuario.setNome(aValue.toString());
			break;
		}
		fireTableDataChanged();
	}
}

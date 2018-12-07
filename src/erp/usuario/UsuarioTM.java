package erp.usuario;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import arquitetura.util.TabelaModelo;

@SuppressWarnings("serial")
public class UsuarioTM extends AbstractTableModel {

	public static final int ID = 0;
	public static int[] largura;
	private static boolean[] podeEditar;
	private List<Usuario> usuarioList = new LinkedList<>();
	private Usuario usuario;
	private static TabelaModelo tabelaModelo = new TabelaModelo();

	public UsuarioTM() {

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

	public UsuarioTM(List<Usuario> lista) {
		usuarioList.addAll(lista);
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
		return usuarioList.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Usuario usuario = usuarioList.get(rowIndex);

		if (tabelaModelo.getNome(columnIndex).equals("ID")) {
			return usuario.getId();
		}
		if (tabelaModelo.getNome(columnIndex).equals("NOME")) {
			return usuario.getNome();
		}
		return usuario;
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

		if (tabelaModelo.getNome(columnIndex).equals("ID")) {
			usuario.setId(Long.parseLong(aValue.toString()));
		}
		if (tabelaModelo.getNome(columnIndex).equals("NOME")) {
			usuario.setNome(aValue.toString());
		}


		fireTableDataChanged();
	}
}
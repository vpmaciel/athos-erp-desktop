package erp.agenda.evento.tipoevento;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import arquitetura.util.TabelaModelo;

@SuppressWarnings("serial")
public class TipoEventoTm extends AbstractTableModel {

	public static final int ID = 0;
	public static int[] largura;
	private static boolean[] podeEditar;
	private static TabelaModelo tabelaModelo = new TabelaModelo();
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
	private TipoEvento tipoEvento;

	private List<TipoEvento> tipoEventoList = new LinkedList<>();

	public TipoEventoTm() {

	}

	public TipoEventoTm(List<TipoEvento> lista) {
		tipoEventoList.addAll(lista);
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
		return tipoEventoList.size();
	}

	public TipoEvento getTipoEvento(int linha) {
		if (tipoEventoList.size() > 0) {
			return tipoEventoList.get(linha);
		}
		return null;
	}

	public List<TipoEvento> getTipoEventoList() {
		return tipoEventoList;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		TipoEvento tipoEvento = tipoEventoList.get(rowIndex);

		if (tabelaModelo.getNome(columnIndex).equals("ID")) {
			return tipoEvento.getId();
		}
		if (tabelaModelo.getNome(columnIndex).equals("NOME")) {
			return tipoEvento.getNome();
		}
		return tipoEvento;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return podeEditar[columnIndex];
	}

	public void setTipoEventoList(List<TipoEvento> tipoEvento) {
		tipoEventoList = tipoEvento;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		tipoEvento = tipoEventoList.get(rowIndex);

		if (tabelaModelo.getNome(columnIndex).equals("ID")) {
			tipoEvento.setId(Long.parseLong(aValue.toString()));
		}

		fireTableDataChanged();
	}
}
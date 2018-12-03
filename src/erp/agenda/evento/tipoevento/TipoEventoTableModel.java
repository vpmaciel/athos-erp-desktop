package erp.agenda.evento.tipoevento;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import arquitetura.util.TabelaModelo;

@SuppressWarnings("serial")
public class TipoEventoTableModel extends AbstractTableModel {

	public static final int ID = 0;
	public static int[] largura;
	private static boolean[] podeEditar;
	private List<TipoEvento> agendaList = new LinkedList<>();
	private TipoEvento tipoEvento;
	private static TabelaModelo tabelaModelo = new TabelaModelo();

	public TipoEventoTableModel() {

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

	public TipoEventoTableModel(List<TipoEvento> lista) {
		agendaList.addAll(lista);
	}

	public TipoEvento getAgenda(int linha) {
		if (agendaList.size() > 0) {
			return agendaList.get(linha);
		}
		return null;
	}

	public List<TipoEvento> getAgendaList() {
		return agendaList;
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
		return agendaList.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		TipoEvento tipoEvento = agendaList.get(rowIndex);

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

	public void setAgendaList(List<TipoEvento> banco) {
		agendaList = banco;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		tipoEvento = agendaList.get(rowIndex);

		if (tabelaModelo.getNome(columnIndex).equals("ID")) {
			tipoEvento.setId(Long.parseLong(aValue.toString()));
		}

		fireTableDataChanged();
	}
}
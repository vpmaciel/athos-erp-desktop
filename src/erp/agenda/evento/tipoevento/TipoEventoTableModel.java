package erp.agenda.evento.tipoevento;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class TipoEventoTableModel extends AbstractTableModel {

	public static final int ID = 0;
	public static final int COL_NOME = 1;
	public static final int[] WIDTH = new int[] { 100, 500 };
	private final boolean[] podeEditar = new boolean[] { false, false };
	private List<TipoEvento> agendaList = new LinkedList<>();
	private TipoEvento tipoEvento;

	public TipoEventoTableModel() {

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
		switch (columnIndex) {
		case ID:
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
		case ID:
			return "REGISTRO";
		case COL_NOME:
			return "NOME";
		default:
			return "";
		}
	}

	@Override
	public int getRowCount() {
		return agendaList.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		TipoEvento tipoEvento = agendaList.get(rowIndex);
		switch (columnIndex) {
		case ID:
			return tipoEvento.getId();
		case COL_NOME:
			return tipoEvento.getNome();
		default:
			return tipoEvento;
		}
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
		switch (columnIndex) {
		case ID:
			tipoEvento.setId(Long.parseLong(aValue.toString()));
			break;
		case COL_NOME:
			tipoEvento.setNome(aValue.toString());
			break;
		}

		fireTableDataChanged();
	}
}

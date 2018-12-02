package erp.agenda.evento;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import erp.agenda.evento.tipoevento.TipoEvento;

@SuppressWarnings("serial")
public class EventoTableModel extends AbstractTableModel {

	public static final int ID = 0;
	public final int COL_DATA = 1;
	public final int COL_HORA_INICIO = 2;
	public final int COL_HORA_TERMINO = 3;
	public final int COL_TIPO_EVENTO = 4;
	public final int COL_DESCRICAO = 5;
	public static final int[] WIDTH = new int[] { 100, 500, 500, 500, 500, 500 };
	public final boolean[] podeEditar = new boolean[] { false, false, false, false, false, false };
	private List<Evento> eventoList = new LinkedList<>();
	private Evento evento;

	public EventoTableModel() {

	}

	public EventoTableModel(List<Evento> lista) {
		eventoList.addAll(lista);
	}

	public Evento getAgenda(int linha) {
		if (eventoList.size() > 0) {
			return eventoList.get(linha);
		}
		return null;
	}

	public List<Evento> getAgendaList() {
		return eventoList;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case ID:
			return Long.class;
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
		case COL_DATA:
			return "DATA";
		case COL_HORA_INICIO:
			return "CPF";
		case COL_HORA_TERMINO:
			return "HORA_TERMINO";
		case COL_TIPO_EVENTO:
			return "TIPO_EVENTO";
		case COL_DESCRICAO:
			return "DESCRICAO";
		default:
			return "";
		}
	}

	@Override
	public int getRowCount() {
		return eventoList.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Evento evento = eventoList.get(rowIndex);
		switch (columnIndex) {
		case COL_DATA:
			return evento.getData();
		case COL_HORA_INICIO:
			return evento.getHoraInicio();
		case COL_HORA_TERMINO:
			return evento.getHoraTermino();
		case COL_TIPO_EVENTO:
			return evento.getTipoEvento();
		case COL_DESCRICAO:
			return evento.getDescricao();
		case ID:
			return evento.getId();
		default:
			return evento;
		}
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return podeEditar[columnIndex];
	}

	public void setAgendaList(List<Evento> banco) {
		eventoList = banco;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		evento = eventoList.get(rowIndex);
		switch (columnIndex) {
		case COL_DATA:
			evento.setData(aValue.toString());
			break;
		case COL_HORA_INICIO:
			evento.setHoraInicio(aValue.toString());
			break;
		case COL_HORA_TERMINO:
			evento.setHoraTermino(aValue.toString());
			break;
		case COL_TIPO_EVENTO:
			evento.setTipoEvento((TipoEvento) aValue);
			break;
		case COL_DESCRICAO:
			evento.setDescricao(aValue.toString());
			break;
		case ID:
			evento.setId(Long.parseLong(aValue.toString()));
			break;
		}

		fireTableDataChanged();
	}
}

package erp.agenda.evento;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import arquitetura.util.TabelaModelo;
import erp.agenda.evento.tipoevento.TipoEvento;

@SuppressWarnings("serial")
public class EventoTm extends AbstractTableModel {

	public static final int ID = 0;
	public static int[] largura;
	private static boolean[] podeEditar;
	private static TabelaModelo tabelaModelo = new TabelaModelo();
	static {
		tabelaModelo.adicionarColuna("ID", 0, 100);
		tabelaModelo.adicionarColuna("DESCRIÇÃO", 1, 500);
		tabelaModelo.adicionarColuna("TIPO DE EVENTO", 2, 500);
		tabelaModelo.adicionarColuna("DATA", 3, 100);
		tabelaModelo.adicionarColuna("HORA INÍCIO", 4, 100);
		tabelaModelo.adicionarColuna("HORA TÉRMINO", 5, 100);

		largura = new int[tabelaModelo.getTotalColunas()];
		podeEditar = new boolean[tabelaModelo.getTotalColunas()];
		for (int i = 0; i < tabelaModelo.getTotalColunas(); i++) {
			largura[i] = tabelaModelo.getLargura(i);
			podeEditar[i] = false;
		}
	}
	private Evento evento;

	private List<Evento> EventoList = new LinkedList<>();

	public EventoTm() {

	}

	public EventoTm(List<Evento> lista) {
		EventoList.addAll(lista);
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {

		if (tabelaModelo.getNome(columnIndex).equals("ID")) {
			return Long.class;
		}
		if (tabelaModelo.getNome(columnIndex).equals("TIPO DE EVENTO")) {
			return TipoEvento.class;
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

	public Evento getEvento(int linha) {
		if (EventoList.size() > 0) {
			return EventoList.get(linha);
		}
		return null;
	}

	public List<Evento> getEventoList() {
		return EventoList;
	}

	@Override
	public int getRowCount() {
		return EventoList.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Evento evento = EventoList.get(rowIndex);

		if (tabelaModelo.getNome(columnIndex).equals("ID")) {
			return evento.getId();
		}
		if (tabelaModelo.getNome(columnIndex).equals("DESCRIÇÃO")) {
			return evento.getDescricao();
		}
		if (tabelaModelo.getNome(columnIndex).equals("TIPO DE EVENTO")) {
			return evento.getTipoEvento();
		}
		if (tabelaModelo.getNome(columnIndex).equals("DATA")) {
			return evento.getData();
		}
		if (tabelaModelo.getNome(columnIndex).equals("HORA INÍCIO")) {
			return evento.getHoraInicio();
		}
		if (tabelaModelo.getNome(columnIndex).equals("HORA TÉRMINO")) {
			return evento.getHoraTermino();
		}
		return evento;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return podeEditar[columnIndex];
	}

	public void setEventoList(List<Evento> Evento) {
		EventoList = Evento;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		evento = EventoList.get(rowIndex);

		if (tabelaModelo.getNome(columnIndex).equals("ID")) {
			evento.setId(Long.parseLong(aValue.toString()));
		}
		if (tabelaModelo.getNome(columnIndex).equals("DESCRIÇÃO")) {
			evento.setDescricao(aValue.toString());
		}
		if (tabelaModelo.getNome(columnIndex).equals("TIPO DE EVENTO")) {
			evento.setTipoEvento((TipoEvento) aValue);
		}
		if (tabelaModelo.getNome(columnIndex).equals("DATA")) {
			evento.setData(aValue.toString());
		}
		if (tabelaModelo.getNome(columnIndex).equals("HORA INÍCIO")) {
			evento.setHoraInicio(aValue.toString());
		}
		if (tabelaModelo.getNome(columnIndex).equals("HORA TÉRMINO")) {
			evento.setHoraTermino(aValue.toString());
		}
		fireTableDataChanged();
	}
}
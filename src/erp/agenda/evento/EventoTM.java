package erp.agenda.evento;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import arquitetura.util.TabelaModelo;

@SuppressWarnings("serial")
public class EventoTM extends AbstractTableModel {

	public static final int ID = 0;
	public static int[] largura;
	private static boolean[] podeEditar;
	private List<Evento> EventoList = new LinkedList<>();
	private Evento evento;
	private static TabelaModelo tabelaModelo = new TabelaModelo();

	public EventoTM() {

	}

	static {
		tabelaModelo.adicionar("ID", 0, 100);
		tabelaModelo.adicionar("DESCRIÇÃO", 1, 500);
		tabelaModelo.adicionar("DATA", 2, 100);
		tabelaModelo.adicionar("HORA INÍCIO", 3, 100);
		tabelaModelo.adicionar("HORA TÉMINO", 4, 100);
		
		largura = new int[tabelaModelo.getTotalColunas()];
		podeEditar = new boolean[tabelaModelo.getTotalColunas()];
		for (int i = 0; i < tabelaModelo.getTotalColunas(); i++) {
			largura[i] = tabelaModelo.getLargura(i);
			podeEditar[i] = false;
		}
	}

	public EventoTM(List<Evento> lista) {
		EventoList.addAll(lista);
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
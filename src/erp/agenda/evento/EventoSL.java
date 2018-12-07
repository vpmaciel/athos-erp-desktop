package erp.agenda.evento;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import erp.main.MainCT;

final class EventoSL implements ListSelectionListener {

	JTable table;

	EventoSL(JTable table) {
		this.table = table;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			int[] selRows = table.getSelectedRows();
			TableModel tm = table.getModel();
			if (selRows.length > 0) {
				Evento eventoPesquisaRegistro = new Evento();
				eventoPesquisaRegistro.setId((Long) tm.getValueAt(selRows[0], EventoTM.ID));

				if (table.getSelectedRow() != -1) {
					Evento evento = EventoFAC.getRegistro(eventoPesquisaRegistro);
					EventoTM eventoTM = (EventoTM) table.getModel();
					eventoTM.getEvento(table.getSelectedRow());
					MainCT.mostrarFrame(MainCT.getAgendaEventoFC());
					MainCT.getAgendaEventoFC().getEventoGerenteEventos().setAgenda(evento);
					MainCT.getAgendaEventoFC().getEventoGerenteEventos().atualizarGui();
					MainCT.getAgendaEventoFC().setFocusable(true);
					MainCT.getAgendaEventoFP().setVisible(false);
				}
			}
		}
	}
}

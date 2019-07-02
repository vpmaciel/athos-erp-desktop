package erp.agenda.evento;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import erp.main.MainControl;

final class EventoSel implements ListSelectionListener {

	JTable table;

	EventoSel(JTable table) {
		this.table = table;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			int[] selRows = table.getSelectedRows();
			TableModel tm = table.getModel();
			if (selRows.length > 0) {
				Evento eventoPesquisaRegistro = new Evento();
				eventoPesquisaRegistro.setId((Long) tm.getValueAt(selRows[0], EventoTm.ID));

				if (table.getSelectedRow() != -1) {
					MainControl.getAgendaEventoFc().reiniciarGui();
					Evento evento = EventoFac.getRegistro(eventoPesquisaRegistro);
					EventoTm eventoTm = (EventoTm) table.getModel();
					eventoTm.getEvento(table.getSelectedRow());
					MainControl.mostrarFrame(MainControl.getAgendaEventoFc());
					MainControl.getAgendaEventoFc().getEventoCont().setEvento(evento);
					MainControl.getAgendaEventoFc().getEventoCont().atualizarGui();
					MainControl.getAgendaEventoFc().setFocusable(true);
					MainControl.getAgendaEventoFp().setVisible(false);
				}
			}
		}
	}
}

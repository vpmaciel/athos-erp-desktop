package erp.agenda.evento;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import erp.main.MainGerenteEventos;

class SelectionListener implements ListSelectionListener {

	JTable table;

	SelectionListener(JTable table) {
		this.table = table;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			int[] selRows = table.getSelectedRows();
			TableModel tm = table.getModel();
			if (selRows.length > 0) {
				Evento eventoPesquisaRegistro = new Evento();
				eventoPesquisaRegistro.setId((Long) tm.getValueAt(selRows[0], EventoTableModel.ID));

				if (table.getSelectedRow() != -1) {
					Evento evento = EventoDaoFacade.getRegistro(eventoPesquisaRegistro);
					EventoTableModel eventoTableModel = (EventoTableModel) table.getModel();
					eventoTableModel.getAgenda(table.getSelectedRow());
					MainGerenteEventos.mostrarFrame(MainGerenteEventos.getFrameCadastroAgendaEvento());
					MainGerenteEventos.getFrameCadastroAgendaEvento().getEventoGerenteEventos().setAgenda(evento);
					MainGerenteEventos.getFrameCadastroAgendaEvento().getEventoGerenteEventos().atualizarGui();
					MainGerenteEventos.getFrameCadastroAgendaEvento().setFocusable(true);
					MainGerenteEventos.getFramePesquisaAgendaEvento().setVisible(false);
				}
			}
		}
	}
}

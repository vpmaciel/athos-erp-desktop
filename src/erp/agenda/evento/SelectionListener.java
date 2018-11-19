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
				Evento agendaPesquisaRegistro = new Evento();
				agendaPesquisaRegistro.setId((Long) tm.getValueAt(selRows[0], EventoTableModel.ID));

				if (table.getSelectedRow() != -1) {
					Evento evento = EventoDaoFacade.getRegistro(agendaPesquisaRegistro);
					EventoTableModel eventoTableModel = (EventoTableModel) table.getModel();
					eventoTableModel.getAgenda(table.getSelectedRow());
					MainGerenteEventos.mostrarFrame(MainGerenteEventos.getFrameCadastroEvento());
					MainGerenteEventos.getFrameCadastroEvento().getEventoGerenteEventos().setAgenda(evento);
					MainGerenteEventos.getFrameCadastroEvento().getEventoGerenteEventos().atualizarGui();
					MainGerenteEventos.getFrameCadastroEvento().setFocusable(true);
					MainGerenteEventos.getFramePesquisaEvento().setVisible(false);
				}
			}
		}
	}
}

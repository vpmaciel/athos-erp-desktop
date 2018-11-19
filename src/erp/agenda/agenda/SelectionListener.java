package erp.agenda.agenda;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import erp.main.FrameMain;
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
				Agenda agendaPesquisaRegistro = new Agenda();
				agendaPesquisaRegistro.setId((Long) tm.getValueAt(selRows[0], AgendaTableModel.ID));

				if (table.getSelectedRow() != -1) {
					Agenda agenda = AgendaDaoFacade.getRegistro(agendaPesquisaRegistro);
					AgendaTableModel agendaTableModel = (AgendaTableModel) table.getModel();
					agendaTableModel.getAgenda(table.getSelectedRow());
					FrameMain.mostrarFrame(MainGerenteEventos.getFrameCadastroAgenda());
					MainGerenteEventos.getFrameCadastroAgenda().getAgendaHandle().setAgenda(agenda);
					MainGerenteEventos.getFrameCadastroAgenda().getAgendaHandle().atualizarGui();
					MainGerenteEventos.getFrameCadastroAgenda().setFocusable(true);
					MainGerenteEventos.getFramePesquisaAgenda().setVisible(false);
				}
			}
		}
	}
}

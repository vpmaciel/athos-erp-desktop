package erp.agenda.evento.tipoevento;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import erp.main.MainControlador;

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
				TipoEvento agendaPesquisaRegistro = new TipoEvento();
				agendaPesquisaRegistro.setId((Long) tm.getValueAt(selRows[0], TipoEventoTableModel.ID));

				if (table.getSelectedRow() != -1) {
					TipoEvento tipoEvento = TipoEventoDaoFacade.getRegistro(agendaPesquisaRegistro);
					TipoEventoTableModel tipoEventoTableModel = (TipoEventoTableModel) table.getModel();
					tipoEventoTableModel.getAgenda(table.getSelectedRow());
					MainControlador.mostrarFrame(MainControlador.getFrameCadastroAgendaTipoEvento());
					MainControlador.getFrameCadastroAgendaTipoEvento().getTipoEventoGerenteEventos()
							.setAgenda(tipoEvento);
					MainControlador.getFrameCadastroAgendaTipoEvento().getTipoEventoGerenteEventos().atualizarGui();
					MainControlador.getFrameCadastroAgendaTipoEvento().setFocusable(true);
					MainControlador.getFramePesquisaAgendaTipoEvento().setVisible(false);
				}
			}
		}
	}
}

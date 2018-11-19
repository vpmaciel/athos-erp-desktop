package erp.agenda.evento.tipoevento;

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
				TipoEvento agendaPesquisaRegistro = new TipoEvento();
				agendaPesquisaRegistro.setId((Long) tm.getValueAt(selRows[0], TipoEventoTableModel.ID));

				if (table.getSelectedRow() != -1) {
					TipoEvento tipoEvento = TipoEventoDaoFacade.getRegistro(agendaPesquisaRegistro);
					TipoEventoTableModel tipoEventoTableModel = (TipoEventoTableModel) table.getModel();
					tipoEventoTableModel.getAgenda(table.getSelectedRow());
					MainGerenteEventos.mostrarFrame(MainGerenteEventos.getFrameCadastroTipoEvento());
					MainGerenteEventos.getFrameCadastroTipoEvento().getTipoEventoGerenteEventos().setAgenda(tipoEvento);
					MainGerenteEventos.getFrameCadastroTipoEvento().getTipoEventoGerenteEventos().atualizarGui();
					MainGerenteEventos.getFrameCadastroTipoEvento().setFocusable(true);
					MainGerenteEventos.getFramePesquisaAgenda().setVisible(false);
				}
			}
		}
	}
}

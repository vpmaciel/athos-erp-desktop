package erp.agenda.evento.tipoevento;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import erp.main.MainCT;

class TipoEventoSL implements ListSelectionListener {

	JTable table;

	TipoEventoSL(JTable table) {
		this.table = table;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			int[] selRows = table.getSelectedRows();
			TableModel tm = table.getModel();
			if (selRows.length > 0) {
				TipoEvento agendaPesquisaRegistro = new TipoEvento();
				agendaPesquisaRegistro.setId((Long) tm.getValueAt(selRows[0], TipoEventoTM.ID));

				if (table.getSelectedRow() != -1) {
					TipoEvento tipoEvento = TipoEventoFAC.getRegistro(agendaPesquisaRegistro);
					TipoEventoTM tipoEventoTM = (TipoEventoTM) table.getModel();
					tipoEventoTM.getTipoEvento(table.getSelectedRow());
					MainCT.mostrarFrame(MainCT.getAgendaTipoEventoPC());
					MainCT.getAgendaTipoEventoPC().getTipoEventoGerenteEventos()
							.setAgenda(tipoEvento);
					MainCT.getAgendaTipoEventoPC().getTipoEventoGerenteEventos().atualizarGui();
					MainCT.getAgendaTipoEventoPC().setFocusable(true);
					MainCT.getAgendaTipoEventoPP().setVisible(false);
				}
			}
		}
	}
}

package erp.agenda.evento.tipoevento;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import erp.main.MainCont;

class TipoEventoSel implements ListSelectionListener {

	JTable table;

	TipoEventoSel(JTable table) {
		this.table = table;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			int[] selRows = table.getSelectedRows();
			TableModel tm = table.getModel();
			if (selRows.length > 0) {
				TipoEvento agendaPesquisaRegistro = new TipoEvento();
				agendaPesquisaRegistro.setId((Long) tm.getValueAt(selRows[0], TipoEventoTm.ID));

				if (table.getSelectedRow() != -1) {
					TipoEvento tipoEvento = TipoEventoFac.getRegistro(agendaPesquisaRegistro);
					TipoEventoTm tipoEventoTm = (TipoEventoTm) table.getModel();
					tipoEventoTm.getTipoEvento(table.getSelectedRow());
					MainCont.mostrarFrame(MainCont.getAgendaTipoEventoFc());
					MainCont.getAgendaTipoEventoFc().getTipoEventoCont()
							.setTipoEvento(tipoEvento);
					MainCont.getAgendaTipoEventoFc().getTipoEventoCont().atualizarGui();
					MainCont.getAgendaTipoEventoFc().setFocusable(true);
					MainCont.getAgendaTipoEventoFp().setVisible(false);
				}
			}
		}
	}
}

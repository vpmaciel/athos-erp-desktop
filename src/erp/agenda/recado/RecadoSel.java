package erp.agenda.recado;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import erp.main.MainControl;

final class RecadoSel implements ListSelectionListener {

	JTable table;

	RecadoSel(JTable table) {
		this.table = table;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			int[] selRows = table.getSelectedRows();
			TableModel tm = table.getModel();
			if (selRows.length > 0) {
				Recado recadoPesquisaRegistro = new Recado();
				recadoPesquisaRegistro.setId((Long) tm.getValueAt(selRows[0], RecadoTm.ID));

				if (table.getSelectedRow() != -1) {
					Recado recado = RecadoFac.getRegistro(recadoPesquisaRegistro);
					RecadoTm recadoTm = (RecadoTm) table.getModel();
					recadoTm.getRecado(table.getSelectedRow());
					MainControl.mostrarFrame(MainControl.getAgendaRecadoFc());
					MainControl.getAgendaRecadoFc().getRecadoCont().setRecado(recado);
					MainControl.getAgendaRecadoFc().getRecadoCont().atualizarGui();
					MainControl.getAgendaRecadoFc().setFocusable(true);
					MainControl.getAgendaRecadoFp().setVisible(false);
				}
			}
		}
	}
}
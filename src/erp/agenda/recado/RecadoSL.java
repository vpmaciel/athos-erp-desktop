package erp.agenda.recado;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import erp.main.MainCT;

final class RecadoSL implements ListSelectionListener {

	JTable table;

	RecadoSL(JTable table) {
		this.table = table;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			int[] selRows = table.getSelectedRows();
			TableModel tm = table.getModel();
			if (selRows.length > 0) {
				Recado recadoPesquisaRegistro = new Recado();
				recadoPesquisaRegistro.setId((Long) tm.getValueAt(selRows[0], RecadoTM.ID));

				if (table.getSelectedRow() != -1) {
					Recado recado = RecadoFAC.getRegistro(recadoPesquisaRegistro);
					RecadoTM recadoTM = (RecadoTM) table.getModel();
					recadoTM.getRecado(table.getSelectedRow());
					MainCT.mostrarFrame(MainCT.getRecadoFC());
					MainCT.getRecadoFC().getRecadoHandle().setRecado(recado);
					MainCT.getRecadoFC().getRecadoHandle().atualizarGui();
					MainCT.getRecadoFC().setFocusable(true);
					MainCT.getRecadoFP().setVisible(false);
				}
			}
		}
	}
}
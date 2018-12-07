package erp.sindicato;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import erp.main.MainCT;

final class SindicatoSL implements ListSelectionListener {

	JTable table;

	SindicatoSL(JTable table) {
		this.table = table;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			int[] selRows = table.getSelectedRows();
			TableModel tm = table.getModel();
			if (selRows.length > 0) {
				Sindicato sindicatoPesquisaRegistro = new Sindicato();
				sindicatoPesquisaRegistro.setId((Long) tm.getValueAt(selRows[0], SindicatoTM.ID));

				if (table.getSelectedRow() != -1) {
					Sindicato sindicato = SindicatoFAC.getRegistro(sindicatoPesquisaRegistro);
					SindicatoTM sindicatoTM = (SindicatoTM) table.getModel();
					sindicatoTM.getSindicato(table.getSelectedRow());
					MainCT.mostrarFrame(MainCT.getSindicatoFC());
					MainCT.getSindicatoFC().getSindicatoHandle().setSindicato(sindicato);
					MainCT.getSindicatoFC().getSindicatoHandle().atualizarGui();
					MainCT.getSindicatoFC().setFocusable(true);
					MainCT.getSindicatoFP().setVisible(false);
				}
			}
		}
	}
}

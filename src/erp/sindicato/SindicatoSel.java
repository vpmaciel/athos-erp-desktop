package erp.sindicato;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import erp.main.MainCont;

final class SindicatoSel implements ListSelectionListener {

	JTable table;

	SindicatoSel(JTable table) {
		this.table = table;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			int[] selRows = table.getSelectedRows();
			TableModel tm = table.getModel();
			if (selRows.length > 0) {
				Sindicato sindicatoPesquisaRegistro = new Sindicato();
				sindicatoPesquisaRegistro.setId((Long) tm.getValueAt(selRows[0], SindicatoTm.ID));

				if (table.getSelectedRow() != -1) {
					Sindicato sindicato = SindicatoFac.getRegistro(sindicatoPesquisaRegistro);
					SindicatoTm sindicatoTm = (SindicatoTm) table.getModel();
					sindicatoTm.getSindicato(table.getSelectedRow());
					MainCont.mostrarFrame(MainCont.getSindicatoFc());
					MainCont.getSindicatoFc().getSindicatoCont().setSindicato(sindicato);
					MainCont.getSindicatoFc().getSindicatoCont().atualizarGui();
					MainCont.getSindicatoFc().setFocusable(true);
					MainCont.getSindicatoFp().setVisible(false);
				}
			}
		}
	}
}

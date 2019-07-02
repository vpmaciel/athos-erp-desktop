package erp.centrocusto;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import erp.main.MainControl;

final class CentroCustoSel implements ListSelectionListener {

	JTable table;

	CentroCustoSel(JTable table) {
		this.table = table;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			int[] selRows = table.getSelectedRows();
			TableModel tm = table.getModel();
			if (selRows.length > 0) {
				CentroCusto centroCustoPesquisaRegistro = new CentroCusto();
				centroCustoPesquisaRegistro.setId((Long) tm.getValueAt(selRows[0], CentroCustoTm.ID));

				if (table.getSelectedRow() != -1) {
					CentroCusto centroCusto = CentroCustoFac.getRegistro(centroCustoPesquisaRegistro);
					CentroCustoTm centroCustoTm = (CentroCustoTm) table.getModel();
					centroCustoTm.getCentroCusto(table.getSelectedRow());
					MainControl.mostrarFrame(MainControl.getCentroCustoFc());
					MainControl.getCentroCustoFc().getCentroCustoCont().setCentroCusto(centroCusto);
					MainControl.getCentroCustoFc().getCentroCustoCont().atualizarGui();
					MainControl.getCentroCustoFc().setFocusable(true);
					MainControl.getCentroCustoFp().setVisible(false);
				}
			}
		}
	}
}

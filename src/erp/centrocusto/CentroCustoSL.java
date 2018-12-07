package erp.centrocusto;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import erp.main.MainCT;

final class CentroCustoSL implements ListSelectionListener {

	JTable table;

	CentroCustoSL(JTable table) {
		this.table = table;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			int[] selRows = table.getSelectedRows();
			TableModel tm = table.getModel();
			if (selRows.length > 0) {
				CentroCusto centroCustoPesquisaRegistro = new CentroCusto();
				centroCustoPesquisaRegistro.setId((Long) tm.getValueAt(selRows[0], CentroCustoTM.ID));

				if (table.getSelectedRow() != -1) {
					CentroCusto centroCusto = CentroCustoFAC.getRegistro(centroCustoPesquisaRegistro);
					CentroCustoTM centroCustoTM = (CentroCustoTM) table.getModel();
					centroCustoTM.getCentroCusto(table.getSelectedRow());
					MainCT.mostrarFrame(MainCT.getCentroCustoFC());
					MainCT.getCentroCustoFC().getCentroCustoHandle().setCentroCusto(centroCusto);
					MainCT.getCentroCustoFC().getCentroCustoHandle().atualizarGui();
					MainCT.getCentroCustoFC().setFocusable(true);
					MainCT.getCentroCustoFP().setVisible(false);
				}
			}
		}
	}
}

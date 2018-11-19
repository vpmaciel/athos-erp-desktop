package erp.centrocusto;

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
				CentroCusto centroCustoPesquisaRegistro = new CentroCusto();
				centroCustoPesquisaRegistro.setId((Long) tm.getValueAt(selRows[0], CentroCustoTableModel.ID));

				if (table.getSelectedRow() != -1) {
					CentroCusto centroCusto = CentroCustoDaoFacade.getRegistro(centroCustoPesquisaRegistro);
					CentroCustoTableModel centroCustoTableModel = (CentroCustoTableModel) table.getModel();
					centroCustoTableModel.getCentroCusto(table.getSelectedRow());
					MainGerenteEventos.mostrarFrame(MainGerenteEventos.getFrameCadastroCentroCusto());
					MainGerenteEventos.getFrameCadastroCentroCusto().getCentroCustoHandle().setCentroCusto(centroCusto);
					MainGerenteEventos.getFrameCadastroCentroCusto().getCentroCustoHandle().atualizarGui();
					MainGerenteEventos.getFrameCadastroCentroCusto().setFocusable(true);
					MainGerenteEventos.getFramePesquisaCentroCusto().setVisible(false);
				}
			}
		}
	}
}

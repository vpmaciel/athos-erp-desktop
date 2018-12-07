package erp.fornecedor;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import erp.main.MainCT;

final class FornecedorSL implements ListSelectionListener {

	JTable table;

	FornecedorSL(JTable table) {
		this.table = table;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			int[] selRows = table.getSelectedRows();
			TableModel tm = table.getModel();
			if (selRows.length > 0) {
				Fornecedor fornecedorPesquisaRegistro = new Fornecedor();
				fornecedorPesquisaRegistro.setId((Long) tm.getValueAt(selRows[0], FornecedorTM.ID));

				if (table.getSelectedRow() != -1) {
					Fornecedor fornecedor = FornecedorFAC.getRegistro(fornecedorPesquisaRegistro);
					FornecedorTM fornecedorTM = (FornecedorTM) table.getModel();
					fornecedorTM.getFornecedor(table.getSelectedRow());
					MainCT.mostrarFrame(MainCT.getFornecedorFC());
					MainCT.getFornecedorFC().getFornecedorHandle().setFornecedor(fornecedor);
					MainCT.getFornecedorFC().getFornecedorHandle().atualizarGui();
					MainCT.getFornecedorFC().setFocusable(true);
					MainCT.getFornecedorFP().setVisible(false);
				}
			}
		}
	}
}

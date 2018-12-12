package erp.fornecedor;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import erp.main.MainCont;

final class FornecedorSel implements ListSelectionListener {

	JTable table;

	FornecedorSel(JTable table) {
		this.table = table;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			int[] selRows = table.getSelectedRows();
			TableModel tm = table.getModel();
			if (selRows.length > 0) {
				Fornecedor fornecedorPesquisaRegistro = new Fornecedor();
				fornecedorPesquisaRegistro.setId((Long) tm.getValueAt(selRows[0], FornecedorTm.ID));

				if (table.getSelectedRow() != -1) {
					Fornecedor fornecedor = FornecedorFac.getRegistro(fornecedorPesquisaRegistro);
					FornecedorTm fornecedorTm = (FornecedorTm) table.getModel();
					fornecedorTm.getFornecedor(table.getSelectedRow());
					MainCont.mostrarFrame(MainCont.getFornecedorFc());
					MainCont.getFornecedorFc().getFornecedorHandle().setFornecedor(fornecedor);
					MainCont.getFornecedorFc().getFornecedorHandle().atualizarGui();
					MainCont.getFornecedorFc().setFocusable(true);
					MainCont.getFornecedorFp().setVisible(false);
				}
			}
		}
	}
}

package erp.fornecedor;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import erp.main.MainControlador;

final class SelectionListener implements ListSelectionListener {

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
				Fornecedor fornecedorPesquisaRegistro = new Fornecedor();
				fornecedorPesquisaRegistro.setId((Long) tm.getValueAt(selRows[0], FornecedorTableModel.ID));

				if (table.getSelectedRow() != -1) {
					Fornecedor fornecedor = FornecedorDaoFacade.getRegistro(fornecedorPesquisaRegistro);
					FornecedorTableModel fornecedorTableModel = (FornecedorTableModel) table.getModel();
					fornecedorTableModel.getFornecedor(table.getSelectedRow());
					MainControlador.mostrarFrame(MainControlador.getFrameCadastroFornecedor());
					MainControlador.getFrameCadastroFornecedor().getFornecedorHandle().setFornecedor(fornecedor);
					MainControlador.getFrameCadastroFornecedor().getFornecedorHandle().atualizarGui();
					MainControlador.getFrameCadastroFornecedor().setFocusable(true);
					MainControlador.getFramePesquisaFornecedor().setVisible(false);
				}
			}
		}
	}
}

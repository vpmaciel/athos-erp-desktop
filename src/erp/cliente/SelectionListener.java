package erp.cliente;

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
				Cliente clientePesquisaRegistro = new Cliente();
				clientePesquisaRegistro.setId((Long) tm.getValueAt(selRows[0], ClienteTableModel.ID));

				if (table.getSelectedRow() != -1) {
					Cliente cliente = ClienteDaoFacade.getRegistro(clientePesquisaRegistro);
					ClienteTableModel clienteTableModel = (ClienteTableModel) table.getModel();
					clienteTableModel.getCliente(table.getSelectedRow());
					MainControlador.mostrarFrame(MainControlador.getFrameCadastroCliente());
					MainControlador.getFrameCadastroCliente().getClienteHandle().setCliente(cliente);
					MainControlador.getFrameCadastroCliente().getClienteHandle().atualizarGui();
					MainControlador.getFrameCadastroCliente().setFocusable(true);
					MainControlador.getFramePesquisaCliente().setVisible(false);
				}
			}
		}
	}
}

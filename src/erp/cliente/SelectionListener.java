package erp.cliente;

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
				Cliente clientePesquisaRegistro = new Cliente();
				clientePesquisaRegistro.setId((Long) tm.getValueAt(selRows[0], ClienteTableModel.ID));

				if (table.getSelectedRow() != -1) {
					Cliente cliente = ClienteDaoFacade.getRegistro(clientePesquisaRegistro);
					ClienteTableModel clienteTableModel = (ClienteTableModel) table.getModel();
					clienteTableModel.getCliente(table.getSelectedRow());
					MainGerenteEventos.mostrarFrame(MainGerenteEventos.getFrameCadastroCliente());
					MainGerenteEventos.getFrameCadastroCliente().getClienteHandle().setCliente(cliente);
					MainGerenteEventos.getFrameCadastroCliente().getClienteHandle().atualizarGui();
					MainGerenteEventos.getFrameCadastroCliente().setFocusable(true);
					MainGerenteEventos.getFramePesquisaCliente().setVisible(false);
				}
			}
		}
	}
}

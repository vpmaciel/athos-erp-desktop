package erp.cliente;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import erp.main.MainCT;

final class ClienteSL implements ListSelectionListener {

	JTable table;

	ClienteSL(JTable table) {
		this.table = table;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			int[] selRows = table.getSelectedRows();
			TableModel tm = table.getModel();
			if (selRows.length > 0) {
				Cliente clientePesquisaRegistro = new Cliente();
				clientePesquisaRegistro.setId((Long) tm.getValueAt(selRows[0], ClienteTM.ID));

				if (table.getSelectedRow() != -1) {
					Cliente cliente = ClienteFAC.getRegistro(clientePesquisaRegistro);
					ClienteTM clienteTM = (ClienteTM) table.getModel();
					clienteTM.getCliente(table.getSelectedRow());
					MainCT.mostrarFrame(MainCT.getClienteFC());
					MainCT.getClienteFC().getClienteHandle().setCliente(cliente);
					MainCT.getClienteFC().getClienteHandle().atualizarGui();
					MainCT.getClienteFC().setFocusable(true);
					MainCT.getClienteFP().setVisible(false);
				}
			}
		}
	}
}

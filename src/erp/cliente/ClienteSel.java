package erp.cliente;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import erp.main.MainControl;

final class ClienteSel implements ListSelectionListener {

	JTable table;

	ClienteSel(JTable table) {
		this.table = table;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			int[] selRows = table.getSelectedRows();
			TableModel tm = table.getModel();
			if (selRows.length > 0) {
				Cliente clientePesquisaRegistro = new Cliente();
				clientePesquisaRegistro.setId((Long) tm.getValueAt(selRows[0], ClienteTm.ID));

				if (table.getSelectedRow() != -1) {
					Cliente cliente = ClienteFac.getRegistro(clientePesquisaRegistro);
					ClienteTm clienteTm = (ClienteTm) table.getModel();
					clienteTm.getCliente(table.getSelectedRow());
					MainControl.mostrarFrame(MainControl.getClienteFc());
					MainControl.getClienteFc().getClienteCont().setCliente(cliente);
					MainControl.getClienteFc().getClienteCont().atualizarGui();
					MainControl.getClienteFc().setFocusable(true);
					MainControl.getClienteFp().setVisible(false);
				}
			}
		}
	}
}

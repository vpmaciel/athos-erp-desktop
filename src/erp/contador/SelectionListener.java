package erp.contador;

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
				Contador contadorPesquisaRegistro = new Contador();
				contadorPesquisaRegistro.setId((Long) tm.getValueAt(selRows[0], ContadorTableModel.ID));

				if (table.getSelectedRow() != -1) {
					Contador contador = ContadorDaoFacade.getRegistro(contadorPesquisaRegistro);
					ContadorTableModel contadorTableModel = (ContadorTableModel) table.getModel();
					contadorTableModel.getContador(table.getSelectedRow());
					MainControlador.mostrarFrame(MainControlador.getFrameCadastroContador());
					MainControlador.getFrameCadastroContador().getContadorHandle().setContador(contador);
					MainControlador.getFrameCadastroContador().getContadorHandle().atualizarGui();
					MainControlador.getFrameCadastroContador().setFocusable(true);
					MainControlador.getFramePesquisaContador().setVisible(false);
				}
			}
		}
	}
}

package erp.veiculomodelo;

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
				VeiculoModelo veiculoModeloPesquisaRegistro = new VeiculoModelo();
				veiculoModeloPesquisaRegistro.setId((Long) tm.getValueAt(selRows[0], VeiculoModeloTableModel.ID));

				if (table.getSelectedRow() != -1) {
					VeiculoModelo veiculoModelo = VeiculoModeloDaoFacade.getRegistro(veiculoModeloPesquisaRegistro);
					VeiculoModeloTableModel veiculoModeloTableModel = (VeiculoModeloTableModel) table.getModel();
					veiculoModeloTableModel.getVeiculoModelo(table.getSelectedRow());
					MainControlador.mostrarFrame(MainControlador.getFrameCadastroVeiculoModelo());
					MainControlador.getFrameCadastroVeiculoModelo().getVeiculoModeloHandle()
							.setVeiculoModelo(veiculoModelo);
					MainControlador.getFrameCadastroVeiculoModelo().getVeiculoModeloHandle().atualizarGui();
					MainControlador.getFrameCadastroVeiculoModelo().setFocusable(true);
					MainControlador.getFramePesquisaVeiculoModelo().setVisible(false);
				}
			}
		}
	}
}

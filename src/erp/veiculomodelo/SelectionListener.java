package erp.veiculo.modelo;

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
				VeiculoModelo veiculoModeloPesquisaRegistro = new VeiculoModelo();
				veiculoModeloPesquisaRegistro.setId((Long) tm.getValueAt(selRows[0], VeiculoModeloTableModel.ID));

				if (table.getSelectedRow() != -1) {
					VeiculoModelo veiculoModelo = VeiculoModeloDaoFacade.getRegistro(veiculoModeloPesquisaRegistro);
					VeiculoModeloTableModel veiculoModeloTableModel = (VeiculoModeloTableModel) table.getModel();
					veiculoModeloTableModel.getVeiculoModelo(table.getSelectedRow());
					MainGerenteEventos.mostrarFrame(MainGerenteEventos.getFrameCadastroVeiculoModelo());
					MainGerenteEventos.getFrameCadastroVeiculoModelo().getVeiculoModeloHandle()
							.setVeiculoModelo(veiculoModelo);
					MainGerenteEventos.getFrameCadastroVeiculoModelo().getVeiculoModeloHandle().atualizarGui();
					MainGerenteEventos.getFrameCadastroVeiculoModelo().setFocusable(true);
					MainGerenteEventos.getFramePesquisaVeiculoModelo().setVisible(false);
				}
			}
		}
	}
}

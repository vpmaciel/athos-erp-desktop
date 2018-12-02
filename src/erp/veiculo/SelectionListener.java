package erp.veiculo;

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
				Veiculo veiculoPesquisaRegistro = new Veiculo();
				veiculoPesquisaRegistro.setId((Long) tm.getValueAt(selRows[0], VeiculoTableModel.ID));

				if (table.getSelectedRow() != -1) {
					Veiculo veiculo = VeiculoDaoFacade.getRegistro(veiculoPesquisaRegistro);
					VeiculoTableModel veiculoTableModel = (VeiculoTableModel) table.getModel();
					veiculoTableModel.getVeiculo(table.getSelectedRow());
					MainGerenteEventos.mostrarFrame(MainGerenteEventos.getFrameCadastroVeiculo());
					MainGerenteEventos.getFrameCadastroVeiculo().getVeiculoGerenteEventos().setVeiculo(veiculo);
					MainGerenteEventos.getFrameCadastroVeiculo().getVeiculoGerenteEventos().atualizarGui();
					MainGerenteEventos.getFrameCadastroVeiculo().setFocusable(true);
					MainGerenteEventos.getFramePesquisaVeiculo().setVisible(false);
				}
			}
		}
	}
}

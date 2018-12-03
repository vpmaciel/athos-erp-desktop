package erp.veiculo;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import erp.main.MainControlador;

public final class SelectionListener implements ListSelectionListener {

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
					MainControlador.mostrarFrame(MainControlador.getFrameCadastroVeiculo());
					MainControlador.getFrameCadastroVeiculo().getVeiculoGerenteEventos().setVeiculo(veiculo);
					MainControlador.getFrameCadastroVeiculo().getVeiculoGerenteEventos().atualizarGui();
					MainControlador.getFrameCadastroVeiculo().setFocusable(true);
					MainControlador.getFramePesquisaVeiculo().setVisible(false);
				}
			}
		}
	}
}

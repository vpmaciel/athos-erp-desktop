package erp.veiculo.marca;

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
				VeiculoMarca veiculoMarcaPesquisaRegistro = new VeiculoMarca();
				veiculoMarcaPesquisaRegistro.setId((Long) tm.getValueAt(selRows[0], VeiculoMarcaTableModel.ID));

				if (table.getSelectedRow() != -1) {
					VeiculoMarca veiculoMarca = VeiculoMarcaDaoFacade.getRegistro(veiculoMarcaPesquisaRegistro);
					VeiculoMarcaTableModel veiculoMarcaTableModel = (VeiculoMarcaTableModel) table.getModel();
					veiculoMarcaTableModel.getVeiculoMarca(table.getSelectedRow());
					MainGerenteEventos.mostrarFrame(MainGerenteEventos.getFrameCadastroVeiculoMarca());
					MainGerenteEventos.getFrameCadastroVeiculoMarca().getVeiculoMarcaHandle().setVeiculoMarca(veiculoMarca);
					MainGerenteEventos.getFrameCadastroVeiculoMarca().getVeiculoMarcaHandle().atualizarGui();
					MainGerenteEventos.getFrameCadastroVeiculoMarca().setFocusable(true);
					MainGerenteEventos.getFramePesquisaVeiculoMarca().setVisible(false);
				}
			}
		}
	}
}

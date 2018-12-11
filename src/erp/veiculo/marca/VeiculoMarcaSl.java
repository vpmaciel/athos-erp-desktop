package erp.veiculo.marca;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import erp.main.MainCT;

final class VeiculoMarcaSL implements ListSelectionListener {

	JTable table;

	VeiculoMarcaSL(JTable table) {
		this.table = table;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			int[] selRows = table.getSelectedRows();
			TableModel tm = table.getModel();
			if (selRows.length > 0) {
				VeiculoMarca veiculoMarcaPesquisaRegistro = new VeiculoMarca();
				veiculoMarcaPesquisaRegistro.setId((Long) tm.getValueAt(selRows[0], VeiculoMarcaTM.ID));

				if (table.getSelectedRow() != -1) {
					VeiculoMarca veiculoMarca = VeiculoMarcaFAC.getRegistro(veiculoMarcaPesquisaRegistro);
					VeiculoMarcaTM veiculoMarcaTM = (VeiculoMarcaTM) table.getModel();
					veiculoMarcaTM.getVeiculoMarca(table.getSelectedRow());
					MainCT.mostrarFrame(MainCT.getFrameCadastroVeiculoMarca());
					MainCT.getFrameCadastroVeiculoMarca().getVeiculoMarcaHandle()
							.setVeiculoMarca(veiculoMarca);
					MainCT.getFrameCadastroVeiculoMarca().getVeiculoMarcaHandle().atualizarGui();
					MainCT.getFrameCadastroVeiculoMarca().setFocusable(true);
					MainCT.getFramePesquisaVeiculoMarca().setVisible(false);
				}
			}
		}
	}
}

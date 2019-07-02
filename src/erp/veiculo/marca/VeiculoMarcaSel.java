package erp.veiculo.marca;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import erp.main.MainControl;

final class VeiculoMarcaSel implements ListSelectionListener {

	JTable table;

	VeiculoMarcaSel(JTable table) {
		this.table = table;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			int[] selRows = table.getSelectedRows();
			TableModel tm = table.getModel();
			if (selRows.length > 0) {
				VeiculoMarca veiculoMarcaPesquisaRegistro = new VeiculoMarca();
				veiculoMarcaPesquisaRegistro.setId((Long) tm.getValueAt(selRows[0], VeiculoMarcaTm.ID));

				if (table.getSelectedRow() != -1) {
					VeiculoMarca veiculoMarca = VeiculoMarcaFac.getRegistro(veiculoMarcaPesquisaRegistro);
					VeiculoMarcaTm veiculoMarcaTm = (VeiculoMarcaTm) table.getModel();
					veiculoMarcaTm.getVeiculoMarca(table.getSelectedRow());
					MainControl.mostrarFrame(MainControl.getVeiculoMarcaFc());
					MainControl.getVeiculoMarcaFc().getVeiculoMarcaCont().setVeiculoMarca(veiculoMarca);
					MainControl.getVeiculoMarcaFc().getVeiculoMarcaCont().atualizarGui();
					MainControl.getVeiculoMarcaFc().setFocusable(true);
					MainControl.getVeiculoMarcaFp().setVisible(false);
				}
			}
		}
	}
}

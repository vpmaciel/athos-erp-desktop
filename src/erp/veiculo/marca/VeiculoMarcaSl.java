package erp.veiculo.marca;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import erp.main.MainCont;

final class VeiculoMarcaSl implements ListSelectionListener {

	JTable table;

	VeiculoMarcaSl(JTable table) {
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
					MainCont.mostrarFrame(MainCont.getVeiculoMarcaFc());
					MainCont.getVeiculoMarcaFc().getVeiculoMarcaHandle()
							.setVeiculoMarca(veiculoMarca);
					MainCont.getVeiculoMarcaFc().getVeiculoMarcaHandle().atualizarGui();
					MainCont.getVeiculoMarcaFc().setFocusable(true);
					MainCont.getVeiculoMarcaFp().setVisible(false);
				}
			}
		}
	}
}
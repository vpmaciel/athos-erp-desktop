package erp.veiculo.modelo;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import erp.main.MainCont;

final class VeiculoModeloSel implements ListSelectionListener {

	JTable table;

	VeiculoModeloSel(JTable table) {
		this.table = table;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			int[] selRows = table.getSelectedRows();
			TableModel tm = table.getModel();
			if (selRows.length > 0) {
				VeiculoModelo veiculoModeloPesquisaRegistro = new VeiculoModelo();
				veiculoModeloPesquisaRegistro.setId((Long) tm.getValueAt(selRows[0], VeiculoModeloTm.ID));

				if (table.getSelectedRow() != -1) {
					VeiculoModelo veiculoModelo = VeiculoModeloFac.getRegistro(veiculoModeloPesquisaRegistro);
					VeiculoModeloTm veiculoModeloTm = (VeiculoModeloTm) table.getModel();
					veiculoModeloTm.getVeiculoModelo(table.getSelectedRow());
					MainCont.mostrarFrame(MainCont.getVeiculoModeloFc());
					MainCont.getVeiculoModeloFc().getVeiculoModeloCont().setVeiculoModelo(veiculoModelo);
					MainCont.getVeiculoModeloFc().getVeiculoModeloCont().atualizarGui();
					MainCont.getVeiculoModeloFc().setFocusable(true);
					MainCont.getVeiculoModeloFp().setVisible(false);
				}
			}
		}
	}
}

package erp.veiculo.modelo;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import erp.main.MainCT;

final class VeiculoModeloSL implements ListSelectionListener {

	JTable table;

	VeiculoModeloSL(JTable table) {
		this.table = table;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			int[] selRows = table.getSelectedRows();
			TableModel tm = table.getModel();
			if (selRows.length > 0) {
				VeiculoModelo veiculoModeloPesquisaRegistro = new VeiculoModelo();
				veiculoModeloPesquisaRegistro.setId((Long) tm.getValueAt(selRows[0], VeiculoModeloTM.ID));

				if (table.getSelectedRow() != -1) {
					VeiculoModelo veiculoModelo = VeiculoModeloFAC.getRegistro(veiculoModeloPesquisaRegistro);
					VeiculoModeloTM veiculoModeloTM = (VeiculoModeloTM) table.getModel();
					veiculoModeloTM.getVeiculoModelo(table.getSelectedRow());
					MainCT.mostrarFrame(MainCT.getFrameCadastroVeiculoModelo());
					MainCT.getFrameCadastroVeiculoModelo().getVeiculoModeloHandle()
							.setVeiculoModelo(veiculoModelo);
					MainCT.getFrameCadastroVeiculoModelo().getVeiculoModeloHandle().atualizarGui();
					MainCT.getFrameCadastroVeiculoModelo().setFocusable(true);
					MainCT.getFramePesquisaVeiculoModelo().setVisible(false);
				}
			}
		}
	}
}

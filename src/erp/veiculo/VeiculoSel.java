package erp.veiculo;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import erp.main.MainCont;

public final class VeiculoSel implements ListSelectionListener {

	JTable table;

	VeiculoSel(JTable table) {
		this.table = table;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			int[] selRows = table.getSelectedRows();
			TableModel tm = table.getModel();
			if (selRows.length > 0) {
				Veiculo veiculoPesquisaRegistro = new Veiculo();
				veiculoPesquisaRegistro.setId((Long) tm.getValueAt(selRows[0], VeiculoTm.ID));

				if (table.getSelectedRow() != -1) {
					Veiculo veiculo = VeiculoFac.getRegistro(veiculoPesquisaRegistro);
					VeiculoTm veiculoTm = (VeiculoTm) table.getModel();
					veiculoTm.getVeiculo(table.getSelectedRow());
					MainCont.mostrarFrame(MainCont.getVeiculoFc());
					MainCont.getVeiculoFc().getVeiculoCont().setVeiculo(veiculo);
					MainCont.getVeiculoFc().getVeiculoCont().atualizarGui();
					MainCont.getVeiculoFc().setFocusable(true);
					MainCont.getVeiculoFp().setVisible(false);
				}
			}
		}
	}
}

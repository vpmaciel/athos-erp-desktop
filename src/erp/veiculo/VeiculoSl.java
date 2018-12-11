package erp.veiculo;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import erp.main.MainCT;

public final class VeiculoSl implements ListSelectionListener {

	JTable table;

	VeiculoSl(JTable table) {
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
					MainCT.mostrarFrame(MainCT.getFrameCadastroVeiculo());
					MainCT.getFrameCadastroVeiculo().getVeiculoGerenteEventos().setVeiculo(veiculo);
					MainCT.getFrameCadastroVeiculo().getVeiculoGerenteEventos().atualizarGui();
					MainCT.getFrameCadastroVeiculo().setFocusable(true);
					MainCT.getFramePesquisaVeiculo().setVisible(false);
				}
			}
		}
	}
}

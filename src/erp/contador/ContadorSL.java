package erp.contador;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import erp.main.MainCT;

final class ContadorSL implements ListSelectionListener {

	JTable table;

	ContadorSL(JTable table) {
		this.table = table;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			int[] selRows = table.getSelectedRows();
			TableModel tm = table.getModel();
			if (selRows.length > 0) {
				Contador contadorPesquisaRegistro = new Contador();
				contadorPesquisaRegistro.setId((Long) tm.getValueAt(selRows[0], ContadorTM.ID));

				if (table.getSelectedRow() != -1) {
					Contador contador = ContadorFAC.getRegistro(contadorPesquisaRegistro);
					ContadorTM contadorTM = (ContadorTM) table.getModel();
					contadorTM.getContador(table.getSelectedRow());
					MainCT.mostrarFrame(MainCT.getFrameCadastroContador());
					MainCT.getFrameCadastroContador().getContadorHandle().setContador(contador);
					MainCT.getFrameCadastroContador().getContadorHandle().atualizarGui();
					MainCT.getFrameCadastroContador().setFocusable(true);
					MainCT.getFramePesquisaContador().setVisible(false);
				}
			}
		}
	}
}

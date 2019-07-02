package erp.banco;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import erp.main.MainControl;

final class BancoSel implements ListSelectionListener {

	JTable table;

	BancoSel(JTable table) {
		this.table = table;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			int[] selRows = table.getSelectedRows();
			TableModel tm = table.getModel();
			if (selRows.length > 0) {
				Banco bancoPesquisaRegistro = new Banco();
				bancoPesquisaRegistro.setId((Long) tm.getValueAt(selRows[0], BancoTm.ID));

				if (table.getSelectedRow() != -1) {
					Banco banco = BancoFac.getRegistro(bancoPesquisaRegistro);
					BancoTm bancoTm = (BancoTm) table.getModel();
					bancoTm.getBanco(table.getSelectedRow());
					MainControl.mostrarFrame(MainControl.getBancoFc());
					MainControl.getBancoFc().getBancoCont().setBanco(banco);
					MainControl.getBancoFc().getBancoCont().atualizarGui();
					MainControl.getBancoFc().setFocusable(true);
					MainControl.getBancoFp().setVisible(false);
				}
			}
		}
	}
}

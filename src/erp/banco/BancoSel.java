package erp.banco;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import erp.main.MainCont;

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
					MainCont.mostrarFrame(MainCont.getBancoFc());
					MainCont.getBancoFc().getBancoCont().setBanco(banco);
					MainCont.getBancoFc().getBancoCont().atualizarGui();
					MainCont.getBancoFc().setFocusable(true);
					MainCont.getBancoFp().setVisible(false);
				}
			}
		}
	}
}

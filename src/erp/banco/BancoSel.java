package erp.banco;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import erp.main.MainCont;

final class BancoSel implements ListSelectionListener {

	JTable table;
	private final BancoFac bancoFac = new BancoFac();

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
					Banco banco = bancoFac.getRegistro(bancoPesquisaRegistro);
					BancoTm bancoTm = (BancoTm) table.getModel();
					bancoTm.getBanco(table.getSelectedRow());
					MainCont.mostrarFrame(MainCont.getBancoFc());
					MainCont.getBancoFc().getBancoHandle().setBanco(banco);
					MainCont.getBancoFc().getBancoHandle().atualizarGui();
					MainCont.getBancoFc().setFocusable(true);
					MainCont.getBancoFp().setVisible(false);
				}
			}
		}
	}
}

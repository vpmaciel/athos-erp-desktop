package erp.banco;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import erp.main.MainCT;

final class BancoSL implements ListSelectionListener {

	JTable table;
	private final BancoFAC bancoFAC = new BancoFAC();

	BancoSL(JTable table) {
		this.table = table;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			int[] selRows = table.getSelectedRows();
			TableModel tm = table.getModel();
			if (selRows.length > 0) {
				Banco bancoPesquisaRegistro = new Banco();
				bancoPesquisaRegistro.setId((Long) tm.getValueAt(selRows[0], BancoTM.ID));

				if (table.getSelectedRow() != -1) {
					Banco banco = bancoFAC.getRegistro(bancoPesquisaRegistro);
					BancoTM bancoTM = (BancoTM) table.getModel();
					bancoTM.getBanco(table.getSelectedRow());
					MainCT.mostrarFrame(MainCT.getBancoFC());
					MainCT.getBancoFC().getBancoHandle().setBanco(banco);
					MainCT.getBancoFC().getBancoHandle().atualizarGui();
					MainCT.getBancoFC().setFocusable(true);
					MainCT.getBancoFP().setVisible(false);
				}
			}
		}
	}
}

package erp.imovel;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import erp.main.MainCT;

final class ImovelSL implements ListSelectionListener {

	JTable table;

	ImovelSL(JTable table) {
		this.table = table;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			int[] selRows = table.getSelectedRows();
			TableModel tm = table.getModel();
			if (selRows.length > 0) {
				Imovel imovelPesquisaRegistro = new Imovel();
				imovelPesquisaRegistro.setId((Long) tm.getValueAt(selRows[0], ImovelTM.ID));

				if (table.getSelectedRow() != -1) {
					Imovel imovel = ImovelFAC.getRegistro(imovelPesquisaRegistro);
					ImovelTM imovelTM = (ImovelTM) table.getModel();
					imovelTM.getImovel(table.getSelectedRow());
					MainCT.mostrarFrame(MainCT.getImovelFC());
					MainCT.getImovelFC().getImovelHandle().setImovel(imovel);
					MainCT.getImovelFC().getImovelHandle().atualizarGui();
					MainCT.getImovelFC().setFocusable(true);
					MainCT.getImovelFP().setVisible(false);
				}
			}
		}
	}
}

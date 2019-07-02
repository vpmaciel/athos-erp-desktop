package erp.imovel;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import erp.main.MainControl;

final class ImovelSel implements ListSelectionListener {

	JTable table;

	ImovelSel(JTable table) {
		this.table = table;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			int[] selRows = table.getSelectedRows();
			TableModel tm = table.getModel();
			if (selRows.length > 0) {
				Imovel imovelPesquisaRegistro = new Imovel();
				imovelPesquisaRegistro.setId((Long) tm.getValueAt(selRows[0], ImovelTm.ID));

				if (table.getSelectedRow() != -1) {
					Imovel imovel = ImovelFac.getRegistro(imovelPesquisaRegistro);
					ImovelTm imovelTm = (ImovelTm) table.getModel();
					imovelTm.getImovel(table.getSelectedRow());
					MainControl.mostrarFrame(MainControl.getImovelFc());
					MainControl.getImovelFc().getImovelCont().setImovel(imovel);
					MainControl.getImovelFc().getImovelCont().atualizarGui();
					MainControl.getImovelFc().setFocusable(true);
					MainControl.getImovelFp().setVisible(false);
				}
			}
		}
	}
}

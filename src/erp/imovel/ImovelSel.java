package erp.imovel;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import erp.main.MainCont;

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
					MainCont.mostrarFrame(MainCont.getImovelFc());
					MainCont.getImovelFc().getImovelCont().setImovel(imovel);
					MainCont.getImovelFc().getImovelCont().atualizarGui();
					MainCont.getImovelFc().setFocusable(true);
					MainCont.getImovelFp().setVisible(false);
				}
			}
		}
	}
}

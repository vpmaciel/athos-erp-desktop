package erp.cartorio;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import erp.main.MainCT;

final class CartorioSL implements ListSelectionListener {

	JTable table;

	CartorioSL(JTable table) {
		this.table = table;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			int[] selRows = table.getSelectedRows();
			TableModel tm = table.getModel();
			if (selRows.length > 0) {
				Cartorio cartorioPesquisaRegistro = new Cartorio();
				cartorioPesquisaRegistro.setId((Long) tm.getValueAt(selRows[0], CartorioTM.ID));

				if (table.getSelectedRow() != -1) {
					Cartorio cartorio = CartorioFAC.getCartorio(cartorioPesquisaRegistro);
					CartorioTM cartorioTM = (CartorioTM) table.getModel();
					cartorioTM.getCartorio(table.getSelectedRow());
					MainCT.mostrarFrame(MainCT.getCartorioFC());
					MainCT.getCartorioFC().getCartorioHandle().setCartorio(cartorio);
					MainCT.getCartorioFC().getCartorioHandle().atualizarGui();
					MainCT.getCartorioFC().setFocusable(true);
					MainCT.getCartorioFP().setVisible(false);
				}
			}
		}
	}
}

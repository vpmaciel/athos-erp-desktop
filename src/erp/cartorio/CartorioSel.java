package erp.cartorio;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import erp.main.MainControl;

final class CartorioSel implements ListSelectionListener {

	JTable table;

	CartorioSel(JTable table) {
		this.table = table;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			int[] selRows = table.getSelectedRows();
			TableModel tm = table.getModel();
			if (selRows.length > 0) {
				Cartorio cartorioPesquisaRegistro = new Cartorio();
				cartorioPesquisaRegistro.setId((Long) tm.getValueAt(selRows[0], CartorioTm.ID));

				if (table.getSelectedRow() != -1) {
					Cartorio cartorio = CartorioFac.getRegistro(cartorioPesquisaRegistro);
					CartorioTm cartorioTm = (CartorioTm) table.getModel();
					cartorioTm.getCartorio(table.getSelectedRow());
					MainControl.mostrarFrame(MainControl.getCartorioFc());
					MainControl.getCartorioFc().getCartorioCont().setCartorio(cartorio);
					MainControl.getCartorioFc().getCartorioCont().atualizarGui();
					MainControl.getCartorioFc().setFocusable(true);
					MainControl.getCartorioFp().setVisible(false);
				}
			}
		}
	}
}

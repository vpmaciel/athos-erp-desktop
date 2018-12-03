package erp.cartorio;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import erp.main.MainControlador;

final class SelectionListener implements ListSelectionListener {

	JTable table;

	SelectionListener(JTable table) {
		this.table = table;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			int[] selRows = table.getSelectedRows();
			TableModel tm = table.getModel();
			if (selRows.length > 0) {
				Cartorio cartorioPesquisaRegistro = new Cartorio();
				cartorioPesquisaRegistro.setId((Long) tm.getValueAt(selRows[0], CartorioTableModel.ID));

				if (table.getSelectedRow() != -1) {
					Cartorio cartorio = CartorioDaoFacade.getCartorio(cartorioPesquisaRegistro);
					CartorioTableModel cartorioTableModel = (CartorioTableModel) table.getModel();
					cartorioTableModel.getCartorio(table.getSelectedRow());
					MainControlador.mostrarFrame(MainControlador.getFrameCadastroCartorio());
					MainControlador.getFrameCadastroCartorio().getCartorioHandle().setCartorio(cartorio);
					MainControlador.getFrameCadastroCartorio().getCartorioHandle().atualizarGui();
					MainControlador.getFrameCadastroCartorio().setFocusable(true);
					MainControlador.getFramePesquisaCartorio().setVisible(false);
				}
			}
		}
	}
}

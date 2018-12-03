package erp.banco;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import erp.main.MainControlador;

final class SelectionListener implements ListSelectionListener {

	JTable table;
	private final BancoDaoFacade bancoDaoFacade = new BancoDaoFacade();

	SelectionListener(JTable table) {
		this.table = table;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			int[] selRows = table.getSelectedRows();
			TableModel tm = table.getModel();
			if (selRows.length > 0) {
				Banco bancoPesquisaRegistro = new Banco();
				bancoPesquisaRegistro.setId((Long) tm.getValueAt(selRows[0], BancoTableModel.ID));

				if (table.getSelectedRow() != -1) {
					Banco banco = bancoDaoFacade.getRegistro(bancoPesquisaRegistro);
					BancoTableModel bancoTableModel = (BancoTableModel) table.getModel();
					bancoTableModel.getBanco(table.getSelectedRow());
					MainControlador.mostrarFrame(MainControlador.getFrameCadastroBanco());
					MainControlador.getFrameCadastroBanco().getBancoHandle().setBanco(banco);
					MainControlador.getFrameCadastroBanco().getBancoHandle().atualizarGui();
					MainControlador.getFrameCadastroBanco().setFocusable(true);
					MainControlador.getFramePesquisaBanco().setVisible(false);
				}
			}
		}
	}
}

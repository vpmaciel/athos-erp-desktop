package erp.banco;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import erp.main.MainGerenteEventos;

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
					MainGerenteEventos.mostrarFrame(MainGerenteEventos.getFrameCadastroBanco());
					MainGerenteEventos.getFrameCadastroBanco().getBancoHandle().setBanco(banco);
					MainGerenteEventos.getFrameCadastroBanco().getBancoHandle().atualizarGui();
					MainGerenteEventos.getFrameCadastroBanco().setFocusable(true);
					MainGerenteEventos.getFramePesquisaBanco().setVisible(false);
				}
			}
		}
	}
}

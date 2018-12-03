package erp.imovel;

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
				Imovel imovelPesquisaRegistro = new Imovel();
				imovelPesquisaRegistro.setId((Long) tm.getValueAt(selRows[0], ImovelTableModel.ID));

				if (table.getSelectedRow() != -1) {
					Imovel imovel = ImovelDaoFacade.getRegistro(imovelPesquisaRegistro);
					ImovelTableModel imovelTableModel = (ImovelTableModel) table.getModel();
					imovelTableModel.getImovel(table.getSelectedRow());
					MainControlador.mostrarFrame(MainControlador.getFrameCadastroImovel());
					MainControlador.getFrameCadastroImovel().getImovelHandle().setImovel(imovel);
					MainControlador.getFrameCadastroImovel().getImovelHandle().atualizarGui();
					MainControlador.getFrameCadastroImovel().setFocusable(true);
					MainControlador.getFramePesquisaImovel().setVisible(false);
				}
			}
		}
	}
}

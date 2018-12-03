package erp.agenda.recado;

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
				Recado recadoPesquisaRegistro = new Recado();
				recadoPesquisaRegistro.setId((Long) tm.getValueAt(selRows[0], RecadoTableModel.ID));

				if (table.getSelectedRow() != -1) {
					Recado recado = RecadoDaoFacade.getRegistro(recadoPesquisaRegistro);
					RecadoTableModel recadoTableModel = (RecadoTableModel) table.getModel();
					recadoTableModel.getRecado(table.getSelectedRow());
					MainControlador.mostrarFrame(MainControlador.getFrameCadastroRecado());
					MainControlador.getFrameCadastroRecado().getRecadoHandle().setRecado(recado);
					MainControlador.getFrameCadastroRecado().getRecadoHandle().atualizarGui();
					MainControlador.getFrameCadastroRecado().setFocusable(true);
					MainControlador.getFramePesquisaRecado().setVisible(false);
				}
			}
		}
	}
}
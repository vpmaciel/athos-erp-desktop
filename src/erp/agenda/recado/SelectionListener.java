package erp.agenda.recado;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import erp.main.MainGerenteEventos;

class SelectionListener implements ListSelectionListener {

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
					MainGerenteEventos.mostrarFrame(MainGerenteEventos.getFrameCadastroRecado());
					MainGerenteEventos.getFrameCadastroRecado().getRecadoHandle().setRecado(recado);
					MainGerenteEventos.getFrameCadastroRecado().getRecadoHandle().atualizarGui();
					MainGerenteEventos.getFrameCadastroRecado().setFocusable(true);
					MainGerenteEventos.getFramePesquisaRecado().setVisible(false);
				}
			}
		}
	}
}

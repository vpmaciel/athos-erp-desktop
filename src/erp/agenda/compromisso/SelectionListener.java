package erp.agenda.compromisso;

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
				Compromisso compromissoPesquisaRegistro = new Compromisso();
				compromissoPesquisaRegistro.setId((Long) tm.getValueAt(selRows[0], CompromissoTableModel.ID));

				if (table.getSelectedRow() != -1) {
					Compromisso compromisso = CompromissoDaoFacade.getRegistro(compromissoPesquisaRegistro);
					CompromissoTableModel compromissoTableModel = (CompromissoTableModel) table.getModel();
					compromissoTableModel.getCompromisso(table.getSelectedRow());
					MainGerenteEventos.mostrarFrame(MainGerenteEventos.getFrameCadastroCompromisso());
					MainGerenteEventos.getFrameCadastroCompromisso().getCompromissoHandle().setCompromisso(compromisso);
					MainGerenteEventos.getFrameCadastroCompromisso().getCompromissoHandle().atualizarGui();
					MainGerenteEventos.getFrameCadastroCompromisso().setFocusable(true);
					MainGerenteEventos.getFramePesquisaCompromisso().setVisible(false);
				}
			}
		}
	}
}

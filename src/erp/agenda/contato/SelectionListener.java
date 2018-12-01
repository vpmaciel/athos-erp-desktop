package erp.agenda.contato;

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
				Contato recadoPesquisaRegistro = new Contato();
				recadoPesquisaRegistro.setId((Long) tm.getValueAt(selRows[0], ContatoTableModel.ID));

				if (table.getSelectedRow() != -1) {
					Contato contato = ContatoDaoFacade.getRegistro(recadoPesquisaRegistro);
					ContatoTableModel contatoTableModel = (ContatoTableModel) table.getModel();
					contatoTableModel.getContato(table.getSelectedRow());
					MainGerenteEventos.mostrarFrame(MainGerenteEventos.getFrameCadastroAgendaContato());
					MainGerenteEventos.getFrameCadastroAgendaContato().getContatoHandle().setContato(contato);
					MainGerenteEventos.getFrameCadastroAgendaContato().getContatoHandle().atualizarGui();
					MainGerenteEventos.getFrameCadastroAgendaContato().setFocusable(true);
					MainGerenteEventos.getFramePesquisaAgendaContato().setVisible(false);
				}
			}
		}
	}
}

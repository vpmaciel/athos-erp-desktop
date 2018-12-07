package erp.agenda.contato;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import erp.main.MainCT;

final class ContatoSL implements ListSelectionListener {

	JTable table;

	ContatoSL(JTable table) {
		this.table = table;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			int[] selRows = table.getSelectedRows();
			TableModel tm = table.getModel();
			if (selRows.length > 0) {
				Contato recadoPesquisaRegistro = new Contato();
				recadoPesquisaRegistro.setId((Long) tm.getValueAt(selRows[0], ContatoTM.ID));

				if (table.getSelectedRow() != -1) {
					Contato contato = ContatoFAC.getRegistro(recadoPesquisaRegistro);
					ContatoTM contatoTM = (ContatoTM) table.getModel();
					contatoTM.getContato(table.getSelectedRow());
					MainCT.mostrarFrame(MainCT.getAgendaContatoFC());
					MainCT.getAgendaContatoFC().getContatoHandle().setContato(contato);
					MainCT.getAgendaContatoFC().getContatoHandle().atualizarGui();
					MainCT.getAgendaContatoFC().setFocusable(true);
					MainCT.getAgendaContatoFP().setVisible(false);
				}
			}
		}
	}
}

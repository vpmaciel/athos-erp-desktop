package erp.sindicato;

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
				Sindicato sindicatoPesquisaRegistro = new Sindicato();
				sindicatoPesquisaRegistro.setId((Long) tm.getValueAt(selRows[0], SindicatoTableModel.ID));

				if (table.getSelectedRow() != -1) {
					Sindicato sindicato = SindicatoDaoFacade.getRegistro(sindicatoPesquisaRegistro);
					SindicatoTableModel sindicatoTableModel = (SindicatoTableModel) table.getModel();
					sindicatoTableModel.getSindicato(table.getSelectedRow());
					MainControlador.mostrarFrame(MainControlador.getFrameCadastroSindicato());
					MainControlador.getFrameCadastroSindicato().getSindicatoHandle().setSindicato(sindicato);
					MainControlador.getFrameCadastroSindicato().getSindicatoHandle().atualizarGui();
					MainControlador.getFrameCadastroSindicato().setFocusable(true);
					MainControlador.getFramePesquisaSindicato().setVisible(false);
				}
			}
		}
	}
}

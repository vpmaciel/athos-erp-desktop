package erp.curriculo.idioma;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import erp.main.MainControl;

final class IdiomaSel implements ListSelectionListener {

	JTable table;

	IdiomaSel(JTable table) {
		this.table = table;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			int[] selRows = table.getSelectedRows();
			TableModel tm = table.getModel();
			if (selRows.length > 0) {
				Idioma IdiomaPesquisaRegistro = new Idioma();
				IdiomaPesquisaRegistro.setId((Long) tm.getValueAt(selRows[0], IdiomaTm.ID));

				if (table.getSelectedRow() != -1) {
					Idioma idioma = IdiomaFac.getRegistro(IdiomaPesquisaRegistro);
					IdiomaTm IdiomaTm = (IdiomaTm) table.getModel();
					IdiomaTm.getIdioma(table.getSelectedRow());
					MainControl.mostrarFrame(MainControl.getCurriculoIdiomaFc());
					MainControl.getCurriculoIdiomaFc().getIdiomaCont().setIdioma(idioma);
					MainControl.getCurriculoIdiomaFc().getIdiomaCont().atualizarGui();
					MainControl.getCurriculoIdiomaFc().setFocusable(true);
					MainControl.getCurriculoIdiomaFp().setVisible(false);
				}
			}
		}
	}
}

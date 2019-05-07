package erp.curriculo.experienciaprofissional;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import erp.main.MainCont;

final class ExperienciaProfissionalSel implements ListSelectionListener {

	JTable table;

	ExperienciaProfissionalSel(JTable table) {
		this.table = table;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			int[] selRows = table.getSelectedRows();
			TableModel tm = table.getModel();
			if (selRows.length > 0) {
				ExperienciaProfissional experienciaProfissionalPesquisaRegistro = new ExperienciaProfissional();
				experienciaProfissionalPesquisaRegistro.setId((Long) tm.getValueAt(selRows[0], ExperienciaProfissionalTm.ID));

				if (table.getSelectedRow() != -1) {
					ExperienciaProfissional experienciaProfissional = ExperienciaProfissionalFac.getRegistro(experienciaProfissionalPesquisaRegistro);
					ExperienciaProfissionalTm ExperienciaProfissionalTm = (ExperienciaProfissionalTm) table.getModel();
					ExperienciaProfissionalTm.getExperienciaProfissional(table.getSelectedRow());
					MainCont.mostrarFrame(MainCont.getCurriculoExperienciaProfissionalFc());
					MainCont.getCurriculoExperienciaProfissionalFc().getExperienciaProfissionalCont().setExperienciaProfissional(experienciaProfissional);
					MainCont.getCurriculoExperienciaProfissionalFc().getExperienciaProfissionalCont().atualizarGui();
					MainCont.getCurriculoExperienciaProfissionalFc().setFocusable(true);
					MainCont.getCurriculoExperienciaProfissionalFp().setVisible(false);
				}
			}
		}
	}
}

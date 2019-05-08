package erp.curriculo.objetivoprofissional;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import erp.main.MainCont;

final class ObjetivoProfissionalSel implements ListSelectionListener {

	JTable table;

	ObjetivoProfissionalSel(JTable table) {
		this.table = table;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			int[] selRows = table.getSelectedRows();
			TableModel tm = table.getModel();
			if (selRows.length > 0) {
				ObjetivoProfissional ObjetivoProfissionalPesquisaRegistro = new ObjetivoProfissional();
				ObjetivoProfissionalPesquisaRegistro.setId((Long) tm.getValueAt(selRows[0], ObjetivoProfissionalTm.ID));

				if (table.getSelectedRow() != -1) {
					ObjetivoProfissional objetivoProfissional = ObjetivoProfissionalFac.getRegistro(ObjetivoProfissionalPesquisaRegistro);
					ObjetivoProfissionalTm ObjetivoProfissionalTm = (ObjetivoProfissionalTm) table.getModel();
					ObjetivoProfissionalTm.getObjetivoProfissional(table.getSelectedRow());
					MainCont.mostrarFrame(MainCont.getCurriculoObjetivoProfissionalFc());
					MainCont.getCurriculoObjetivoProfissionalFc().getObjetivoProfissionalCont().setObjetivoProfissional(objetivoProfissional);
					MainCont.getCurriculoObjetivoProfissionalFc().getObjetivoProfissionalCont().atualizarGui();
					MainCont.getCurriculoObjetivoProfissionalFc().setFocusable(true);
					MainCont.getCurriculoObjetivoProfissionalFp().setVisible(false);
				}
			}
		}
	}
}

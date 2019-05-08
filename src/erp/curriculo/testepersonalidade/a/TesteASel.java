package erp.curriculo.testepersonalidade.a;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import erp.main.MainCont;

final class TesteASel implements ListSelectionListener {

	JTable table;

	TesteASel(JTable table) {
		this.table = table;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			int[] selRows = table.getSelectedRows();
			TableModel tm = table.getModel();
			if (selRows.length > 0) {
				TesteA testeAPesquisaRegistro = new TesteA();
				testeAPesquisaRegistro.setId((Long) tm.getValueAt(selRows[0], TesteATm.ID));

				if (table.getSelectedRow() != -1) {
					TesteA testeA = TesteAFac.getRegistro(testeAPesquisaRegistro);
					TesteATm TesteATm = (TesteATm) table.getModel();
					TesteATm.getTesteA(table.getSelectedRow());
					MainCont.mostrarFrame(MainCont.getCurriculoTesteAFc());
					MainCont.getCurriculoTesteAFc().getTesteACont().setTesteA(testeA);
					MainCont.getCurriculoTesteAFc().getTesteACont().atualizarGui();
					MainCont.getCurriculoTesteAFc().setFocusable(true);
					MainCont.getCurriculoTesteAFp().setVisible(false);
				}
			}
		}
	}
}

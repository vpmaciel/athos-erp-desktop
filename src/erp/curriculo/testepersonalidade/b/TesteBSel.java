package erp.curriculo.testepersonalidade.b;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import erp.main.MainCont;

final class TesteBSel implements ListSelectionListener {

	JTable table;

	TesteBSel(JTable table) {
		this.table = table;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			int[] selRows = table.getSelectedRows();
			TableModel tm = table.getModel();
			if (selRows.length > 0) {
				TesteB testeBPesquisaRegistro = new TesteB();
				testeBPesquisaRegistro.setId((Long) tm.getValueAt(selRows[0], TesteBTm.ID));

				if (table.getSelectedRow() != -1) {
					TesteB testeB = TesteBFac.getRegistro(testeBPesquisaRegistro);
					TesteBTm TesteBTm = (TesteBTm) table.getModel();
					TesteBTm.getTesteB(table.getSelectedRow());
					MainCont.mostrarFrame(MainCont.getCurriculoTesteBFc());
					MainCont.getCurriculoTesteBFc().getTesteBCont().setTesteB(testeB);
					MainCont.getCurriculoTesteBFc().getTesteBCont().atualizarGui();
					MainCont.getCurriculoTesteBFc().setFocusable(true);
					MainCont.getCurriculoTesteBFp().setVisible(false);
				}
			}
		}
	}
}

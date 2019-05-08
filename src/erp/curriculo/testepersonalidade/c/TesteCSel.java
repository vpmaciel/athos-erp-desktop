package erp.curriculo.testepersonalidade.c;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import erp.main.MainCont;

final class TesteCSel implements ListSelectionListener {

	JTable table;

	TesteCSel(JTable table) {
		this.table = table;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			int[] selRows = table.getSelectedRows();
			TableModel tm = table.getModel();
			if (selRows.length > 0) {
				TesteC testeCPesquisaRegistro = new TesteC();
				testeCPesquisaRegistro.setId((Long) tm.getValueAt(selRows[0], TesteCTm.ID));

				if (table.getSelectedRow() != -1) {
					TesteC testeC = TesteCFac.getRegistro(testeCPesquisaRegistro);
					TesteCTm TesteCTm = (TesteCTm) table.getModel();
					TesteCTm.getTesteC(table.getSelectedRow());
					MainCont.mostrarFrame(MainCont.getCurriculoTesteCFc());
					MainCont.getCurriculoTesteCFc().getTesteCCont().setTesteC(testeC);
					MainCont.getCurriculoTesteCFc().getTesteCCont().atualizarGui();
					MainCont.getCurriculoTesteCFc().setFocusable(true);
					MainCont.getCurriculoTesteCFp().setVisible(false);
				}
			}
		}
	}
}

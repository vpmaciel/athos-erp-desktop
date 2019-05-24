package erp.curriculo.teste.testedisc;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import erp.main.MainCont;

final class TesteDISCSel implements ListSelectionListener {

	JTable table;

	TesteDISCSel(JTable table) {
		this.table = table;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			int[] selRows = table.getSelectedRows();
			TableModel tm = table.getModel();
			if (selRows.length > 0) {
				TesteDISC testeDISCPesquisaRegistro = new TesteDISC();
				testeDISCPesquisaRegistro.setId((Long) tm.getValueAt(selRows[0], TesteDISCTm.ID));

				if (table.getSelectedRow() != -1) {
					TesteDISC testeDISC = TesteDISCFac.getRegistro(testeDISCPesquisaRegistro);
					TesteDISCTm TesteDISCTm = (TesteDISCTm) table.getModel();
					TesteDISCTm.getTesteDISC(table.getSelectedRow());
					MainCont.mostrarFrame(MainCont.getCurriculoTesteDISCFc());
					MainCont.getCurriculoTesteDISCFc().getTesteDISCCont().setTesteDISC(testeDISC);
					MainCont.getCurriculoTesteDISCFc().getTesteDISCCont().atualizarGui();
					MainCont.getCurriculoTesteDISCFc().setFocusable(true);
					MainCont.getCurriculoTesteDISCFp().setVisible(false);
				}
			}
		}
	}
}

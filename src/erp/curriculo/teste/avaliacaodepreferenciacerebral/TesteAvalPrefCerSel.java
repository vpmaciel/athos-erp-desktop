package erp.curriculo.teste.avaliacaodepreferenciacerebral;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import erp.main.MainCont;

final class TesteAvalPrefCerSel implements ListSelectionListener {

	JTable table;

	TesteAvalPrefCerSel(JTable table) {
		this.table = table;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			int[] selRows = table.getSelectedRows();
			TableModel tm = table.getModel();
			if (selRows.length > 0) {
				TesteAvalPrefCer testeAvalPrefCerPesquisaRegistro = new TesteAvalPrefCer();
				testeAvalPrefCerPesquisaRegistro.setId((Long) tm.getValueAt(selRows[0], TesteAvalPrefCerTm.ID));

				if (table.getSelectedRow() != -1) {
					TesteAvalPrefCer testeAvalPrefCer = TesteAvalPrefCerFac
							.getRegistro(testeAvalPrefCerPesquisaRegistro);
					TesteAvalPrefCerTm TesteAvalPrefCerTm = (TesteAvalPrefCerTm) table.getModel();
					TesteAvalPrefCerTm.getTesteAvalPrefCer(table.getSelectedRow());
					MainCont.mostrarFrame(MainCont.getCurriculoTesteAvalPrefCerFc());
					MainCont.getCurriculoTesteAvalPrefCerFc().getTesteAvalPrefCerCont()
							.setTesteAvalPrefCer(testeAvalPrefCer);
					MainCont.getCurriculoTesteAvalPrefCerFc().getTesteAvalPrefCerCont().atualizarGui();
					MainCont.getCurriculoTesteAvalPrefCerFc().setFocusable(true);
					MainCont.getCurriculoTesteAvalPrefCerFp().setVisible(false);
				}
			}
		}
	}
}

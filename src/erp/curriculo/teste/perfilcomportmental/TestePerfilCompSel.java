package erp.curriculo.teste.perfilcomportmental;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import erp.main.MainCont;

final class TestePerfilCompSel implements ListSelectionListener {

	JTable table;

	TestePerfilCompSel(JTable table) {
		this.table = table;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			int[] selRows = table.getSelectedRows();
			TableModel tm = table.getModel();
			if (selRows.length > 0) {
				TestePerfilComp testePerfilCompPesquisaRegistro = new TestePerfilComp();
				testePerfilCompPesquisaRegistro.setId((Long) tm.getValueAt(selRows[0], TestePerfilCompTm.ID));

				if (table.getSelectedRow() != -1) {
					TestePerfilComp testePerfilComp = TestePerfilCompFac.getRegistro(testePerfilCompPesquisaRegistro);
					TestePerfilCompTm TestePerfilCompTm = (TestePerfilCompTm) table.getModel();
					TestePerfilCompTm.getTestePerfilComp(table.getSelectedRow());
					MainCont.mostrarFrame(MainCont.getCurriculoTestePerfilCompFc());
					MainCont.getCurriculoTestePerfilCompFc().getTestePerfilCompCont()
							.setTestePerfilComp(testePerfilComp);
					MainCont.getCurriculoTestePerfilCompFc().getTestePerfilCompCont().atualizarGui();
					MainCont.getCurriculoTestePerfilCompFc().setFocusable(true);
					MainCont.getCurriculoTestePerfilCompFp().setVisible(false);
				}
			}
		}
	}
}

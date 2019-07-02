package erp.curriculo.teste.perfilcomportmental;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import erp.main.MainControl;

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
					MainControl.mostrarFrame(MainControl.getCurriculoTestePerfilCompFc());
					MainControl.getCurriculoTestePerfilCompFc().getTestePerfilCompCont()
							.setTestePerfilComp(testePerfilComp);
					MainControl.getCurriculoTestePerfilCompFc().getTestePerfilCompCont().atualizarGui();
					MainControl.getCurriculoTestePerfilCompFc().setFocusable(true);
					MainControl.getCurriculoTestePerfilCompFp().setVisible(false);
				}
			}
		}
	}
}

package erp.empresa;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import erp.main.MainCont;

final class EmpresaSel implements ListSelectionListener {

	JTable table;

	EmpresaSel(JTable table) {
		this.table = table;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			int[] selRows = table.getSelectedRows();
			TableModel tm = table.getModel();
			if (selRows.length > 0) {
				Empresa empresaPesquisaRegistro = new Empresa();
				empresaPesquisaRegistro.setId((Long) tm.getValueAt(selRows[0], EmpresaTm.ID));

				if (table.getSelectedRow() != -1) {
					Empresa empresa = EmpresaFac.getRegistro(empresaPesquisaRegistro);
					EmpresaTm empresaTm = (EmpresaTm) table.getModel();
					empresaTm.getEmpresa(table.getSelectedRow());
					MainCont.mostrarFrame(MainCont.getEmpresaFc());
					MainCont.getEmpresaFc().getEmpresaHandle().setEmpresa(empresa);
					MainCont.getEmpresaFc().getEmpresaHandle().atualizarGui();
					MainCont.getEmpresaFc().setFocusable(true);
					MainCont.getEmpresaFp().setVisible(false);
				}
			}
		}
	}
}

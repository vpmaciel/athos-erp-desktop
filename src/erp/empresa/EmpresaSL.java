package erp.empresa;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import erp.main.MainCT;

final class EmpresaSL implements ListSelectionListener {

	JTable table;

	EmpresaSL(JTable table) {
		this.table = table;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			int[] selRows = table.getSelectedRows();
			TableModel tm = table.getModel();
			if (selRows.length > 0) {
				Empresa empresaPesquisaRegistro = new Empresa();
				empresaPesquisaRegistro.setId((Long) tm.getValueAt(selRows[0], EmpresaTM.ID));

				if (table.getSelectedRow() != -1) {
					Empresa empresa = EmpresaFAC.getRegistro(empresaPesquisaRegistro);
					EmpresaTM empresaTM = (EmpresaTM) table.getModel();
					empresaTM.getEmpresa(table.getSelectedRow());
					MainCT.mostrarFrame(MainCT.getEmpresaFC());
					MainCT.getEmpresaFC().getEmpresaHandle().setEmpresa(empresa);
					MainCT.getEmpresaFC().getEmpresaHandle().atualizarGui();
					MainCT.getEmpresaFC().setFocusable(true);
					MainCT.getEmpresaFP().setVisible(false);
				}
			}
		}
	}
}

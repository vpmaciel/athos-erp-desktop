package erp.empresa;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import erp.main.MainGerenteEventos;

class SelectionListener implements ListSelectionListener {

	JTable table;

	SelectionListener(JTable table) {
		this.table = table;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			int[] selRows = table.getSelectedRows();
			TableModel tm = table.getModel();
			if (selRows.length > 0) {
				Empresa empresaPesquisaRegistro = new Empresa();
				empresaPesquisaRegistro.setId((Long) tm.getValueAt(selRows[0], EmpresaTableModel.ID));

				if (table.getSelectedRow() != -1) {
					Empresa empresa = EmpresaDaoFacade.getRegistro(empresaPesquisaRegistro);
					EmpresaTableModel empresaTableModel = (EmpresaTableModel) table.getModel();
					empresaTableModel.getEmpresa(table.getSelectedRow());
					MainGerenteEventos.mostrarFrame(MainGerenteEventos.getFrameCadastroEmpresa());
					MainGerenteEventos.getFrameCadastroEmpresa().getEmpresaHandle().setEmpresa(empresa);
					MainGerenteEventos.getFrameCadastroEmpresa().getEmpresaHandle().atualizarGui();
					MainGerenteEventos.getFrameCadastroEmpresa().setFocusable(true);
					MainGerenteEventos.getFramePesquisaEmpresa().setVisible(false);
				}
			}
		}
	}
}

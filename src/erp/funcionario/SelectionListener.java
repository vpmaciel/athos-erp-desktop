package erp.funcionario;

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
				Funcionario funcionarioPesquisaRegistro = new Funcionario();
				funcionarioPesquisaRegistro.setId((Long) tm.getValueAt(selRows[0], FuncionarioTableModel.ID));

				if (table.getSelectedRow() != -1) {
					Funcionario funcionario = FuncionarioDaoFacade.getRegistro(funcionarioPesquisaRegistro);
					FuncionarioTableModel funcionarioTableModel = (FuncionarioTableModel) table.getModel();
					funcionarioTableModel.getFuncionario(table.getSelectedRow());
					MainGerenteEventos.mostrarFrame(MainGerenteEventos.getFrameCadastroFuncionario());
					MainGerenteEventos.getFrameCadastroFuncionario().getFuncionarioHandle().setFuncionario(funcionario);
					MainGerenteEventos.getFrameCadastroFuncionario().getFuncionarioHandle().atualizarGui();
					MainGerenteEventos.getFrameCadastroFuncionario().setFocusable(true);
					MainGerenteEventos.getFramePesquisaFuncionario().setVisible(false);
				}
			}
		}
	}
}

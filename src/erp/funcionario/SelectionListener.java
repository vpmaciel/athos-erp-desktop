package erp.funcionario;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import erp.main.MainControlador;

final class SelectionListener implements ListSelectionListener {

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
					MainControlador.mostrarFrame(MainControlador.getFrameCadastroFuncionario());
					MainControlador.getFrameCadastroFuncionario().getFuncionarioHandle().setFuncionario(funcionario);
					MainControlador.getFrameCadastroFuncionario().getFuncionarioHandle().atualizarGui();
					MainControlador.getFrameCadastroFuncionario().setFocusable(true);
					MainControlador.getFramePesquisaFuncionario().setVisible(false);
				}
			}
		}
	}
}

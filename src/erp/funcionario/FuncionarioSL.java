package erp.funcionario;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import erp.main.MainCT;

final class FuncionarioSL implements ListSelectionListener {

	JTable table;

	FuncionarioSL(JTable table) {
		this.table = table;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			int[] selRows = table.getSelectedRows();
			TableModel tm = table.getModel();
			if (selRows.length > 0) {
				Funcionario funcionarioPesquisaRegistro = new Funcionario();
				funcionarioPesquisaRegistro.setId((Long) tm.getValueAt(selRows[0], FuncionarioTM.ID));

				if (table.getSelectedRow() != -1) {
					Funcionario funcionario = FuncionarioFAC.getRegistro(funcionarioPesquisaRegistro);
					FuncionarioTM funcionarioTM = (FuncionarioTM) table.getModel();
					funcionarioTM.getFuncionario(table.getSelectedRow());
					MainCT.mostrarFrame(MainCT.getFuncionarioFC());
					MainCT.getFuncionarioFC().getFuncionarioHandle().setFuncionario(funcionario);
					MainCT.getFuncionarioFC().getFuncionarioHandle().atualizarGui();
					MainCT.getFuncionarioFC().setFocusable(true);
					MainCT.getFuncionarioFP().setVisible(false);
				}
			}
		}
	}
}

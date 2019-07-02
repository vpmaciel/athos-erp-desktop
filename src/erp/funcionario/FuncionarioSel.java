package erp.funcionario;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import erp.main.MainControl;

final class FuncionarioSel implements ListSelectionListener {

	JTable table;

	FuncionarioSel(JTable table) {
		this.table = table;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			int[] selRows = table.getSelectedRows();
			TableModel tm = table.getModel();
			if (selRows.length > 0) {
				Funcionario funcionarioPesquisaRegistro = new Funcionario();
				funcionarioPesquisaRegistro.setId((Long) tm.getValueAt(selRows[0], FuncionarioTm.ID));

				if (table.getSelectedRow() != -1) {
					Funcionario funcionario = FuncionarioFac.getRegistro(funcionarioPesquisaRegistro);
					FuncionarioTm funcionarioTm = (FuncionarioTm) table.getModel();
					funcionarioTm.getFuncionario(table.getSelectedRow());
					MainControl.mostrarFrame(MainControl.getCurriculoFc());
					MainControl.getFuncionarioFc().getFuncionarioCont().setFuncionario(funcionario);
					MainControl.getFuncionarioFc().getFuncionarioCont().atualizarGui();
					MainControl.getFuncionarioFc().setFocusable(true);
					MainControl.getFuncionarioFp().setVisible(false);
				}
			}
		}
	}
}

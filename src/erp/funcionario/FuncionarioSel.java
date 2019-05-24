package erp.funcionario;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import erp.main.MainCont;

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
					MainCont.mostrarFrame(MainCont.getCurriculoFc());
					MainCont.getFuncionarioFc().getFuncionarioCont().setFuncionario(funcionario);
					MainCont.getFuncionarioFc().getFuncionarioCont().atualizarGui();
					MainCont.getFuncionarioFc().setFocusable(true);
					MainCont.getFuncionarioFp().setVisible(false);
				}
			}
		}
	}
}

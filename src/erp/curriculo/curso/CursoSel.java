package erp.curriculo.curso;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import erp.main.MainControl;

final class CursoSel implements ListSelectionListener {

	JTable table;

	CursoSel(JTable table) {
		this.table = table;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			int[] selRows = table.getSelectedRows();
			TableModel tm = table.getModel();
			if (selRows.length > 0) {
				Curso CursoPesquisaRegistro = new Curso();
				CursoPesquisaRegistro.setId((Long) tm.getValueAt(selRows[0], CursoTm.ID));

				if (table.getSelectedRow() != -1) {
					Curso curso = CursoFac.getRegistro(CursoPesquisaRegistro);
					CursoTm CursoTm = (CursoTm) table.getModel();
					CursoTm.getCurso(table.getSelectedRow());
					MainControl.mostrarFrame(MainControl.getCurriculoCursoFc());
					MainControl.getCurriculoCursoFc().getCursoCont().setCurso(curso);
					MainControl.getCurriculoCursoFc().getCursoCont().atualizarGui();
					MainControl.getCurriculoCursoFc().setFocusable(true);
					MainControl.getCurriculoCursoFp().setVisible(false);
				}
			}
		}
	}
}

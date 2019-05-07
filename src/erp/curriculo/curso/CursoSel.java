package erp.curriculo.curso;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import erp.main.MainCont;

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
					MainCont.mostrarFrame(MainCont.getCurriculoCursoFc());
					MainCont.getCurriculoCursoFc().getCursoCont().setCurso(curso);
					MainCont.getCurriculoCursoFc().getCursoCont().atualizarGui();
					MainCont.getCurriculoCursoFc().setFocusable(true);
					MainCont.getCurriculoCursoFp().setVisible(false);
				}
			}
		}
	}
}

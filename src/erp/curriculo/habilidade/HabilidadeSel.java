package erp.curriculo.habilidade;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import erp.main.MainCont;

final class HabilidadeSel implements ListSelectionListener {

	JTable table;

	HabilidadeSel(JTable table) {
		this.table = table;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			int[] selRows = table.getSelectedRows();
			TableModel tm = table.getModel();
			if (selRows.length > 0) {
				Habilidade HabilidadePesquisaRegistro = new Habilidade();
				HabilidadePesquisaRegistro.setId((Long) tm.getValueAt(selRows[0], HabilidadeTm.ID));

				if (table.getSelectedRow() != -1) {
					Habilidade habilidade = HabilidadeFac.getRegistro(HabilidadePesquisaRegistro);
					HabilidadeTm HabilidadeTm = (HabilidadeTm) table.getModel();
					HabilidadeTm.getHabilidade(table.getSelectedRow());
					MainCont.mostrarFrame(MainCont.getCurriculoHabilidadeFc());
					MainCont.getCurriculoHabilidadeFc().getHabilidadeCont().setHabilidade(habilidade);
					MainCont.getCurriculoHabilidadeFc().getHabilidadeCont().atualizarGui();
					MainCont.getCurriculoHabilidadeFc().setFocusable(true);
					MainCont.getCurriculoHabilidadeFp().setVisible(false);
				}
			}
		}
	}
}

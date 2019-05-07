package erp.curriculo.caracteristica;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import erp.main.MainCont;

final class CaracteristicaSel implements ListSelectionListener {

	JTable table;

	CaracteristicaSel(JTable table) {
		this.table = table;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			int[] selRows = table.getSelectedRows();
			TableModel tm = table.getModel();
			if (selRows.length > 0) {
				Caracteristica caracteristicaPesquisaRegistro = new Caracteristica();
				caracteristicaPesquisaRegistro.setId((Long) tm.getValueAt(selRows[0], CaracteristicaTm.ID));

				if (table.getSelectedRow() != -1) {
					Caracteristica caracteristica = CaracteristicaFac.getRegistro(caracteristicaPesquisaRegistro);
					CaracteristicaTm CaracteristicaTm = (CaracteristicaTm) table.getModel();
					CaracteristicaTm.getCaracteristica(table.getSelectedRow());
					MainCont.mostrarFrame(MainCont.getCurriculoCaracteristicaFc());
					MainCont.getCurriculoCaracteristicaFc().getCaracteristicaCont().setCaracteristica(caracteristica);
					MainCont.getCurriculoCaracteristicaFc().getCaracteristicaCont().atualizarGui();
					MainCont.getCurriculoCaracteristicaFc().setFocusable(true);
					MainCont.getCurriculoCaracteristicaFp().setVisible(false);
				}
			}
		}
	}
}

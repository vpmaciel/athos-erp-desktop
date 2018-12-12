package erp.contador;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import erp.main.MainCont;

final class ContadorSl implements ListSelectionListener {

	JTable table;

	ContadorSl(JTable table) {
		this.table = table;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			int[] selRows = table.getSelectedRows();
			TableModel tm = table.getModel();
			if (selRows.length > 0) {
				Contador contadorPesquisaRegistro = new Contador();
				contadorPesquisaRegistro.setId((Long) tm.getValueAt(selRows[0], ContadorTm.ID));

				if (table.getSelectedRow() != -1) {
					Contador contador = ContadorFac.getRegistro(contadorPesquisaRegistro);
					ContadorTm contadorTm = (ContadorTm) table.getModel();
					contadorTm.getContador(table.getSelectedRow());
					MainCont.mostrarFrame(MainCont.getContadorFc());
					MainCont.getContadorFc().getContadorHandle().setContador(contador);
					MainCont.getContadorFc().getContadorHandle().atualizarGui();
					MainCont.getContadorFc().setFocusable(true);
					MainCont.getContadorFp().setVisible(false);
				}
			}
		}
	}
}

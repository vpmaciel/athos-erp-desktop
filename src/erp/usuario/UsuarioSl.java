package erp.usuario;

import java.util.List;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import erp.main.MainCont;

final class UsuarioSl implements ListSelectionListener {

	JTable table;

	UsuarioSl(JTable table) {
		this.table = table;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			int[] selRows = table.getSelectedRows();
			TableModel tm = table.getModel();
			if (selRows.length > 0) {
				Usuario usuarioPesquisaRegistro = new Usuario();
				usuarioPesquisaRegistro.setId((Long) tm.getValueAt(selRows[0], UsuarioTm.ID));

				if (table.getSelectedRow() != -1) {
					Usuario usuario = ((List<Usuario>) UsuarioFac.pesquisarRegistro(usuarioPesquisaRegistro))
							.get(0);
					UsuarioTm usuarioTm = (UsuarioTm) table.getModel();
					usuarioTm.getUsuario(table.getSelectedRow());

					MainCont.mostrarFrame(MainCont.getUsuarioFc());
					MainCont.getUsuarioFc().getUsuarioHandle().setUsuario(usuario);
					MainCont.getUsuarioFc().getUsuarioHandle().atualizarGUI();
					MainCont.getUsuarioFc().setFocusable(true);
					MainCont.getUsuarioFp().setVisible(false);
				}
			}
		}
	}
}

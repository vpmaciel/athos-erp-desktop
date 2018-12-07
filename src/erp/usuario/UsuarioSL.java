package erp.usuario;

import java.util.List;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import erp.main.MainCT;

final class UsuarioSL implements ListSelectionListener {

	JTable table;

	UsuarioSL(JTable table) {
		this.table = table;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			int[] selRows = table.getSelectedRows();
			TableModel tm = table.getModel();
			if (selRows.length > 0) {
				Usuario usuarioPesquisaRegistro = new Usuario();
				usuarioPesquisaRegistro.setId((Long) tm.getValueAt(selRows[0], UsuarioTM.ID));

				if (table.getSelectedRow() != -1) {
					Usuario usuario = ((List<Usuario>) UsuarioFAC.pesquisarRegistro(usuarioPesquisaRegistro))
							.get(0);
					UsuarioTM usuarioTM = (UsuarioTM) table.getModel();
					usuarioTM.getUsuario(table.getSelectedRow());

					MainCT.mostrarFrame(MainCT.getFrameCadastroUsuario());
					MainCT.getFrameCadastroUsuario().getUsuarioHandle().setUsuario(usuario);
					MainCT.getFrameCadastroUsuario().getUsuarioHandle().atualizarGUI();
					MainCT.getFrameCadastroUsuario().setFocusable(true);
					MainCT.getFramePesquisaUsuario().setVisible(false);
				}
			}
		}
	}
}

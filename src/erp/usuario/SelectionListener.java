package erp.usuario;

import java.util.List;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import erp.main.MainControlador;

final class SelectionListener implements ListSelectionListener {

	JTable table;

	SelectionListener(JTable table) {
		this.table = table;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			int[] selRows = table.getSelectedRows();
			TableModel tm = table.getModel();
			if (selRows.length > 0) {
				Usuario usuarioPesquisaRegistro = new Usuario();
				usuarioPesquisaRegistro.setId((Long) tm.getValueAt(selRows[0], UsuarioTableModel.COL_ID));

				if (table.getSelectedRow() != -1) {
					Usuario usuario = ((List<Usuario>) UsuarioDaoFacade.pesquisarRegistro(usuarioPesquisaRegistro))
							.get(0);
					UsuarioTableModel usuarioTableModel = (UsuarioTableModel) table.getModel();
					usuarioTableModel.getUsuario(table.getSelectedRow());

					MainControlador.mostrarFrame(MainControlador.getFrameCadastroUsuario());
					MainControlador.getFrameCadastroUsuario().getUsuarioHandle().setUsuario(usuario);
					MainControlador.getFrameCadastroUsuario().getUsuarioHandle().atualizarGUI();
					MainControlador.getFrameCadastroUsuario().setFocusable(true);
					MainControlador.getFramePesquisaUsuario().setVisible(false);
				}
			}
		}
	}
}

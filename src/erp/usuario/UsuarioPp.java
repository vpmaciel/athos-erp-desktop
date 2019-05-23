package erp.usuario;

import java.awt.BorderLayout;
import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

import arquitetura.gui.Tabela;

@SuppressWarnings("serial")
public final class UsuarioPp extends JPanel {

	private final UsuarioTm agenciaTableModel;
	private final JTable table;
	List<Usuario> usuarioList = null;

	public UsuarioPp() {
		setBorder(BorderFactory.createTitledBorder("USUÁRIO"));

		usuarioList = new LinkedList<>();
		agenciaTableModel = new UsuarioTm(usuarioList);

		table = new JTable();
		table.setModel(agenciaTableModel);
		for (int c = 0; c < table.getColumnCount(); ++c) {
			table.setDefaultRenderer(table.getColumnClass(c), Tabela.getDefaultTableCellRenderer());
		}
		Tabela.configurarLarguraColunasTabela(table, UsuarioTm.largura);
		((DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer())
				.setHorizontalAlignment(SwingConstants.RIGHT);
		table.getColumnModel().getColumn(0).setMaxWidth(0);
		table.getColumnModel().getColumn(0).setMinWidth(0);
		table.getColumnModel().getColumn(0).setPreferredWidth(0);
		table.setRowSelectionAllowed(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setRowHeight(30);
		table.setColumnSelectionAllowed(false);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(new Rectangle(0, 0, 720, 420));
		scrollPane.setViewportView(table);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		super.setLayout(new BorderLayout());
		super.add(scrollPane, "Center");
	}

	public void atualizarGui(List<Usuario> usuarios) {
		agenciaTableModel.setUsuarioList(usuarios);
		agenciaTableModel.fireTableDataChanged();
	}

	public UsuarioTm getUsuarioTableModel() {
		return agenciaTableModel;
	}

	public void iniciarControlador() {
		UsuarioSel listener = new UsuarioSel(table);
		table.getSelectionModel().addListSelectionListener(listener);
	}

	public int pesquisarRegistro(Usuario usuario) {
		usuarioList = new LinkedList<>();
		try {
			usuarioList = new LinkedList<>(UsuarioFac.pesquisarRegistro(usuario));
		} catch (Exception e) {
			System.out.println(e);
		}
		atualizarGui(usuarioList);
		return usuarioList.size();
	}
}

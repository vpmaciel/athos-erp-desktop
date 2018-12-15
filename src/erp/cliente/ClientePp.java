package erp.cliente;

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
public final class ClientePp extends JPanel {

	private final ClienteTm clienteTm;
	List<Cliente> clientes = null;
	private final JTable table;

	public ClientePp() {
		setBorder(BorderFactory.createTitledBorder("PESQUISA"));

		clientes = new LinkedList<>();
		clienteTm = new ClienteTm(clientes);

		table = new JTable();
		table.setModel(clienteTm);
		for (int c = 0; c < table.getColumnCount(); ++c) {
			table.setDefaultRenderer(table.getColumnClass(c), Tabela.getDefaultTableCellRenderer());
		}
		Tabela.configurarLarguraColunasTabela(table, ClienteTm.largura);
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

	public void atualizarGui(List<Cliente> clientes) {
		clienteTm.setClienteList(clientes);
		clienteTm.fireTableDataChanged();
	}

	public ClienteTm getClienteTableModel() {
		return clienteTm;
	}

	public void iniciarControlador() {
		ClienteSel listener = new ClienteSel(table);
		table.getSelectionModel().addListSelectionListener(listener);
	}

	public int pesquisarRegistroCliente(Cliente cliente) {
		clientes = new LinkedList<>();
		try {
			clientes = new LinkedList<>(ClienteFac.pesquisarRegistro(cliente));
		} catch (Exception e) {
			System.out.println(e);
		}
		atualizarGui(clientes);
		return clientes.size();
	}
}

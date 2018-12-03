package erp.cliente;

import java.awt.BorderLayout;
import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

import arquitetura.gui.Tabela;

@SuppressWarnings("serial")
public final class PPCliente extends JPanel {

	private final ClienteTableModel clienteTableModel;
	List<Cliente> clientes = null;
	private final JTable table;

	public PPCliente() {
		clientes = new LinkedList<>();
		clienteTableModel = new ClienteTableModel(clientes);

		table = new JTable();
		table.setModel(clienteTableModel);
		for (int c = 0; c < table.getColumnCount(); ++c) {
			table.setDefaultRenderer(table.getColumnClass(c), Tabela.getDefaultTableCellRenderer());
		}
		Tabela.configurarLarguraColunasTabela(table, ClienteTableModel.WIDTH);
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
		clienteTableModel.setClienteList(clientes);
		clienteTableModel.fireTableDataChanged();
	}

	public ClienteTableModel getClienteTableModel() {
		return clienteTableModel;
	}

	public void iniciarHandle() {
		SelectionListener listener = new SelectionListener(table);
		table.getSelectionModel().addListSelectionListener(listener);
	}

	public int pesquisarRegistroCliente(Cliente cliente) {
		clientes = new LinkedList<>();
		try {
			clientes = new LinkedList<>(ClienteDaoFacade.pesquisarRegistro(cliente));
		} catch (Exception e) {
			System.out.println(e);
		}
		atualizarGui(clientes);
		return clientes.size();
	}
}

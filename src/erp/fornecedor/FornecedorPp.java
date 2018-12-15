package erp.fornecedor;

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
public final class FornecedorPp extends JPanel {

	private final FornecedorTm fornecedorTm;
	List<Fornecedor> fornecedorList = null;
	private final JTable table;

	public FornecedorPp() {
		setBorder(BorderFactory.createTitledBorder("FORNECEDOR"));

		fornecedorList = new LinkedList<>();
		fornecedorTm = new FornecedorTm(fornecedorList);

		table = new JTable();
		table.setModel(fornecedorTm);
		for (int c = 0; c < table.getColumnCount(); ++c) {
			table.setDefaultRenderer(table.getColumnClass(c), Tabela.getDefaultTableCellRenderer());
		}
		Tabela.configurarLarguraColunasTabela(table, FornecedorTm.largura);
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

	public void atualizarGui(List<Fornecedor> fornecedors) {
		fornecedorTm.setFornecedorList(fornecedors);
		fornecedorTm.fireTableDataChanged();
	}

	public FornecedorTm getFornecedorTableModel() {
		return fornecedorTm;
	}

	public void iniciarControlador() {
		FornecedorSel listener = new FornecedorSel(table);
		table.getSelectionModel().addListSelectionListener(listener);
	}

	public int pesquisarRegistroFornecedor(Fornecedor fornecedor) {
		fornecedorList = new LinkedList<>();
		try {
			fornecedorList = new LinkedList<>(FornecedorFac.pesquisarRegistro(fornecedor));
		} catch (Exception e) {
			System.out.println(e);
		}
		atualizarGui(fornecedorList);
		return fornecedorList.size();
	}
}

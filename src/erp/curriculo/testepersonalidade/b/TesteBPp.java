package erp.curriculo.testepersonalidade.b;

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
public final class TesteBPp extends JPanel {

	List<TesteB> testeBs = null;
	private final TesteBTm testeBTm;
	private final JTable table;

	public TesteBPp() {
		setBorder(BorderFactory.createTitledBorder("CARACTERÍSTICAS"));

		testeBs = new LinkedList<>();
		testeBTm = new TesteBTm(testeBs);

		table = new JTable();
		table.setModel(testeBTm);
		for (int c = 0; c < table.getColumnCount(); ++c) {
			table.setDefaultRenderer(table.getColumnClass(c), Tabela.getDefaultTableCellRenderer());
		}
		Tabela.configurarLarguraColunasTabela(table, TesteBTm.largura);
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

	public void atualizarGui(List<TesteB> testeBs) {
		testeBTm.settesteBList(testeBs);
		testeBTm.fireTableDataChanged();
	}

	public TesteBTm getTesteBTableModel() {
		return testeBTm;
	}

	public void iniciarControlador() {
		TesteBSel listener = new TesteBSel(table);
		table.getSelectionModel().addListSelectionListener(listener);
	}

	public int pesquisarRegistroTesteB(TesteB testeB) {
		testeBs = new LinkedList<>();
		try {
			testeBs = new LinkedList<>(TesteBFac.pesquisarRegistro(testeB));
		} catch (Exception e) {
			System.out.println(e);
		}
		atualizarGui(testeBs);
		return testeBs.size();
	}
}

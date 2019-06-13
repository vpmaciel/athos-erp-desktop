package erp.curriculo.teste.testedisc;

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

import arquitetura.AOP;
import arquitetura.gui.Tabela;

@SuppressWarnings("serial")
public final class TesteDISCPp extends JPanel {

	private final JTable table;
	List<TesteDISC> testeDISCs = null;
	private final TesteDISCTm testeDISCTm;

	public TesteDISCPp() {
		setBorder(AOP.getBordaPainel());

		testeDISCs = new LinkedList<>();
		testeDISCTm = new TesteDISCTm(testeDISCs);

		table = new JTable();
		table.setModel(testeDISCTm);
		for (int c = 0; c < table.getColumnCount(); ++c) {
			table.setDefaultRenderer(table.getColumnClass(c), Tabela.getDefaultTableCellRenderer());
		}
		Tabela.configurarLarguraColunasTabela(table, TesteDISCTm.largura);
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

	public void atualizarGui(List<TesteDISC> testeDISCs) {
		testeDISCTm.settesteDISCList(testeDISCs);
		testeDISCTm.fireTableDataChanged();
	}

	public TesteDISCTm getTesteDISCTableModel() {
		return testeDISCTm;
	}

	public void iniciarControlador() {
		TesteDISCSel listener = new TesteDISCSel(table);
		table.getSelectionModel().addListSelectionListener(listener);
	}

	public int pesquisarRegistro(TesteDISC testeDISC) {
		testeDISCs = new LinkedList<>();
		try {
			testeDISCs = new LinkedList<>(TesteDISCFac.pesquisarRegistro(testeDISC));
		} catch (Exception e) {
			e.printStackTrace();
		}
		atualizarGui(testeDISCs);
		return testeDISCs.size();
	}
}

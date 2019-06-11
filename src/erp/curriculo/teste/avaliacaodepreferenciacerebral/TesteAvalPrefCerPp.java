package erp.curriculo.teste.avaliacaodepreferenciacerebral;

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
public final class TesteAvalPrefCerPp extends JPanel {

	private final JTable table;
	List<TesteAvalPrefCer> testeAvalPrefCers = null;
	private final TesteAvalPrefCerTm testeAvalPrefCerTm;

	public TesteAvalPrefCerPp() {
		setBorder(BorderFactory.createTitledBorder("TESTE DE PREFERÊNCIA CEREBRAL"));

		testeAvalPrefCers = new LinkedList<>();
		testeAvalPrefCerTm = new TesteAvalPrefCerTm(testeAvalPrefCers);

		table = new JTable();
		table.setModel(testeAvalPrefCerTm);
		for (int c = 0; c < table.getColumnCount(); ++c) {
			table.setDefaultRenderer(table.getColumnClass(c), Tabela.getDefaultTableCellRenderer());
		}
		Tabela.configurarLarguraColunasTabela(table, TesteAvalPrefCerTm.largura);
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

	public void atualizarGui(List<TesteAvalPrefCer> testeAvalPrefCers) {
		testeAvalPrefCerTm.settesteAvalPrefCerList(testeAvalPrefCers);
		testeAvalPrefCerTm.fireTableDataChanged();
	}

	public TesteAvalPrefCerTm getTesteAvalPrefCerTableModel() {
		return testeAvalPrefCerTm;
	}

	public void iniciarControlador() {
		TesteAvalPrefCerSel listener = new TesteAvalPrefCerSel(table);
		table.getSelectionModel().addListSelectionListener(listener);
	}

	public int pesquisarRegistro(TesteAvalPrefCer testeAvalPrefCer) {
		testeAvalPrefCers = new LinkedList<>();
		try {
			testeAvalPrefCers = new LinkedList<>(TesteAvalPrefCerFac.pesquisarRegistro(testeAvalPrefCer));
		} catch (Exception e) {
			e.printStackTrace();
		}
		atualizarGui(testeAvalPrefCers);
		return testeAvalPrefCers.size();
	}
}

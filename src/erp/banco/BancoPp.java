package erp.banco;

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
public final class BancoPp extends JPanel {

	private List<Banco> bancos = null;
	private final BancoTm bancoTm;
	private final JTable table;

	public BancoPp() {
		setBorder(BorderFactory.createTitledBorder("BANCO"));

		bancos = new LinkedList<>();
		bancoTm = new BancoTm(bancos);

		table = new JTable();
		table.setModel(bancoTm);
		for (int c = 0; c < table.getColumnCount(); ++c) {
			table.setDefaultRenderer(table.getColumnClass(c), Tabela.getDefaultTableCellRenderer());
		}
		Tabela.configurarLarguraColunasTabela(table, BancoTm.largura);
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

	public void atualizarGui(List<Banco> bancos) {
		bancoTm.setBancoList(bancos);
		bancoTm.fireTableDataChanged();
	}

	public BancoTm getBancoTableModel() {
		return bancoTm;
	}

	public void iniciarControlador() {
		BancoSel listener = new BancoSel(table);
		table.getSelectionModel().addListSelectionListener(listener);
	}

	public long pesquisarRegistroBanco(Banco banco) {
		bancos = new LinkedList<>();
		try {
			bancos = new LinkedList<>(BancoFac.pesquisarRegistro(banco));
		} catch (Exception e) {
			System.out.println(e);
		}
		atualizarGui(bancos);
		return bancos.size();
	}
}

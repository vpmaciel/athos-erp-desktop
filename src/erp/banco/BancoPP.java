package erp.banco;

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
public final class BancoPP extends JPanel {

	private final BancoTM bancoTM;
	List<Banco> bancos = null;
	private final JTable table;
	private final BancoFAC bancoFAC = new BancoFAC();

	public BancoPP() {
		bancos = new LinkedList<>();
		bancoTM = new BancoTM(bancos);

		table = new JTable();
		table.setModel(bancoTM);
		for (int c = 0; c < table.getColumnCount(); ++c) {
			table.setDefaultRenderer(table.getColumnClass(c), Tabela.getDefaultTableCellRenderer());
		}
		Tabela.configurarLarguraColunasTabela(table, BancoTM.largura);
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
		bancoTM.setBancoList(bancos);
		bancoTM.fireTableDataChanged();
	}

	public BancoTM getBancoTableModel() {
		return bancoTM;
	}

	public void iniciarHandle() {
		BancoSL listener = new BancoSL(table);
		table.getSelectionModel().addListSelectionListener(listener);
	}

	public long pesquisarRegistroBanco(Banco banco) {
		bancos = new LinkedList<>();
		try {
			bancos = new LinkedList<>(bancoFAC.pesquisarRegistro(banco));
		} catch (Exception e) {
			System.out.println(e);
		}
		atualizarGui(bancos);
		return bancos.size();
	}
}

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

import arquitetura.Sis;
import arquitetura.gui.Tabela;

@SuppressWarnings("serial")
public final class BancoPp extends JPanel {

	private final BancoTm bancoTm;
	private List<Banco> listBanco = null;
	private final JTable table;

	public BancoPp() {
		setBorder(Sis.getBordaPainel());

		listBanco = new LinkedList<>();
		bancoTm = new BancoTm(listBanco);

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

	public void atualizarGui(List<Banco> listBanco) {
		bancoTm.setBancoList(listBanco);
		bancoTm.fireTableDataChanged();
	}

	public BancoTm getBancoTableModel() {
		return bancoTm;
	}

	public void iniciarControlador() {
		BancoSel listener = new BancoSel(table);
		table.getSelectionModel().addListSelectionListener(listener);
	}

	public long pesquisarRegistro(Banco banco) {
		listBanco = new LinkedList<>();
		try {
			listBanco = new LinkedList<>(BancoFac.pesquisarRegistro(banco));
		} catch (Exception e) {
			e.printStackTrace();
		}
		atualizarGui(listBanco);
		return listBanco.size();
	}
}

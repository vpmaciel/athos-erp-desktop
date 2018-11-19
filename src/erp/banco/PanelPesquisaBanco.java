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

import erp.aop.gui.Tabela;

@SuppressWarnings("serial")
public final class PanelPesquisaBanco extends JPanel {

	private final BancoTableModel bancoTableModel;
	List<Banco> bancos = null;
	private final JTable table;
	private final BancoDaoFacade bancoDaoFacade = new BancoDaoFacade();

	public PanelPesquisaBanco() {
		bancos = new LinkedList<>();
		bancoTableModel = new BancoTableModel(bancos);

		table = new JTable();
		table.setModel(bancoTableModel);
		for (int c = 0; c < table.getColumnCount(); ++c) {
			table.setDefaultRenderer(table.getColumnClass(c), Tabela.getDefaultTableCellRenderer());
		}
		Tabela.configurarLarguraColunasTabela(table, BancoTableModel.WIDTH);
		((DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer())
				.setHorizontalAlignment(SwingConstants.RIGHT);
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
		bancoTableModel.setBancoList(bancos);
		bancoTableModel.fireTableDataChanged();
	}

	public BancoTableModel getBancoTableModel() {
		return bancoTableModel;
	}

	public void iniciarHandle() {
		SelectionListener listener = new SelectionListener(table);
		table.getSelectionModel().addListSelectionListener(listener);
	}

	public long pesquisarRegistroBanco(Banco banco) {
		bancos = new LinkedList<>();
		try {
			bancos = new LinkedList<>(bancoDaoFacade.pesquisarRegistro(banco));
		} catch (Exception e) {
			System.out.println(e);
		}
		atualizarGui(bancos);
		return bancos.size();
	}
}

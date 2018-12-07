package erp.cartorio;

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
public final class CartorioPP extends JPanel {

	private final CartorioTM cartorioTM;
	List<Cartorio> cartorioList = null;
	private final JTable table;

	public CartorioPP() {
		cartorioList = new LinkedList<>();
		cartorioTM = new CartorioTM(cartorioList);

		table = new JTable();
		table.setModel(cartorioTM);
		for (int c = 0; c < table.getColumnCount(); ++c) {
			table.setDefaultRenderer(table.getColumnClass(c), Tabela.getDefaultTableCellRenderer());
		}
		Tabela.configurarLarguraColunasTabela(table, CartorioTM.largura);
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

	public void atualizarGui(List<Cartorio> cartorios) {
		cartorioTM.setCartorioList(cartorios);
		cartorioTM.fireTableDataChanged();
	}

	public CartorioTM getCartorioTableModel() {
		return cartorioTM;
	}

	public void iniciarHandle() {
		CartorioSL listener = new CartorioSL(table);
		table.getSelectionModel().addListSelectionListener(listener);
	}

	public int pesquisarRegistroCartorio(Cartorio cartorio) {
		cartorioList = new LinkedList<>();
		try {
			cartorioList = new LinkedList<>(CartorioFAC.pesquisarRegistroCartorio(cartorio));
		} catch (Exception e) {
			System.out.println(e);
		}
		atualizarGui(cartorioList);
		return cartorioList.size();
	}
}

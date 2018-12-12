package erp.imovel;

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
public final class ImovelPp extends JPanel {

	private final ImovelTm imovelTm;
	List<Imovel> imovelList = null;
	private final JTable table;

	public ImovelPp() {
		imovelList = new LinkedList<>();
		imovelTm = new ImovelTm(imovelList);

		table = new JTable();
		table.setModel(imovelTm);
		for (int c = 0; c < table.getColumnCount(); ++c) {
			table.setDefaultRenderer(table.getColumnClass(c), Tabela.getDefaultTableCellRenderer());
		}
		Tabela.configurarLarguraColunasTabela(table, ImovelTm.WIDTH);
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

	public void atualizarGui(List<Imovel> imovels) {
		imovelTm.setImovelList(imovels);
		imovelTm.fireTableDataChanged();
	}

	public ImovelTm getImovelTableModel() {
		return imovelTm;
	}

	public void iniciarHandle() {
		ImovelSl listener = new ImovelSl(table);
		table.getSelectionModel().addListSelectionListener(listener);
	}

	public int pesquisarRegistroImovel(Imovel imovel) {
		imovelList = new LinkedList<>();
		try {
			imovelList = new LinkedList<>(ImovelFac.pesquisarRegistro(imovel));
		} catch (Exception e) {
			System.out.println(e);
		}
		atualizarGui(imovelList);
		return imovelList.size();
	}
}

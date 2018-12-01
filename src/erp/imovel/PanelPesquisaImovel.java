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
public final class PanelPesquisaImovel extends JPanel {

	private final ImovelTableModel imovelTableModel;
	List<Imovel> imovelList = null;
	private final JTable table;

	public PanelPesquisaImovel() {
		imovelList = new LinkedList<>();
		imovelTableModel = new ImovelTableModel(imovelList);

		table = new JTable();
		table.setModel(imovelTableModel);
		for (int c = 0; c < table.getColumnCount(); ++c) {
			table.setDefaultRenderer(table.getColumnClass(c), Tabela.getDefaultTableCellRenderer());
		}
		Tabela.configurarLarguraColunasTabela(table, ImovelTableModel.WIDTH);
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

	public void atualizarGui(List<Imovel> imovels) {
		imovelTableModel.setImovelList(imovels);
		imovelTableModel.fireTableDataChanged();
	}

	public ImovelTableModel getImovelTableModel() {
		return imovelTableModel;
	}

	public void iniciarHandle() {
		SelectionListener listener = new SelectionListener(table);
		table.getSelectionModel().addListSelectionListener(listener);
	}

	public int pesquisarRegistroImovel(Imovel imovel) {
		imovelList = new LinkedList<>();
		try {
			imovelList = new LinkedList<>(ImovelDaoFacade.pesquisarRegistro(imovel));
		} catch (Exception e) {
			System.out.println(e);
		}
		atualizarGui(imovelList);
		return imovelList.size();
	}
}

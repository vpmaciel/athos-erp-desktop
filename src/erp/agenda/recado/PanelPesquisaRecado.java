package erp.agenda.recado;

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
public final class PanelPesquisaRecado extends JPanel {

	private final RecadoTableModel recadoTableModel;
	List<Recado> recadoList = null;
	private final JTable table;

	public PanelPesquisaRecado() {
		recadoList = new LinkedList<>();
		recadoTableModel = new RecadoTableModel(recadoList);

		table = new JTable();
		table.setModel(recadoTableModel);
		for (int c = 0; c < table.getColumnCount(); ++c) {
			table.setDefaultRenderer(table.getColumnClass(c), Tabela.getDefaultTableCellRenderer());
		}
		Tabela.configurarLarguraColunasTabela(table, RecadoTableModel.WIDTH);
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

	public void atualizarGui(List<Recado> recados) {
		recadoTableModel.setRecadoList(recados);
		recadoTableModel.fireTableDataChanged();
	}

	public RecadoTableModel getRecadoTableModel() {
		return recadoTableModel;
	}

	public void iniciarHandle() {
		SelectionListener listener = new SelectionListener(table);
		table.getSelectionModel().addListSelectionListener(listener);
	}

	public int pesquisarRegistroRecado(Recado recado) {
		recadoList = new LinkedList<>();
		try {
			recadoList = new LinkedList<>(RecadoDaoFacade.pesquisarRegistro(recado));
		} catch (Exception e) {
			System.out.println(e);
		}
		atualizarGui(recadoList);
		return recadoList.size();
	}
}

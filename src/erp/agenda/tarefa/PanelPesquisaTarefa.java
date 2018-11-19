package erp.agenda.tarefa;

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
public final class PanelPesquisaTarefa extends JPanel {

	private final TarefaTableModel tarefaTableModel;
	List<Tarefa> tarefaList = null;
	private final JTable table;

	public PanelPesquisaTarefa() {
		tarefaList = new LinkedList<>();
		tarefaTableModel = new TarefaTableModel(tarefaList);

		table = new JTable();
		table.setModel(tarefaTableModel);
		for (int c = 0; c < table.getColumnCount(); ++c) {
			table.setDefaultRenderer(table.getColumnClass(c), Tabela.getDefaultTableCellRenderer());
		}
		Tabela.configurarLarguraColunasTabela(table, TarefaTableModel.WIDTH);
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

	public void atualizarGui(List<Tarefa> tarefas) {
		tarefaTableModel.setTarefaList(tarefas);
		tarefaTableModel.fireTableDataChanged();
	}

	public TarefaTableModel getTarefaTableModel() {
		return tarefaTableModel;
	}

	public void iniciarHandle() {
		SelectionListener listener = new SelectionListener(table);
		table.getSelectionModel().addListSelectionListener(listener);
	}

	public int pesquisarRegistroTarefa(Tarefa tarefa) {
		tarefaList = new LinkedList<>();
		try {
			tarefaList = new LinkedList<>(TarefaDaoFacade.pesquisarRegistro(tarefa));
		} catch (Exception e) {
			System.out.println(e);
		}
		atualizarGui(tarefaList);
		return tarefaList.size();
	}
}

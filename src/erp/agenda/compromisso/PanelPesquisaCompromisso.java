package erp.agenda.compromisso;

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
public final class PanelPesquisaCompromisso extends JPanel {

	private final CompromissoTableModel agenciaTableModel;
	List<Compromisso> compromissoList = null;
	private final JTable table;

	public PanelPesquisaCompromisso() {
		compromissoList = new LinkedList<>();
		agenciaTableModel = new CompromissoTableModel(compromissoList);

		table = new JTable();
		table.setModel(agenciaTableModel);
		for (int c = 0; c < table.getColumnCount(); ++c) {
			table.setDefaultRenderer(table.getColumnClass(c), Tabela.getDefaultTableCellRenderer());
		}
		Tabela.configurarLarguraColunasTabela(table, CompromissoTableModel.WIDTH);
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

	public void atualizarGui(List<Compromisso> compromissos) {
		agenciaTableModel.setCompromissoList(compromissos);
		agenciaTableModel.fireTableDataChanged();
	}

	public CompromissoTableModel getCompromissoTableModel() {
		return agenciaTableModel;
	}

	public void iniciarHandle() {
		SelectionListener listener = new SelectionListener(table);
		table.getSelectionModel().addListSelectionListener(listener);
	}

	public int pesquisarRegistroCompromisso(Compromisso compromisso) {
		compromissoList = new LinkedList<>();
		try {
			compromissoList = new LinkedList<>(CompromissoDaoFacade.pesquisarRegistro(compromisso));
		} catch (Exception e) {
			System.out.println(e);
		}
		atualizarGui(compromissoList);
		return compromissoList.size();
	}
}

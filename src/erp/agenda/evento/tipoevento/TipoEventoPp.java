package erp.agenda.evento.tipoevento;

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
public final class TipoEventoPp extends JPanel {

	private final TipoEventoTm agenciaTableModel;
	List<TipoEvento> agendaList = null;
	private final JTable table;

	public TipoEventoPp() {
		setBorder(BorderFactory.createTitledBorder("TIPO DE EVENTO"));

		agendaList = new LinkedList<>();
		agenciaTableModel = new TipoEventoTm(agendaList);

		table = new JTable();
		table.setModel(agenciaTableModel);
		for (int c = 0; c < table.getColumnCount(); ++c) {
			table.setDefaultRenderer(table.getColumnClass(c), Tabela.getDefaultTableCellRenderer());
		}
		Tabela.configurarLarguraColunasTabela(table, TipoEventoTm.largura);
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

	public void atualizarGui(List<TipoEvento> tipoEventos) {
		agenciaTableModel.setTipoEventoList(tipoEventos);
		agenciaTableModel.fireTableDataChanged();
	}

	public TipoEventoTm getAgendaTableModel() {
		return agenciaTableModel;
	}

	public void iniciarControlador() {
		TipoEventoSel listener = new TipoEventoSel(table);
		table.getSelectionModel().addListSelectionListener(listener);
	}

	public int pesquisarRegistro(TipoEvento tipoEvento) {
		agendaList = new LinkedList<>();
		try {
			agendaList = new LinkedList<>(TipoEventoFac.pesquisarRegistro(tipoEvento));
		} catch (Exception e) {
			e.printStackTrace();
		}
		atualizarGui(agendaList);
		return agendaList.size();
	}
}

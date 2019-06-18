package erp.sindicato;

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
public final class SindicatoPp extends JPanel {

	private final SindicatoTm agenciaTableModel;
	List<Sindicato> sindicatoList = null;
	private final JTable table;

	public SindicatoPp() {
		setBorder(Sis.getBordaPainel());

		sindicatoList = new LinkedList<>();
		agenciaTableModel = new SindicatoTm(sindicatoList);

		table = new JTable();
		table.setModel(agenciaTableModel);
		for (int c = 0; c < table.getColumnCount(); ++c) {
			table.setDefaultRenderer(table.getColumnClass(c), Tabela.getDefaultTableCellRenderer());
		}
		Tabela.configurarLarguraColunasTabela(table, SindicatoTm.largura);
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

	public void atualizarGui(List<Sindicato> sindicatos) {
		agenciaTableModel.setSindicatoList(sindicatos);
		agenciaTableModel.fireTableDataChanged();
	}

	public SindicatoTm getSindicatoTableModel() {
		return agenciaTableModel;
	}

	public void iniciarControlador() {
		SindicatoSel listener = new SindicatoSel(table);
		table.getSelectionModel().addListSelectionListener(listener);
	}

	public int pesquisarRegistro(Sindicato sindicato) {
		sindicatoList = new LinkedList<>();
		try {
			sindicatoList = new LinkedList<>(SindicatoFac.pesquisarRegistro(sindicato));
		} catch (Exception e) {
			e.printStackTrace();
		}
		atualizarGui(sindicatoList);
		return sindicatoList.size();
	}
}

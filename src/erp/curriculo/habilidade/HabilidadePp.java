package erp.curriculo.habilidade;

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
public final class HabilidadePp extends JPanel {

	List<Habilidade> habilidades = null;
	private final HabilidadeTm habilidadeTm;
	private final JTable table;

	public HabilidadePp() {
		setBorder(BorderFactory.createTitledBorder("HABILIDADE"));

		habilidades = new LinkedList<>();
		habilidadeTm = new HabilidadeTm(habilidades);

		table = new JTable();
		table.setModel(habilidadeTm);
		for (int c = 0; c < table.getColumnCount(); ++c) {
			table.setDefaultRenderer(table.getColumnClass(c), Tabela.getDefaultTableCellRenderer());
		}
		Tabela.configurarLarguraColunasTabela(table, HabilidadeTm.largura);
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

	public void atualizarGui(List<Habilidade> habilidades) {
		habilidadeTm.setHabilidadeList(habilidades);
		habilidadeTm.fireTableDataChanged();
	}

	public HabilidadeTm getCaracteristicaTableModel() {
		return habilidadeTm;
	}

	public void iniciarControlador() {
		HabilidadeSel listener = new HabilidadeSel(table);
		table.getSelectionModel().addListSelectionListener(listener);
	}

	public int pesquisarRegistroCaracteristica(Habilidade Habilidade) {
		habilidades = new LinkedList<>();
		try {
			habilidades = new LinkedList<>(HabilidadeFac.pesquisarRegistro(Habilidade));
		} catch (Exception e) {
			System.out.println(e);
		}
		atualizarGui(habilidades);
		return habilidades.size();
	}
}

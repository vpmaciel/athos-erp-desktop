package erp.veiculo.marca;

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
public final class VeiculoMarcaPp extends JPanel {

	private final VeiculoMarcaTm veiculoMarcaTm;
	List<VeiculoMarca> veiculoList = null;
	private final JTable table;

	public VeiculoMarcaPp() {
		veiculoList = new LinkedList<>();
		veiculoMarcaTm = new VeiculoMarcaTm(veiculoList);

		table = new JTable();
		table.setModel(veiculoMarcaTm);
		for (int c = 0; c < table.getColumnCount(); ++c) {
			table.setDefaultRenderer(table.getColumnClass(c), Tabela.getDefaultTableCellRenderer());
		}
		Tabela.configurarLarguraColunasTabela(table, VeiculoMarcaTm.largura);
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

	public void atualizarGui(List<VeiculoMarca> veiculoMarcas) {
		veiculoMarcaTm.setVeiculoMarcaList(veiculoMarcas);
		veiculoMarcaTm.fireTableDataChanged();
	}

	public VeiculoMarcaTm getVeiculoTableModel() {
		return veiculoMarcaTm;
	}

	public void iniciarHandle() {
		VeiculoMarcaSl listener = new VeiculoMarcaSl(table);
		table.getSelectionModel().addListSelectionListener(listener);
	}

	public int pesquisarRegistroVeiculoMarca(VeiculoMarca veiculoMarca) {
		veiculoList = new LinkedList<>();
		try {
			veiculoList = new LinkedList<>(VeiculoMarcaFac.pesquisarRegistro(veiculoMarca));
		} catch (Exception e) {
			System.out.println(e);
		}
		atualizarGui(veiculoList);
		return veiculoList.size();
	}
}
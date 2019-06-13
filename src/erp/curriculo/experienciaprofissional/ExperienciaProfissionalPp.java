package erp.curriculo.experienciaprofissional;

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

import arquitetura.AOP;
import arquitetura.gui.Tabela;

@SuppressWarnings("serial")
public final class ExperienciaProfissionalPp extends JPanel {

	List<ExperienciaProfissional> experienciaProfissionals = null;
	private final ExperienciaProfissionalTm experienciaProfissionalTm;
	private final JTable table;

	public ExperienciaProfissionalPp() {
		setBorder(AOP.getBordaPainel());

		experienciaProfissionals = new LinkedList<>();
		experienciaProfissionalTm = new ExperienciaProfissionalTm(experienciaProfissionals);

		table = new JTable();
		table.setModel(experienciaProfissionalTm);
		for (int c = 0; c < table.getColumnCount(); ++c) {
			table.setDefaultRenderer(table.getColumnClass(c), Tabela.getDefaultTableCellRenderer());
		}
		Tabela.configurarLarguraColunasTabela(table, ExperienciaProfissionalTm.largura);
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

	public void atualizarGui(List<ExperienciaProfissional> experienciaProfissionals) {
		experienciaProfissionalTm.setExperienciaProfissionalList(experienciaProfissionals);
		experienciaProfissionalTm.fireTableDataChanged();
	}

	public ExperienciaProfissionalTm getCaracteristicaTableModel() {
		return experienciaProfissionalTm;
	}

	public void iniciarControlador() {
		ExperienciaProfissionalSel listener = new ExperienciaProfissionalSel(table);
		table.getSelectionModel().addListSelectionListener(listener);
	}

	public int pesquisarRegistro(ExperienciaProfissional ExperienciaProfissional) {
		experienciaProfissionals = new LinkedList<>();
		try {
			experienciaProfissionals = new LinkedList<>(
					ExperienciaProfissionalFac.pesquisarRegistro(ExperienciaProfissional));
		} catch (Exception e) {
			e.printStackTrace();
		}
		atualizarGui(experienciaProfissionals);
		return experienciaProfissionals.size();
	}
}

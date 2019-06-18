package erp.curriculo;

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
import erp.funcionario.Funcionario;

@SuppressWarnings("serial")
public final class CurriculoPp extends JPanel {

	List<Funcionario> funcionarioList = null;
	private final CurriculoTm curriculoTm;
	private final JTable table;

	public CurriculoPp() {
		setBorder(Sis.getBordaPainel());

		funcionarioList = new LinkedList<>();
		curriculoTm = new CurriculoTm(funcionarioList);

		table = new JTable();
		table.setModel(curriculoTm);
		for (int c = 0; c < table.getColumnCount(); ++c) {
			table.setDefaultRenderer(table.getColumnClass(c), Tabela.getDefaultTableCellRenderer());
		}
		Tabela.configurarLarguraColunasTabela(table, CurriculoTm.largura);
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

	public void atualizarGui(List<Funcionario> funcionarioList) {
		curriculoTm.setFuncionarioList(funcionarioList);
		curriculoTm.fireTableDataChanged();
	}

	public CurriculoTm getCaracteristicaTableModel() {
		return curriculoTm;
	}

	public void iniciarControlador() {
		CurriculoSel listener = new CurriculoSel(table);
		table.getSelectionModel().addListSelectionListener(listener);
	}

	public int pesquisarRegistro(Funcionario funcionario) {
		funcionarioList = new LinkedList<>();
		try {
			funcionarioList = new LinkedList<>(CurriculoFac.pesquisarRegistro(funcionario));
		} catch (Exception e) {
			e.printStackTrace();
		}
		atualizarGui(funcionarioList);
		return funcionarioList.size();
	}
}

package erp.funcionario;

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
public final class FuncionarioPp extends JPanel {

	private final FuncionarioTm agenciaTableModel;
	List<Funcionario> funcionarioList = null;
	private final JTable table;

	public FuncionarioPp() {
		funcionarioList = new LinkedList<>();
		agenciaTableModel = new FuncionarioTm(funcionarioList);

		table = new JTable();
		table.setModel(agenciaTableModel);
		for (int c = 0; c < table.getColumnCount(); ++c) {
			table.setDefaultRenderer(table.getColumnClass(c), Tabela.getDefaultTableCellRenderer());
		}
		Tabela.configurarLarguraColunasTabela(table, FuncionarioTm.largura);
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

	public void atualizarGui(List<Funcionario> funcionarios) {
		agenciaTableModel.setFuncionarioList(funcionarios);
		agenciaTableModel.fireTableDataChanged();
	}

	public FuncionarioTm getFuncionarioTableModel() {
		return agenciaTableModel;
	}

	public void iniciarControlador() {
		FuncionarioSel listener = new FuncionarioSel(table);
		table.getSelectionModel().addListSelectionListener(listener);
	}

	public int pesquisarRegistroFuncionario(Funcionario funcionario) {
		funcionarioList = new LinkedList<>();
		try {
			funcionarioList = new LinkedList<>(FuncionarioFac.pesquisarRegistro(funcionario));
		} catch (Exception e) {
			System.out.println(e);
		}
		atualizarGui(funcionarioList);
		return funcionarioList.size();
	}
}

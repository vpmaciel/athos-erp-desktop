package erp.empresa;

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
public final class EmpresaPp extends JPanel {

	List<Empresa> empresaList = null;
	private final EmpresaTm empresaTm;
	private final JTable table;

	public EmpresaPp() {
		setBorder(AOP.getBordaPainel());

		empresaList = new LinkedList<>();
		empresaTm = new EmpresaTm(empresaList);

		table = new JTable();
		table.setModel(empresaTm);
		for (int c = 0; c < table.getColumnCount(); ++c) {
			table.setDefaultRenderer(table.getColumnClass(c), Tabela.getDefaultTableCellRenderer());
		}
		Tabela.configurarLarguraColunasTabela(table, EmpresaTm.largura);
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

	public void atualizarGui(List<Empresa> empresas) {
		empresaTm.setEmpresaList(empresas);
		empresaTm.fireTableDataChanged();
	}

	public EmpresaTm getEmpresaTableModel() {
		return empresaTm;
	}

	public void iniciarControlador() {
		EmpresaSel listener = new EmpresaSel(table);
		table.getSelectionModel().addListSelectionListener(listener);
	}

	public int pesquisarRegistro(Empresa empresa) {
		empresaList = new LinkedList<>();
		try {
			empresaList = new LinkedList<>(EmpresaFac.pesquisarRegistro(empresa));
		} catch (Exception e) {
			e.printStackTrace();
		}
		atualizarGui(empresaList);
		return empresaList.size();
	}
}

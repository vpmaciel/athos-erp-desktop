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

import arquitetura.gui.Tabela;

@SuppressWarnings("serial")
public final class EmpresaPP extends JPanel {

	private final EmpresaTM empresaTM;
	List<Empresa> empresaList = null;
	private final JTable table;

	public EmpresaPP() {
		empresaList = new LinkedList<>();
		empresaTM = new EmpresaTM(empresaList);

		table = new JTable();
		table.setModel(empresaTM);
		for (int c = 0; c < table.getColumnCount(); ++c) {
			table.setDefaultRenderer(table.getColumnClass(c), Tabela.getDefaultTableCellRenderer());
		}
		Tabela.configurarLarguraColunasTabela(table, EmpresaTM.largura);
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
		empresaTM.setEmpresaList(empresas);
		empresaTM.fireTableDataChanged();
	}

	public EmpresaTM getEmpresaTableModel() {
		return empresaTM;
	}

	public void iniciarHandle() {
		EmpresaSL listener = new EmpresaSL(table);
		table.getSelectionModel().addListSelectionListener(listener);
	}

	public int pesquisarRegistroEmpresa(Empresa empresa) {
		empresaList = new LinkedList<>();
		try {
			empresaList = new LinkedList<>(EmpresaFAC.pesquisarRegistro(empresa));
		} catch (Exception e) {
			System.out.println(e);
		}
		atualizarGui(empresaList);
		return empresaList.size();
	}
}

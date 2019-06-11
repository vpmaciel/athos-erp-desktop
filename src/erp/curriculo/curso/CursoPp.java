package erp.curriculo.curso;

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
public final class CursoPp extends JPanel {

	List<Curso> cursos = null;
	private final CursoTm cursoTm;
	private final JTable table;

	public CursoPp() {
		setBorder(BorderFactory.createTitledBorder("CURSO"));

		cursos = new LinkedList<>();
		cursoTm = new CursoTm(cursos);

		table = new JTable();
		table.setModel(cursoTm);
		for (int c = 0; c < table.getColumnCount(); ++c) {
			table.setDefaultRenderer(table.getColumnClass(c), Tabela.getDefaultTableCellRenderer());
		}
		Tabela.configurarLarguraColunasTabela(table, CursoTm.largura);
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

	public void atualizarGui(List<Curso> cursos) {
		cursoTm.setCursoList(cursos);
		cursoTm.fireTableDataChanged();
	}

	public CursoTm getCaracteristicaTableModel() {
		return cursoTm;
	}

	public void iniciarControlador() {
		CursoSel listener = new CursoSel(table);
		table.getSelectionModel().addListSelectionListener(listener);
	}

	public int pesquisarRegistro(Curso Curso) {
		cursos = new LinkedList<>();
		try {
			cursos = new LinkedList<>(CursoFac.pesquisarRegistro(Curso));
		} catch (Exception e) {
			e.printStackTrace();
		}
		atualizarGui(cursos);
		return cursos.size();
	}
}

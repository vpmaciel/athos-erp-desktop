package erp.agenda.contato;

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
public final class ContatoPp extends JPanel {

	List<Contato> contatoList = null;
	private final ContatoTm contatoTm;
	private final JTable table;

	public ContatoPp() {
		setBorder(AOP.getBordaPainel());
		contatoList = new LinkedList<>();
		contatoTm = new ContatoTm(contatoList);

		table = new JTable();
		table.setModel(contatoTm);
		for (int c = 0; c < table.getColumnCount(); ++c) {
			table.setDefaultRenderer(table.getColumnClass(c), Tabela.getDefaultTableCellRenderer());
		}
		Tabela.configurarLarguraColunasTabela(table, ContatoTm.largura);
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

	public void atualizarGui(List<Contato> contatos) {
		contatoTm.setContatoList(contatos);
		contatoTm.fireTableDataChanged();
	}

	public ContatoTm getContatoTableModel() {
		return contatoTm;
	}

	public void iniciarCont() {
		ContatoSl listener = new ContatoSl(table);
		table.getSelectionModel().addListSelectionListener(listener);
	}

	public int pesquisarRegistro(Contato contato) {
		contatoList = new LinkedList<>();
		try {
			contatoList = new LinkedList<>(ContatoFac.pesquisarRegistro(contato));
		} catch (Exception e) {
			e.printStackTrace();
		}
		atualizarGui(contatoList);
		return contatoList.size();
	}
}

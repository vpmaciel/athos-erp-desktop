package erp.veiculo.documento;

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
public final class DocumentoPp extends JPanel {

	List<Documento> documentos = null;
	private final DocumentoTm documentoTm;
	private final JTable table;

	public DocumentoPp() {
		setBorder(BorderFactory.createTitledBorder("CLIENTE"));

		documentos = new LinkedList<>();
		documentoTm = new DocumentoTm(documentos);

		table = new JTable();
		table.setModel(documentoTm);
		for (int c = 0; c < table.getColumnCount(); ++c) {
			table.setDefaultRenderer(table.getColumnClass(c), Tabela.getDefaultTableCellRenderer());
		}
		Tabela.configurarLarguraColunasTabela(table, DocumentoTm.largura);
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

	public void atualizarGui(List<Documento> documentos) {
		documentoTm.setDocumentoList(documentos);
		documentoTm.fireTableDataChanged();
	}

	public DocumentoTm getDocumentoTableModel() {
		return documentoTm;
	}

	public void iniciarControlador() {
		DocumentoSel listener = new DocumentoSel(table);
		table.getSelectionModel().addListSelectionListener(listener);
	}

	public int pesquisarRegistro(Documento documento) {
		documentos = new LinkedList<>();
		try {
			documentos = new LinkedList<>(DocumentoFac.pesquisarRegistro(documento));
		} catch (Exception e) {
			System.out.println(e);
		}
		atualizarGui(documentos);
		return documentos.size();
	}
}

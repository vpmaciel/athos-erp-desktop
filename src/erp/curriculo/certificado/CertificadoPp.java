package erp.curriculo.certificado;

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
public final class CertificadoPp extends JPanel {

	private final CertificadoTm certificadoTm;
	List<Certificado> certificados = null;
	private final JTable table;

	public CertificadoPp() {
		setBorder(BorderFactory.createTitledBorder("caracteristica"));

		certificados = new LinkedList<>();
		certificadoTm = new CertificadoTm(certificados);

		table = new JTable();
		table.setModel(certificadoTm);
		for (int c = 0; c < table.getColumnCount(); ++c) {
			table.setDefaultRenderer(table.getColumnClass(c), Tabela.getDefaultTableCellRenderer());
		}
		Tabela.configurarLarguraColunasTabela(table, CertificadoTm.largura);
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

	public void atualizarGui(List<Certificado> certificados) {
		certificadoTm.setCertificadoList(certificados);
		certificadoTm.fireTableDataChanged();
	}

	public CertificadoTm getCaracteristicaTableModel() {
		return certificadoTm;
	}

	public void iniciarControlador() {
		CertificadoSel listener = new CertificadoSel(table);
		table.getSelectionModel().addListSelectionListener(listener);
	}

	public int pesquisarRegistroCaracteristica(Certificado certificado) {
		certificados = new LinkedList<>();
		try {
			certificados = new LinkedList<>(CertificadoFac.pesquisarRegistro(certificado));
		} catch (Exception e) {
			System.out.println(e);
		}
		atualizarGui(certificados);
		return certificados.size();
	}
}

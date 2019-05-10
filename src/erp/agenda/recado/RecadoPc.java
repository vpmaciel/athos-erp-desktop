package erp.agenda.recado;

import javax.swing.BorderFactory;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import arquitetura.gui.ConfiguracaoGui;
import arquitetura.gui.EntradaMaiuscula;
import arquitetura.gui.FocoEvento;
import arquitetura.gui.Gui;
import arquitetura.gui.registro.ToolBar;
import arquitetura.util.SpringUtilities;
import arquitetura.validacao.Mascara;

@SuppressWarnings("serial")
public final class RecadoPc extends JPanel implements Gui {

	private ConfiguracaoGui configuracaoGui;
	private JFormattedTextField fieldData;
	private JTextField fieldDestinatario;
	private JTextArea fieldRecado;
	private JTextField fieldRemetente;
	private JLabel labelData;
	private JLabel labelDestinatario;
	private JLabel labelRecado;
	private JLabel labelRemetente;
	private ToolBar toolBar;

	public RecadoPc() {
		iniciarLayout();
		iniciarGui();
		iniciarFocoControlador();
		iniciarGuiControlador();
	}

	@Override
	public void atualizarTable() {

	}

	@Override
	public ConfiguracaoGui getConfiguracaoGui() {
		return configuracaoGui;
	}

	public JFormattedTextField getGuiData() {
		return fieldData;
	}

	public JTextField getGuiDestinatario() {
		return fieldDestinatario;
	}

	public JTextArea getGuiRecado() {
		return fieldRecado;
	}

	public JTextField getGuiRemetente() {
		return fieldRemetente;
	}

	public ToolBar getToolBar() {
		return toolBar;
	}

	@Override
	public void iniciarControlador() {

	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		FocoEvento focoEvento = new FocoEvento(this);
	}

	@Override
	public void iniciarGui() {

		toolBar = new ToolBar();
		add(toolBar.getToolBar());

		labelData = new JLabel("DATA");
		add(labelData);

		fieldData = new JFormattedTextField(Mascara.getData());
		add(fieldData);

		labelRemetente = new JLabel("REMETENTE");
		add(labelRemetente);

		fieldRemetente = new JTextField();
		fieldRemetente.setDocument(new EntradaMaiuscula(50));
		add(fieldRemetente);

		labelDestinatario = new JLabel("DESTINATÁRIO");
		add(labelDestinatario);

		fieldDestinatario = new JTextField();
		fieldDestinatario.setDocument(new EntradaMaiuscula(14));
		add(fieldDestinatario);

		labelRecado = new JLabel("RECADO");
		add(labelRecado);

		fieldRecado = new JTextArea();
		fieldRecado.setLineWrap(true);
		fieldRecado.setDocument(new EntradaMaiuscula(500));
		add(fieldRecado);

		// Lay out the panel.
		SpringUtilities.makeCompactGrid(this, 9, 1, // rows, cols
				5, 5, // initX, initY
				5, 5); // xPad, yPad
		setOpaque(true); // content panes must be opaque
	}

	@Override
	public void iniciarGuiControlador() {
		configuracaoGui = new ConfiguracaoGui(this);
	}

	@Override
	public void iniciarLayout() {
		setBorder(BorderFactory.createTitledBorder("RECADO"));
		setLayout(new SpringLayout());
	}

	@Override
	public void iniciarTabela() {

	}

	@Override
	public void limparGui() {

	}

	@Override
	public void reiniciarGui() {

	}
}

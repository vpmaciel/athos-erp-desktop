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
import arquitetura.registro.ToolBar;
import arquitetura.util.SpringUtilities;
import arquitetura.validacao.Mascara;

@SuppressWarnings("serial")
public final class RecadoPc extends JPanel implements Gui {

	private ToolBar toolBar;
	private ConfiguracaoGui configuracaoGui;
	private JTextField textFieldDestinatario;
	private JTextArea textAreaRecado;
	private JLabel labelDestinatario;
	private JLabel labelRecado;
	private JTextField textFieldRemetente;
	private JFormattedTextField textFieldData;
	private JLabel labelRemetente;
	private JLabel labelData;

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

	public JTextArea getRecadoGui() {
		return textAreaRecado;
	}

	public JTextField getDestinatarioGui() {
		return textFieldDestinatario;
	}

	public JTextField getRemetenteGui() {
		return textFieldRemetente;
	}

	public JFormattedTextField getDataGui() {
		return textFieldData;
	}

	public ToolBar getToolBar() {
		return toolBar;
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

		textFieldData = new JFormattedTextField(Mascara.getData());
		add(textFieldData);

		labelRemetente = new JLabel("REMETENTE");
		add(labelRemetente);

		textFieldRemetente = new JTextField();
		textFieldRemetente.setDocument(new EntradaMaiuscula(50));
		add(textFieldRemetente);

		labelDestinatario = new JLabel("DESTINATÁRIO");
		add(labelDestinatario);

		textFieldDestinatario = new JTextField();
		textFieldDestinatario.setDocument(new EntradaMaiuscula(14));
		add(textFieldDestinatario);

		labelRecado = new JLabel("RECADO");
		add(labelRecado);

		textAreaRecado = new JTextArea();
		textAreaRecado.setLineWrap(true);
		textAreaRecado.setDocument(new EntradaMaiuscula(500));
		add(textAreaRecado);

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
	public void iniciarControlador() {

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

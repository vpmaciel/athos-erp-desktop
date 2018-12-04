package erp.agenda.recado;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import arquitetura.gui.FocusTabListener;
import arquitetura.gui.GUI;
import arquitetura.gui.GUIConfiguracao;
import arquitetura.gui.TamanhoUpperCase;
import arquitetura.registro.ToolBar;
import arquitetura.util.SpringUtilities;

@SuppressWarnings("serial")
public final class PCRecado extends JPanel implements GUI {

	private ToolBar toolBar;
	private GUIConfiguracao gUIConfiguracao;
	private JTextField textFieldDestinatario;
	private JTextArea textAreaRecado;
	private JLabel labelDestinatario;
	private JLabel labelRecado;
	private JTextField textFieldRemetente;
	private JTextField textFieldData;
	private JLabel labelRemetente;
	private JLabel labelData;

	public PCRecado() {
		iniciarLayout();
		iniciarGUI();
		iniciarFocoControlador();
		iniciarGUIControlador();
	}

	@Override
	public void atualizarTable() {

	}

	@Override
	public GUIConfiguracao getGUIConfiguracao() {
		return gUIConfiguracao;
	}

	public JTextArea getTextFieldRecado() {
		return textAreaRecado;
	}

	public JTextField getTextFieldDestinatario() {
		return textFieldDestinatario;
	}

	public JTextField getTextFieldRemetente() {
		return textFieldRemetente;
	}

	public JTextField getTextFieldData() {
		return textFieldData;
	}

	public ToolBar getToolBar() {
		return toolBar;
	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		FocusTabListener focusTabListener = new FocusTabListener(this);
	}

	@Override
	public void iniciarGUI() {
		
		toolBar = new ToolBar();
		add(toolBar.getToolBar());

		labelData = new JLabel("DATA");
		add(labelData);

		textFieldData = new JTextField();
		textFieldData.setDocument(new TamanhoUpperCase(10));
		add(textFieldData);

		labelRemetente = new JLabel("REMETENTE");
		add(labelRemetente);

		textFieldRemetente = new JTextField();
		textFieldRemetente.setDocument(new TamanhoUpperCase(50));
		add(textFieldRemetente);

		labelDestinatario = new JLabel("DESTINATÁRIO");
		add(labelDestinatario);

		textFieldDestinatario = new JTextField();
		textFieldDestinatario.setDocument(new TamanhoUpperCase(14));
		add(textFieldDestinatario);

		labelRecado = new JLabel("RECADO");
		add(labelRecado);
	
		textAreaRecado = new JTextArea();
		textAreaRecado.setLineWrap(true);
		textAreaRecado.setDocument(new TamanhoUpperCase(500));
		add(textAreaRecado);

		// Lay out the panel.
		SpringUtilities.makeCompactGrid(this, 9, 1, // rows, cols
				5, 5, // initX, initY
				5, 5); // xPad, yPad
		setOpaque(true); // content panes must be opaque
	}

	@Override
	public void iniciarGUIControlador() {
		gUIConfiguracao = new GUIConfiguracao(this);
	}

	@Override
	public void iniciarControlador() {

	}

	@Override
	public void iniciarLayout() {
		setLayout(new SpringLayout());
	}

	@Override
	public void iniciarTabela() {

	}

	@Override
	public void limparGUI() {

	}

	@Override
	public void reiniciarGUI() {

	}
}

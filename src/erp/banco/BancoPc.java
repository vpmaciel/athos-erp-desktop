package erp.banco;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import arquitetura.gui.FocoEvento;
import arquitetura.gui.Gui;
import arquitetura.gui.ConfiguracaoGui;
import arquitetura.gui.EntradaMaiuscula;
import arquitetura.registro.ToolBar;
import arquitetura.util.SpringUtilities;
import arquitetura.validacao.Entrada;
import arquitetura.validacao.RegExp;

@SuppressWarnings("serial")
public final class BancoPc extends JPanel implements Gui {

	private BancoCont bancoCont;
	private JTextField textFieldCodigo;
	private JTextField textFieldNome;
	private ConfiguracaoGui configuracaoGui;
	private JLabel labelCodigo;
	private JLabel labelNome;
	private ToolBar toolBar;

	public BancoPc() {
		iniciarLayout();
		iniciarGUI();
		iniciarFocoControlador();
		iniciarGUIControlador();
	}

	@Override
	public void atualizarTable() {
	}

	public BancoCont getBancoHandle() {
		return bancoCont;
	}

	@Override
	public ConfiguracaoGui getGUIConfiguracao() {
		return configuracaoGui;
	}

	public JTextField getCodigoGUI() {
		return textFieldCodigo;
	}

	public JTextField getNomeGUI() {
		return textFieldNome;
	}

	public ToolBar getTB() {
		return toolBar;
	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		FocoEvento focoEvento = new FocoEvento(this);
	}

	@Override
	public void iniciarGUI() {
		toolBar = new ToolBar();

		add(toolBar.getToolBar());
		labelNome = new JLabel("NOME");
		add(labelNome);
		textFieldNome = new JTextField();
		textFieldNome.setDocument(new EntradaMaiuscula(50));
		add(textFieldNome);
		labelCodigo = new JLabel("CÓDIGO");
		add(labelCodigo);
		textFieldCodigo = new JTextField();
		textFieldCodigo.setDocument(new EntradaMaiuscula(10));
		add(textFieldCodigo);
		// Lay out the panel.
		SpringUtilities.makeCompactGrid(this, 5, 1, // rows, cols
				5, 5, // initX, initY
				5, 5); // xPad, yPad
		setOpaque(true); // content panes must be opaque

	}

	@Override
	public void iniciarGUIControlador() {
		configuracaoGui = new ConfiguracaoGui(this);
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
		configuracaoGui.limparGui();
	}

	@Override
	public void reiniciarGUI() {
	}

	public boolean validarCamposCadastro() {
		if (!Entrada.validar(textFieldNome, labelNome, RegExp.NOME, true)) {
			return false;
		}
		if (!Entrada.validar(textFieldCodigo, labelCodigo, RegExp.NUMERO_BANCO, false)) {
			return false;
		}
		return true;
	}
}
package erp.banco;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import arquitetura.gui.FocusTabListener;
import arquitetura.gui.GUI;
import arquitetura.gui.ConfiguracaoGUI;
import arquitetura.gui.TamanhoUpperCase;
import arquitetura.registro.ToolBar;
import arquitetura.util.SpringUtilities;
import arquitetura.validacao.Entrada;
import arquitetura.validacao.RegExp;

@SuppressWarnings("serial")
public final class BancoPC extends JPanel implements GUI {

	private BancoCT bancoCT;
	private JTextField textFieldCodigo;
	private JTextField textFieldNome;
	private ConfiguracaoGUI configuracaoGUI;
	private JLabel labelCodigo;
	private JLabel labelNome;
	private ToolBar toolBar;

	public BancoPC() {
		iniciarLayout();
		iniciarGUI();
		iniciarFocoControlador();
		iniciarGUIControlador();
	}

	@Override
	public void atualizarTable() {
	}

	public BancoCT getBancoHandle() {
		return bancoCT;
	}

	@Override
	public ConfiguracaoGUI getGUIConfiguracao() {
		return configuracaoGUI;
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
		FocusTabListener focusTabListener = new FocusTabListener(this);
	}

	@Override
	public void iniciarGUI() {
		toolBar = new ToolBar();

		add(toolBar.getToolBar());
		labelNome = new JLabel("NOME");
		add(labelNome);
		textFieldNome = new JTextField();
		textFieldNome.setDocument(new TamanhoUpperCase(50));
		add(textFieldNome);
		labelCodigo = new JLabel("CÓDIGO");
		add(labelCodigo);
		textFieldCodigo = new JTextField();
		textFieldCodigo.setDocument(new TamanhoUpperCase(10));
		add(textFieldCodigo);
		// Lay out the panel.
		SpringUtilities.makeCompactGrid(this, 5, 1, // rows, cols
				5, 5, // initX, initY
				5, 5); // xPad, yPad
		setOpaque(true); // content panes must be opaque

	}

	@Override
	public void iniciarGUIControlador() {
		configuracaoGUI = new ConfiguracaoGUI(this);
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
		configuracaoGUI.limparGui();
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

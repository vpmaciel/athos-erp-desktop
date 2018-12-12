package erp.usuario;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import arquitetura.gui.FocusTabListener;
import arquitetura.gui.GUI;
import arquitetura.gui.ConfiguracaoGUI;
import arquitetura.gui.EntradaMaiuscula;
import arquitetura.registro.ToolBar;
import arquitetura.util.SpringUtilities;
import arquitetura.validacao.Entrada;
import arquitetura.validacao.RegExp;

@SuppressWarnings("serial")
public final class UsuarioPc extends JPanel implements GUI {

	private UsuarioCont usuarioCont;
	private JTextField textFieldSenha;
	private JTextField textFieldNome;
	private ConfiguracaoGUI configuracaoGUI;
	private JLabel labelSenha;
	private JLabel labelNome;
	private ToolBar toolBar;

	public UsuarioPc() {
		iniciarLayout();
		iniciarGUI();
		iniciarFocoControlador();
		iniciarGUIControlador();
	}

	@Override
	public void atualizarTable() {
	}

	@Override
	public ConfiguracaoGUI getGUIConfiguracao() {
		return configuracaoGUI;
	}

	public JTextField getTextFieldNome() {
		return textFieldNome;
	}

	public JTextField getTextFieldSenha() {
		return textFieldSenha;
	}

	public ToolBar getTB() {
		return toolBar;
	}

	public UsuarioCont getUsuarioHandle() {
		return usuarioCont;
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
		textFieldNome.setDocument(new EntradaMaiuscula(10));
		add(textFieldNome);
		labelSenha = new JLabel("SENHA");
		add(labelSenha);
		textFieldSenha = new JTextField();
		textFieldSenha.setDocument(new EntradaMaiuscula(10));
		add(textFieldSenha);
		SpringUtilities.makeCompactGrid(this, 5, 1, 5, 5, 5, 5);
		setOpaque(true);
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
		if (!Entrada.validar(textFieldSenha, labelSenha, RegExp.NUMERO_BANCO, false)) {
			return false;
		}
		return true;
	}
}

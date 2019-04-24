package erp.usuario;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import arquitetura.gui.ConfiguracaoGui;
import arquitetura.gui.EntradaMaiuscula;
import arquitetura.gui.FocoEvento;
import arquitetura.gui.Gui;
import arquitetura.registro.ToolBar;
import arquitetura.util.SpringUtilities;
import arquitetura.validacao.Entrada;
import arquitetura.validacao.RegExp;

@SuppressWarnings("serial")
public final class UsuarioPc extends JPanel implements Gui {

	private UsuarioCont usuarioCont;
	private JTextField textFieldSenha;
	private JTextField textFieldNome;
	private ConfiguracaoGui configuracaoGui;
	private JLabel labelSenha;
	private JLabel labelNome;
	private ToolBar toolBar;

	public UsuarioPc() {
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

	public JTextField getNomeGui() {
		return textFieldNome;
	}

	public JTextField getSenhaGui() {
		return textFieldSenha;
	}

	public ToolBar getTB() {
		return toolBar;
	}

	public UsuarioCont getUsuarioCont() {
		return usuarioCont;
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
	public void iniciarGuiControlador() {
		configuracaoGui = new ConfiguracaoGui(this);
	}

	@Override
	public void iniciarControlador() {
	}

	@Override
	public void iniciarLayout() {
		setBorder(BorderFactory.createTitledBorder("USUÁRIO"));
		setLayout(new SpringLayout());
	}

	@Override
	public void iniciarTabela() {
	}

	@Override
	public void limparGui() {
		configuracaoGui.limparGui();
	}

	@Override
	public void reiniciarGui() {
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

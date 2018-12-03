package erp.usuario;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import arquitetura.gui.FocusTabListener;
import arquitetura.gui.Gui;
import arquitetura.gui.GuiGerenteEventos;
import arquitetura.gui.TamanhoUpperCase;
import arquitetura.registro.ToolBar;
import arquitetura.util.SpringUtilities;
import arquitetura.validacao.Entrada;
import arquitetura.validacao.RegExp;

@SuppressWarnings("serial")
public final class PCUsuario extends JPanel implements Gui {

	private UsuarioControlador usuarioControlador;
	private JTextField textFieldSenha;
	private JTextField textFieldNome;
	private GuiGerenteEventos guiGerenteEventos;
	private JLabel labelSenha;
	private JLabel labelNome;
	private ToolBar toolBar;

	public PCUsuario() {
		iniciarLayout();
		iniciarGui();
		iniciarFocusTabListener();
		iniciarGuiGerenteEventos();
	}

	@Override
	public void atualizarTable() {
	}

	@Override
	public GuiGerenteEventos getGuiGerenteEventos() {
		return guiGerenteEventos;
	}

	public JTextField getTextFieldNome() {
		return textFieldNome;
	}

	public JTextField getTextFieldSenha() {
		return textFieldSenha;
	}

	public ToolBar getToolBar() {
		return toolBar;
	}

	public UsuarioControlador getUsuarioHandle() {
		return usuarioControlador;
	}

	@Override
	public void iniciarFocusTabListener() {
		@SuppressWarnings("unused")
		FocusTabListener focusTabListener = new FocusTabListener(this);
	}

	@Override
	public void iniciarGui() {
		toolBar = new ToolBar();

		add(toolBar.getToolBar());
		labelNome = new JLabel("NOME");
		add(labelNome);
		textFieldNome = new JTextField();
		textFieldNome.setDocument(new TamanhoUpperCase(10));
		add(textFieldNome);
		labelSenha = new JLabel("SENHA");
		add(labelSenha);
		textFieldSenha = new JTextField();
		textFieldSenha.setDocument(new TamanhoUpperCase(10));
		add(textFieldSenha);
		SpringUtilities.makeCompactGrid(this, 5, 1, 5, 5, 5, 5);
		setOpaque(true);
	}

	@Override
	public void iniciarGuiGerenteEventos() {
		guiGerenteEventos = new GuiGerenteEventos(this);
	}

	@Override
	public void iniciarGerenteEventos() {
	}

	@Override
	public void iniciarLayout() {
		setLayout(new SpringLayout());
	}

	@Override
	public void iniciarTable() {
	}

	@Override
	public void limparGui() {
		guiGerenteEventos.limparGui();
	}

	@Override
	public void reiniciarBox() {
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

package erp.usuario;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import erp.aop.gui.FocusTabListener;
import erp.aop.gui.Gui;
import erp.aop.gui.GuiHandle;
import erp.aop.gui.TamanhoUpperCase;
import erp.aop.gui.registro.ToolBar;
import erp.aop.util.SpringUtilities;
import erp.aop.validacao.Entrada;
import erp.aop.validacao.RegExp;

@SuppressWarnings("serial")
public final class PanelCadastroUsuario extends JPanel implements Gui {

	private UsuarioGerenteEventos usuarioGerenteEventos;
	private JTextField textFieldSenha;
	private JTextField textFieldNome;
	private GuiHandle guiHandle;
	private JLabel labelSenha;
	private JLabel labelNome;
	private ToolBar toolBar;

	public PanelCadastroUsuario() {
		iniciarLayout();
		iniciarGui();
		iniciarFocusTabListener();
		iniciarGuiGerenteEventos();
	}

	@Override
	public void atualizarTable() {
	}

	@Override
	public GuiHandle getGuiGerenteEventos() {
		return guiHandle;
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

	public UsuarioGerenteEventos getUsuarioHandle() {
		return usuarioGerenteEventos;
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
		guiHandle = new GuiHandle(this);
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
		guiHandle.limparGui();
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

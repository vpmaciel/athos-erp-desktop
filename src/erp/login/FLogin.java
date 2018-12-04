package erp.login;

import java.awt.Dimension;
import java.awt.KeyboardFocusManager;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

import arquitetura.gui.FocusTabListener;
import arquitetura.gui.GUI;
import arquitetura.gui.GUIConfiguracao;
import arquitetura.gui.Imagem;
import erp.usuario.Usuario;

@SuppressWarnings("serial")
public final class FLogin extends JFrame implements GUI {

	private static Usuario usuario;
	private LoginGerenteEventos loginGerenteEventos;
	private PLogin pLogin;

	public static Usuario getUsuario() {
		return usuario;
	}

	public static void setUsuario(Usuario usuario) {
		FLogin.usuario = usuario;
	}

	public FLogin() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
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
		return null;
	}

	public LoginGerenteEventos getLoginHandle() {
		return loginGerenteEventos;
	}

	public PLogin getPanelInternalFrameLogin() {
		return pLogin;
	}

	public PLogin getPanelLogin() {
		return pLogin;
	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		FocusTabListener focusTabListener = new FocusTabListener(this);
	}

	@Override
	public void iniciarGUI() {
		setTitle("LOGIN");
		setIconImage(Imagem.getLogoTipoImage());
		pLogin = new PLogin();
		pLogin.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(pLogin);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (pLogin.isAncestorOf(focused)) {
							pLogin.scrollRectToVisible(focused.getBounds());
						}
					}
				});

		add(scrollPane);
		setContentPane(scrollPane);
		pack();
	}

	@Override
	public void iniciarGUIControlador() {

	}

	@Override
	public void iniciarControlador() {
		loginGerenteEventos = new LoginGerenteEventos();
		addWindowListener(loginGerenteEventos.new Frame());
		pLogin.getTextFieldSenha().addActionListener(loginGerenteEventos.new ButtonEntrarHandle());
		pLogin.getTextFieldSenha().addKeyListener(loginGerenteEventos.new ButtonEntrarTecladoHandle());
		pLogin.getButtonEntrar().addActionListener(loginGerenteEventos.new ButtonEntrarHandle());

	}

	@Override
	public void iniciarLayout() {
		setLayout(null);
		setPreferredSize(new Dimension(800, 600));
		setMinimumSize(new Dimension(800, 600));
		setSize(new Dimension(800, 600));
		setMaximumSize(new Dimension(800, 600));
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
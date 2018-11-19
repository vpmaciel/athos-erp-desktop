package erp.login;

import java.awt.Dimension;
import java.awt.KeyboardFocusManager;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

import erp.aop.gui.FocusTabListener;
import erp.aop.gui.Gui;
import erp.aop.gui.GuiHandle;
import erp.aop.gui.Imagem;
import erp.usuario.Usuario;

@SuppressWarnings("serial")
public final class FrameLogin extends JFrame implements Gui {

	private static Usuario usuario;
	private LoginGerenteEventos loginGerenteEventos;
	private PanelLogin panelLogin;
	
	public static Usuario getUsuario() {
		return usuario;
	}

	public static void setUsuario(Usuario usuario) {
		FrameLogin.usuario = usuario;
	}

	public FrameLogin() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
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
		return null;
	}

	public LoginGerenteEventos getLoginHandle() {
		return loginGerenteEventos;
	}

	public PanelLogin getPanelInternalFrameLogin() {
		return panelLogin;
	}

	public PanelLogin getPanelLogin() {
		return panelLogin;
	}

	@Override
	public void iniciarFocusTabListener() {
		@SuppressWarnings("unused")
		FocusTabListener focusTabListener = new FocusTabListener(this);
	}

	@Override
	public void iniciarGui() {
		setTitle("LOGIN");
		setIconImage(Imagem.getLogoTipoImage());
		panelLogin = new PanelLogin();
		panelLogin.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(panelLogin);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (panelLogin.isAncestorOf(focused)) {
							panelLogin.scrollRectToVisible(focused.getBounds());
						}
					}
				});

		add(scrollPane);
		setContentPane(scrollPane);
		pack();
	}

	@Override
	public void iniciarGuiGerenteEventos() {

	}

	@Override
	public void iniciarGerenteEventos() {
		loginGerenteEventos = new LoginGerenteEventos();
		addWindowListener(loginGerenteEventos.new Frame());
		panelLogin.getTextFieldSenha().addActionListener(loginGerenteEventos.new ButtonEntrarHandle());
		panelLogin.getTextFieldSenha().addKeyListener(loginGerenteEventos.new ButtonEntrarTecladoHandle());
		panelLogin.getButtonEntrar().addActionListener(loginGerenteEventos.new ButtonEntrarHandle());

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
	public void iniciarTable() {
	}

	@Override
	public void limparGui() {

	}

	@Override
	public void reiniciarBox() {
	}
}
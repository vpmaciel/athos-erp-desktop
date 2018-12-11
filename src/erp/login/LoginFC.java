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
import arquitetura.gui.ConfiguracaoGUI;
import arquitetura.gui.Imagem;
import erp.usuario.Usuario;

@SuppressWarnings("serial")
public final class LoginFC extends JFrame implements GUI {

	private static Usuario usuario;
	private LoginCT loginCT;
	private LoginPC loginPC;

	public static Usuario getUsuario() {
		return usuario;
	}

	public static void setUsuario(Usuario usuario) {
		LoginFC.usuario = usuario;
	}

	public LoginFC() {
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
	public ConfiguracaoGUI getGUIConfiguracao() {
		return null;
	}

	public LoginCT getLoginHandle() {
		return loginCT;
	}

	public LoginPC getPanelInternalFrameLogin() {
		return loginPC;
	}

	public LoginPC getPanelLogin() {
		return loginPC;
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
		loginPC = new LoginPC();
		loginPC.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(loginPC);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (loginPC.isAncestorOf(focused)) {
							loginPC.scrollRectToVisible(focused.getBounds());
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
		loginCT = new LoginCT();
		addWindowListener(loginCT.new Frame());
		loginPC.getTextFieldSenha().addActionListener(loginCT.new ButtonEntrarHandle());
		loginPC.getTextFieldSenha().addKeyListener(loginCT.new ButtonEntrarTecladoHandle());
		loginPC.getButtonEntrar().addActionListener(loginCT.new ButtonEntrarHandle());

	}

	@Override
	public void iniciarLayout() {
		setLayout(null);
		setPreferredSize(new Dimension(800, 420));
		setMinimumSize(new Dimension(800, 420));
		setSize(new Dimension(800, 420));
		setMaximumSize(new Dimension(800, 420));
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
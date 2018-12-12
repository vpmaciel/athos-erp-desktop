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
public final class LoginFc extends JFrame implements GUI {

	private static Usuario usuario;
	private LoginCont loginCont;
	private LoginPc loginPc;

	public static Usuario getUsuario() {
		return usuario;
	}

	public static void setUsuario(Usuario usuario) {
		LoginFc.usuario = usuario;
	}

	public LoginFc() {
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

	public LoginCont getLoginHandle() {
		return loginCont;
	}

	public LoginPc getPanelInternalFrameLogin() {
		return loginPc;
	}

	public LoginPc getPanelLogin() {
		return loginPc;
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
		loginPc = new LoginPc();
		loginPc.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(loginPc);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (loginPc.isAncestorOf(focused)) {
							loginPc.scrollRectToVisible(focused.getBounds());
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
		loginCont = new LoginCont();
		addWindowListener(loginCont.new Frame());
		loginPc.getTextFieldSenha().addActionListener(loginCont.new ButtonEntrar());
		loginPc.getTextFieldSenha().addKeyListener(loginCont.new ButtonEntrarTeclado());
		loginPc.getButtonEntrar().addActionListener(loginCont.new ButtonEntrar());

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
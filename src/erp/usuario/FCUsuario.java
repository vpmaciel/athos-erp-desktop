package erp.usuario;

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

@SuppressWarnings("serial")
public final class FCUsuario extends JFrame implements GUI {

	private UsuarioControlador usuarioControlador;
	private GUIConfiguracao gUIConfiguracao;
	private PCUsuario pCUsuario;

	public FCUsuario() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		iniciarLayout();
		iniciarGUI();
		iniciarFocoControlador();
		iniciarGUIControlador();
		iniciarControlador();
	}

	@Override
	public void atualizarTable() {

	}

	public void desabilitarGui() {

	}

	@Override
	public GUIConfiguracao getGUIConfiguracao() {
		return gUIConfiguracao;
	}

	public PCUsuario getPanelCadastroUsuario() {
		return pCUsuario;
	}

	public PCUsuario getPanelUsuario() {
		return pCUsuario;
	}

	public UsuarioControlador getUsuarioHandle() {
		return usuarioControlador;
	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		final FocusTabListener focusTabListener = new FocusTabListener(this);
	}

	@Override
	public void iniciarGUI() {
		setTitle("USUÁRIO");
		setIconImage(Imagem.getLogoTipoImage());
		pCUsuario = new PCUsuario();
		pCUsuario.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(pCUsuario);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (pCUsuario.isAncestorOf(focused)) {
							pCUsuario.scrollRectToVisible(focused.getBounds());
						}
					}
				});

		add(scrollPane);
		setContentPane(scrollPane);
		pack();

	}

	@Override
	public void iniciarGUIControlador() {
		gUIConfiguracao = new GUIConfiguracao(this);
	}

	@Override
	public void iniciarControlador() {
		usuarioControlador = new UsuarioControlador();
		addWindowListener(usuarioControlador.new Frame());
		pCUsuario.getToolBar().getButtonExcluiRegistro()
				.addActionListener(usuarioControlador.new ExcluiRegistro());
		pCUsuario.getToolBar().getButtonNovoFrame().addActionListener(usuarioControlador.new NovoFrame());
		pCUsuario.getToolBar().getButtonPesquisaRegistro()
				.addActionListener(usuarioControlador.new PesquisaRegistro());
		pCUsuario.getToolBar().getButtonImprimiUnicoRegistro()
				.addActionListener(usuarioControlador.new ImprimiUnicoRegistro());
		pCUsuario.getToolBar().getButtonImprimiTodosRegistros()
				.addActionListener(usuarioControlador.new ImprimiTodosRegistros());
		pCUsuario.getToolBar().getButtonSalvar().addActionListener(usuarioControlador.new Salva());
		pCUsuario.getToolBar().getButtonFechar().addActionListener(usuarioControlador.new FechaJanela());
		pCUsuario.getToolBar().getButtonSair().addActionListener(usuarioControlador.new SaidaSistema());
		pCUsuario.getToolBar().getButtonAjuda().addActionListener(usuarioControlador.new Ajuda());
		pCUsuario.getToolBar().getButtonHome().addActionListener(usuarioControlador.new Home());
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
		pCUsuario.limparGUI();
	}

	@Override
	public void reiniciarGUI() {

	}

	public boolean validarCamposCadastro() {
		return pCUsuario.validarCamposCadastro();
	}
}

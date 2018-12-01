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
import arquitetura.gui.Gui;
import arquitetura.gui.GuiHandle;
import arquitetura.gui.Imagem;

@SuppressWarnings("serial")
public final class FrameCadastroUsuario extends JFrame implements Gui {

	private UsuarioGerenteEventos usuarioGerenteEventos;
	private GuiHandle guiHandle;
	private PanelCadastroUsuario panelCadastroUsuario;

	public FrameCadastroUsuario() {
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		iniciarLayout();
		iniciarGui();
		iniciarFocusTabListener();
		iniciarGuiGerenteEventos();
		iniciarGerenteEventos();
	}

	@Override
	public void atualizarTable() {

	}

	public void desabilitarGui() {

	}

	@Override
	public GuiHandle getGuiGerenteEventos() {
		return guiHandle;
	}

	public PanelCadastroUsuario getPanelCadastroUsuario() {
		return panelCadastroUsuario;
	}

	public PanelCadastroUsuario getPanelUsuario() {
		return panelCadastroUsuario;
	}

	public UsuarioGerenteEventos getUsuarioHandle() {
		return usuarioGerenteEventos;
	}

	@Override
	public void iniciarFocusTabListener() {
		@SuppressWarnings("unused")
		final FocusTabListener focusTabListener = new FocusTabListener(this);
	}

	@Override
	public void iniciarGui() {
		setTitle("USUÁRIO");
		setIconImage(Imagem.getLogoTipoImage());
		panelCadastroUsuario = new PanelCadastroUsuario();
		panelCadastroUsuario.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(panelCadastroUsuario);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (panelCadastroUsuario.isAncestorOf(focused)) {
							panelCadastroUsuario.scrollRectToVisible(focused.getBounds());
						}
					}
				});

		add(scrollPane);
		setContentPane(scrollPane);
		pack();

	}

	@Override
	public void iniciarGuiGerenteEventos() {
		guiHandle = new GuiHandle(this);
	}

	@Override
	public void iniciarGerenteEventos() {
		usuarioGerenteEventos = new UsuarioGerenteEventos();
		addWindowListener(usuarioGerenteEventos.new Frame());
		panelCadastroUsuario.getToolBar().getButtonExcluiRegistro()
				.addActionListener(usuarioGerenteEventos.new ExcluiRegistro());
		panelCadastroUsuario.getToolBar().getButtonNovoFrame().addActionListener(usuarioGerenteEventos.new NovoFrame());
		panelCadastroUsuario.getToolBar().getButtonPesquisaRegistro()
				.addActionListener(usuarioGerenteEventos.new PesquisaRegistro());
		panelCadastroUsuario.getToolBar().getButtonImprimiUnicoRegistro()
				.addActionListener(usuarioGerenteEventos.new ImprimiUnicoRegistro());
		panelCadastroUsuario.getToolBar().getButtonImprimiTodosRegistros()
				.addActionListener(usuarioGerenteEventos.new ImprimiTodosRegistros());
		panelCadastroUsuario.getToolBar().getButtonSalvar().addActionListener(usuarioGerenteEventos.new Salva());
		panelCadastroUsuario.getToolBar().getButtonFechar().addActionListener(usuarioGerenteEventos.new FechaJanela());
		panelCadastroUsuario.getToolBar().getButtonSair().addActionListener(usuarioGerenteEventos.new SaidaSistema());
		panelCadastroUsuario.getToolBar().getButtonAjuda().addActionListener(usuarioGerenteEventos.new Ajuda());
		panelCadastroUsuario.getToolBar().getButtonHome().addActionListener(usuarioGerenteEventos.new Home());
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
		panelCadastroUsuario.limparGui();
	}

	@Override
	public void reiniciarBox() {

	}

	public boolean validarCamposCadastro() {
		return panelCadastroUsuario.validarCamposCadastro();
	}
}

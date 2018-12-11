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
import arquitetura.gui.ConfiguracaoGUI;
import arquitetura.gui.Imagem;

@SuppressWarnings("serial")
public final class UsuarioFC extends JFrame implements GUI {

	private UsuarioCT usuarioCT;
	private ConfiguracaoGUI configuracaoGUI;
	private UsuarioPC usuarioPC;

	public UsuarioFC() {
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
	public ConfiguracaoGUI getGUIConfiguracao() {
		return configuracaoGUI;
	}

	public UsuarioPC getPanelCadastroUsuario() {
		return usuarioPC;
	}

	public UsuarioPC getPanelUsuario() {
		return usuarioPC;
	}

	public UsuarioCT getUsuarioHandle() {
		return usuarioCT;
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
		usuarioPC = new UsuarioPC();
		usuarioPC.setOpaque(true); // content panes must be opaque

		final JScrollPane scrollPane = new JScrollPane(usuarioPC);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("focusOwner",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (!(evt.getNewValue() instanceof JComponent)) {
							return;
						}
						JComponent focused = (JComponent) evt.getNewValue();
						if (usuarioPC.isAncestorOf(focused)) {
							usuarioPC.scrollRectToVisible(focused.getBounds());
						}
					}
				});

		add(scrollPane);
		setContentPane(scrollPane);
		pack();

	}

	@Override
	public void iniciarGUIControlador() {
		configuracaoGUI = new ConfiguracaoGUI(this);
	}

	@Override
	public void iniciarControlador() {
		usuarioCT = new UsuarioCT();
		addWindowListener(usuarioCT.new Frame());
		usuarioPC.getTB().getExcluirBTN().addActionListener(usuarioCT.new Exclui());
		usuarioPC.getTB().getNovoBTN().addActionListener(usuarioCT.new Novo());
		usuarioPC.getTB().getPesquisarBTN().addActionListener(usuarioCT.new Pesquisa());
		usuarioPC.getTB().getImprimirBTN().addActionListener(usuarioCT.new Imprime());
		usuarioPC.getTB().getRelatorioBTN().addActionListener(usuarioCT.new Relatorio());
		usuarioPC.getTB().getSalvarBTN().addActionListener(usuarioCT.new Salva());
		usuarioPC.getTB().getFecharBTN().addActionListener(usuarioCT.new FechaJanela());
		usuarioPC.getTB().getSairBTN().addActionListener(usuarioCT.new SaidaSistema());
		usuarioPC.getTB().getAjudaBTN().addActionListener(usuarioCT.new Ajuda());
		usuarioPC.getTB().getHomeBTN().addActionListener(usuarioCT.new Home());
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
		usuarioPC.limparGUI();
	}

	@Override
	public void reiniciarGUI() {

	}

	public boolean validarCamposCadastro() {
		return usuarioPC.validarCamposCadastro();
	}
}
